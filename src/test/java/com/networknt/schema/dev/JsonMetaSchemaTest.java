package com.networknt.schema.dev;

import com.networknt.schema.JsonMetaSchema;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import org.junit.Test;

import java.io.InputStream;

public class JsonMetaSchemaTest {

    @Test
    public void test01() {
        try {
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dev/schema/schema.json");


            JsonSchema schema = factory.getSchema(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
