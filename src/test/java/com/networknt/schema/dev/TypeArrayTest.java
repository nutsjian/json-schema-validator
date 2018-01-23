package com.networknt.schema.dev;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class TypeArrayTest {

    @Test
    public void test01() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema_type_array_01.json");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[100,200]");

//            JsonNode node = Utils.getJsonNodeFromStringContent("[]");

//            JsonNode node = Utils.getJsonNodeFromStringContent("[100,\"200\"]");

            JsonNode node = Utils.getJsonNodeFromStringContent("[90]");

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

    @Test
    public void test02() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema_type_array_02.json");
            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",100]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",100, \"abc\", 123]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[13012011099,100]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"1301201109\",100]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",\"100\"]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",10]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[]");

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


    @Test
    public void test03() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema_type_array_03.json");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",100]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",100, \"abc\"]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",100, 123]");
//            JsonNode node = Utils.getJsonNodeFromStringContent("[]");
            JsonNode node = Utils.getJsonNodeFromStringContent("[\"13012011099\",100, \"bedroom\", \"room\"]");

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
