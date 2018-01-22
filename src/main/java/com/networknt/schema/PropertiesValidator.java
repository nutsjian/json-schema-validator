/*
 * Copyright (c) 2016 Network New Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.networknt.schema;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class PropertiesValidator extends BaseJsonValidator implements JsonValidator {
    public static final String PROPERTY = "properties";
    private static final Logger logger = LoggerFactory.getLogger(PropertiesValidator.class);
    /**
     * username: {"type": "string", "minLength": 11}
     * amount: {"type": "number", "minimum": 1000}
     * password: {"type": "string", "maxLength": 32}
     * ......
     */
    private Map<String, JsonSchema> schemas;

    // 在构造PropertiesValidator的时候，会获取该结点下的每个子结点
    // 然后对每个子结点创建新的JsonSchema，并加入到schemas中，schemas是一个map，key的格式类似：#/properties/username、#/properties/amount 等
    public PropertiesValidator(String schemaPath, JsonNode schemaNode, JsonSchema parentSchema, ValidationContext validationContext) {
        super(schemaPath, schemaNode, parentSchema, ValidatorTypeCode.PROPERTIES, validationContext);
        schemas = new HashMap<>();
        for (Iterator<String> it = schemaNode.fieldNames(); it.hasNext(); ) {
            String pname = it.next();
            // 例：pname = username
            // new JsonSchema(validationContext, #/properties/username, schemaNode.get(pname), parentSchema)
            // 其中 schemaNode 是：{ "username": {"type": "string", "minimum": 1000 } } ，所以schemaNode.get(pname) 得到的是 username 下的子结点node
            schemas.put(pname, new JsonSchema(validationContext, schemaPath + "/" + pname, schemaNode.get(pname), parentSchema));
        }
    }

    public Set<ValidationMessage> validate(JsonNode node, JsonNode rootNode, String at) {
        debug(logger, node, rootNode, at);

        Set<ValidationMessage> errors = new LinkedHashSet<>();

        // 遍历schemas 并逐一验证，那username来说
        for (String key : schemas.keySet()) {
            // {"type": "string", "minimum": 1000 }
            JsonSchema propertySchema = schemas.get(key);
            JsonNode propertyNode = node.get(key);

            if (propertyNode != null) {
                errors.addAll(propertySchema.validate(propertyNode, rootNode, at + "." + key));
            }
        }

        return Collections.unmodifiableSet(errors);
    }

}
