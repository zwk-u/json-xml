package com.zwk.utils;

import com.zwk.json.JSONLexer;
import com.zwk.json.JSONParser;
import com.zwk.json.impl.SyntaxErrorListener;
import com.zwk.json.impl.XmlEmitter;
import com.zwk.xml.XMLLexer;
import com.zwk.xml.XMLParser;
import com.zwk.xml.impl.JSONEmitter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class JsonXmlUtil {

    public static String xmlToJson(String xml) {
        return xmlToJson(xml, null);
    }

    /**
     * xml 转成 json
     *
     * @param xml          xml
     * @param arrayElement 数组元素的标签
     * @return json
     */
    public static String xmlToJson(String xml, String arrayElement) {
        CharStream charStream = CharStreams.fromString(xml);
        XMLLexer lexer = new XMLLexer(charStream);
        CommonTokenStream input = new CommonTokenStream(lexer);
        XMLParser parser = new XMLParser(input);
        parser.addErrorListener(new SyntaxErrorListener());
        JSONEmitter jsonEmitter = new JSONEmitter();
        if (arrayElement != null) {
            jsonEmitter.setArrayElementName(arrayElement);
        }
        StringBuilder json = jsonEmitter.visit(parser.document());
        return json.toString();
    }

    public static String jsonToXml(String json) {
        return jsonToXml(json, null, true);
    }

    public static String jsonToXml(String json, boolean onlyTag) {
        return jsonToXml(json, null, onlyTag);
    }

    public static String jsonToXml(String json, String arrayElement) {
        return jsonToXml(json, arrayElement, true);
    }

    /**
     * json 转成 xml
     *
     * @param json         json字符串
     * @param arrayElement 数组元素的标签
     * @param onlyTag      json中key和value相同的是否转换为自闭和标签 默认为true
     * @return xml
     */
    public static String jsonToXml(String json, String arrayElement, boolean onlyTag) {
        CharStream charStream = CharStreams.fromString(json);
        JSONLexer lexer = new JSONLexer(charStream);
        CommonTokenStream input = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(input);
        parser.addErrorListener(new SyntaxErrorListener());
        XmlEmitter xmlEmitter = new XmlEmitter();
        xmlEmitter.setOnlyTag(onlyTag);
        if (arrayElement != null) {
            xmlEmitter.setArrayElementName(arrayElement);
        }
        StringBuilder xml = xmlEmitter.visit(parser.json());
        return xml.toString();
    }
}
