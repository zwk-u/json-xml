package com.zwk.json.impl;


import com.zwk.json.JSONBaseVisitor;
import com.zwk.json.JSONParser;

import java.util.List;
import java.util.Objects;

public class XmlEmitter extends JSONBaseVisitor<StringBuilder> {
    private static final String DEFAULT_ARRAY_ELEMENT_NAME = "element";
    private String arrayElementName = DEFAULT_ARRAY_ELEMENT_NAME;
    private boolean onlyTag = true;

    public void setArrayElementName(String arrayElementName) {
        this.arrayElementName = arrayElementName;
    }

    public void setOnlyTag(boolean onlyTag) {
        this.onlyTag = onlyTag;
    }

    @Override
    public StringBuilder visitJson(JSONParser.JsonContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(visit(ctx.value()));
        return sb;
    }

    @Override
    public StringBuilder visitArr(JSONParser.ArrContext ctx) {
        StringBuilder sb = new StringBuilder();
        List<JSONParser.ValueContext> value = ctx.value();
        for (JSONParser.ValueContext valueContext : value) {
            sb.append("<").append(arrayElementName).append(">");
            sb.append(visit(valueContext));
            sb.append("</").append(arrayElementName).append(">");
        }
        return sb;
    }

    @Override
    public StringBuilder visitPair(JSONParser.PairContext ctx) {
        StringBuilder sb = new StringBuilder();
        String tag = ctx.STRING().getText();
        tag = tag.substring(1, tag.length() - 1);
        sb.append("<").append(tag);
        StringBuilder child = visit(ctx.value());
        if (onlyTag && child.length() == tag.length() && Objects.equals(tag, child.toString())) {
            sb.append("/>");
        } else {
            sb.append(">")
                    .append(child)
                    .append("</")
                    .append(tag)
                    .append(">");
        }
        return sb;
    }

    @Override
    public StringBuilder visitAtomValue(JSONParser.AtomValueContext ctx) {
        return new StringBuilder(ctx.getText());
    }

    @Override
    public StringBuilder visitStringValue(JSONParser.StringValueContext ctx) {
        String text = ctx.getText();
        return new StringBuilder(text.substring(1, text.length() - 1));
    }

    @Override
    public StringBuilder visitObjValue(JSONParser.ObjValueContext ctx) {
        return visit(ctx.obj());
    }

    @Override
    public StringBuilder visitArrValue(JSONParser.ArrValueContext ctx) {
        return visit(ctx.arr());
    }

    @Override
    public StringBuilder visitObj(JSONParser.ObjContext ctx) {
        StringBuilder sb = new StringBuilder();
        List<JSONParser.PairContext> pair = ctx.pair();
        for (JSONParser.PairContext pairContext : pair) {
            sb.append(visit(pairContext));
        }
        return sb;
    }
}
