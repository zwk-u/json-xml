package com.zwk.xml.impl;
import com.zwk.xml.XMLParser;
import com.zwk.xml.XMLParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JSONEmitter extends XMLParserBaseVisitor<StringBuilder> {
    private static final String DEFAULT_ARRAY_ELEMENT_NAME = "element";
    private String arrayElementName = DEFAULT_ARRAY_ELEMENT_NAME;

    Map<ParseTree, Boolean> isArray = new HashMap<>();

    public void setArrayElementName(String arrayElementName) {
        this.arrayElementName = arrayElementName;
    }

    @Override
    public StringBuilder visitDocument(XMLParser.DocumentContext ctx) {
        StringBuilder sb = new StringBuilder();
        StringBuilder child = visit(ctx.element());
        append(ctx, sb, child);
        return sb;
    }

    @Override
    public StringBuilder visitContent(XMLParser.ContentContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (ctx.element() != null && ctx.element().size() > 0) {
            int size = ctx.element().size();
            StringBuilder children = new StringBuilder();
            for (int i = 0; i < size; i++) {
                children.append(visit(ctx.element(i)));
                if (i != size - 1) {
                    children.append(",");
                }
            }
            append(ctx, sb, children);
        } else {
            String[] array = ctx.chardata()
                    .stream()
                    .map(c -> c.getText().replace("\n", ""))
                    .toArray(String[]::new);
            sb.append("\"")
                    .append(String.join("", array))
                    .append("\"");
            return sb;
        }
        return sb;
    }

    private void append(ParseTree ctx, StringBuilder sb, StringBuilder children) {
        String open = "{";
        String close = "}";
        Boolean b = isArray.get(ctx);
        if (b != null && b) {
            open = "[";
            close = "]";
        }
        sb.append(open).append(children).append(close);
    }

    @Override
    public StringBuilder visitElement(XMLParser.ElementContext ctx) {
        List<TerminalNode> name = ctx.Name();
        String left = name.get(0).getText();
        StringBuilder sb = new StringBuilder();
        if (Objects.equals(arrayElementName, left)) {
            ParserRuleContext parent = ctx.getParent();
            isArray.put(parent, true);
            sb.append(visit(ctx.content()));
            return sb;
        }
        sb.append("\"").append(left).append("\":");
        if (name.size() == 2) {
            String right = name.get(1).getText();
            if (!Objects.equals(left, right)) {
                throw new RuntimeException("element tag wrong! one is :" + left + "and one is : " + right);
            }
            sb.append(visit(ctx.content()));
        } else {
            sb.append("\"").append(left).append("\"");
        }
        return sb;
    }
}
