package com.networknt.schema.dev;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonMetaSchema;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class TestAll {

    @Test
    public void orderArrayTest() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/order_array.json");
            JsonNode node = Utils.getJsonNodeFromClasspath("dev/data/order_array_test.json");

            Set<ValidationMessage> errors = schema.validate(node);
            Iterator<ValidationMessage> iter = errors.iterator();

            while (iter.hasNext()) {
                ValidationMessage err = iter.next();
                System.out.println(err.getCode());
                System.out.println(err.getMessage());
                System.out.println(err.getType());
                System.out.println(err.getPath());
                System.out.println(Arrays.toString(err.getArguments()));
                System.out.println(err.getDetails());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema.json");
            JsonNode node = Utils.getJsonNodeFromClasspath("dev/data/test01.json");

            Set<ValidationMessage> errors = schema.validate(node);
            Iterator<ValidationMessage> iter = errors.iterator();

            while (iter.hasNext()) {
                ValidationMessage err = iter.next();
                System.out.println("code => " + err.getCode());
                System.out.println("message => " + err.getMessage());
                System.out.println("type => " + err.getType());
                System.out.println("path => " + err.getPath());
                System.out.println("arguments => " + Arrays.toString(err.getArguments()));
                System.out.println("details => " + err.getDetails());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
