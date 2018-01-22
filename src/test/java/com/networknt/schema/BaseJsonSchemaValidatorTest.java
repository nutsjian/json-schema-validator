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
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by steve on 22/10/16.
 */
public class BaseJsonSchemaValidatorTest {
    protected JsonNode getJsonNodeFromClasspath(String name) throws Exception {
        InputStream is1 = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(name);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(is1);
        return node;
    }

    @Test
    public void test02() throws Exception {
//        getJsonNodeFromClasspath("tests/id_schema/schema/features.json");
        getJsonNodeFromClasspath("dev/data/order_array_test.json");
    }

    protected JsonNode getJsonNodeFromStringContent(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(content);
        return node;
    }

    protected JsonNode getJsonNodeFromUrl(String url) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new URL(url));
        return node;
    }

    protected JsonSchema getJsonSchemaFromClasspath(String name) throws Exception {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(name);
        JsonSchema schema = factory.getSchema(is);
        return schema;
    }

    @Test
    public void test() throws Exception {
        getJsonSchemaFromClasspath("tests/id_schema/schema/features.json");
    }


    protected JsonSchema getJsonSchemaFromStringContent(String schemaContent) throws Exception {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
        JsonSchema schema = factory.getSchema(schemaContent);
        return schema;
    }

    protected JsonSchema getJsonSchemaFromUrl(String url) throws Exception {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
        JsonSchema schema = factory.getSchema(new URL(url));
        return schema;
    }

    protected JsonSchema getJsonSchemaFromJsonNode(JsonNode jsonNode) throws Exception {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
        JsonSchema schema = factory.getSchema(jsonNode);
        return schema;
    }
}
