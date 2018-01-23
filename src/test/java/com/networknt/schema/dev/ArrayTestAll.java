package com.networknt.schema.dev;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class ArrayTestAll {

    @Test
    public void testArrayNumber01() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema_array_02.json");

            // 正常参数传递（1）
//            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,5]");

            // 参数传空，校验通过（2）
//            JsonNode node = Utils.getJsonNodeFromStringContent("[]");

            // 参数中存在字符串参数，校验失败（3）
            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,5,\"6\"]");


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
    public void testArrayNumber02() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema_array_03.json");

            // 正常参数传递（1）
//            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,5]");

            // 参数传空，校验失败，提示“至少3个”
//            JsonNode node = Utils.getJsonNodeFromStringContent("[]");

            // 参数传递多于6个，验证失败，提示“至多6个”
//            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,5,6,7]");

            // 参数传递个数符合，但是存在相同的参数，验证失败，提示“参数不能重复”
            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,4]");

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
    public void testArray04() {
        try {
            JsonSchema schema = Utils.getJsonSchemaFromClasspath("dev/schema/schema_array_04.json");

            // 正常参数传递（1）
//            JsonNode node = Utils.getJsonNodeFromStringContent("[\"abcdef\",1001,3,4,5,\"xyz\"]");

            // 参数传一个数组，元素只有一个字符串，校验成功，因为符合至少一个元素，且第一个元素是字符串，且长度大于等于6位
            // 虽然第二个参数是必须是数值的，但是这里没有传递第二个参数，所以第二个就无需校验了
            JsonNode node = Utils.getJsonNodeFromStringContent("[\"abcdef\"]");

            // 参数传递多于6个，验证失败，提示“至多6个”
//            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,5,6,7]");

            // 参数传递个数符合，但是存在相同的参数，验证失败，提示“参数不能重复”
//            JsonNode node = Utils.getJsonNodeFromStringContent("[1,2,3,4,4]");

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
    public void testArrayObject01() {

    }

}
