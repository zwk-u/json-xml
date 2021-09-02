package com.zwk;

import com.zwk.utils.JsonXmlUtil;
import org.junit.Test;

public class JsonXmlTest {
    @Test
    public void testXmlToJson01() {
        String xml = "<html>\n" +
                "<head>\n" +
                "    <title>Title</title>\n" +
                "    <person>\n" +
                "        <name>zs</name>\n" +
                "        <age>18</age>\n" +
                "    </person>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>nice!</p>" +
                "</body>\n" +
                "</html>\n";
        String json = JsonXmlUtil.xmlToJson(xml);
        System.out.println("json = " + json);
    }

    @Test
    public void testXmlToJson02() {
        String xml = "<html>\n" +
                "<head>\n" +
                "    <title>Title</title>\n" +
                "    <person>\n" +
                "        <name>\nzs</name>\n" +
                "        <age>18</age>\n" +
                "        <hobby>" +
                "           <array>play</array>" +//array
                "           <array>game</array>" +//array
                "           <array>tonight</array>" +//array
                "        </hobby>\n" +
                "    </person>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>nice!</p>" +
                "</body>\n" +
                "</html>\n";
        String json = JsonXmlUtil.xmlToJson(xml, "array");
        System.out.println("json = " + json);
    }

    @Test
    public void testXmlToJson03() {
        String xml = "<person>\n" +
                "        <name>zs</name>\n" +
                "        <age>18</age>\n" +
                "        <hobby>" +
                "           <array>      play</array>" +
                "        </hobby>\n" +
                "        <male/>" +//only tag
                "    </person>";
        String json = JsonXmlUtil.xmlToJson(xml);
        System.out.println("json = " + json);
    }

    @Test
    public void testJsonToXml04() {
        String json = "{\"person\":{\"age\":18}}";
        String xml = JsonXmlUtil.jsonToXml(json);
        System.out.println("xml = " + xml);
    }

    @Test
    public void testJsonToXml05() {
        String json = "{\"person\":{\"age\":18,\"hobby\":[\"play\",\"game\",\"tonight\"]}}";//array
        String xml = JsonXmlUtil.jsonToXml(json);
        System.out.println("xml = " + xml);
    }

    @Test
    public void testJsonToXml06() {
        String json = "{\"person\":{\"age\":18,\"hobby\":[\"play\",\"game\",\"tonight\"]}}";//array tag
        String xml = JsonXmlUtil.jsonToXml(json, "array");
        System.out.println("xml = " + xml);
    }

    @Test
    public void testJsonToXml07() {
        String json = "{\"person\":{\"age\":18,\"hobby\":[\"play\",\"game\",\"tonight\"],\"male\":\"male\"}}";//only tag
        String xml = JsonXmlUtil.jsonToXml(json, "array");
        System.out.println("xml = " + xml);
    }

    @Test
    public void testJsonToXml08() {
        String json = "{\"person\":{\"age\":18,\"hobby\":[\"play\",\"game\",\"tonight\"],\"male\":\"male\"}}";//only tag
        String xml = JsonXmlUtil.jsonToXml(json, false);
        System.out.println("xml = " + xml);
    }
    @Test
    public void testXmlToJson09() {
        String xml = "<person>\n" +
                "        <element>zs</element>\n" +
                "        <element>18</element>\n" +
                "        <element>" +
                "           <element>play</element>" +
                "        </element>\n" +
                "        <element><male/></element>" +//only tag
                "    </person>";
        String json = JsonXmlUtil.xmlToJson(xml);
        System.out.println("json = " + json);
    }
    @Test
    public void testJsonToXml10() {
        String json = "{\"person\":[\"zs\",\"18\",[\"play\"],{\"male\":\"male\"}]}";//only tag
        String xml = JsonXmlUtil.jsonToXml(json, true);
        System.out.println("xml = " + xml);
    }
}
