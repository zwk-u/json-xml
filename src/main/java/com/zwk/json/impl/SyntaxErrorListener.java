package com.zwk.json.impl;

import com.zwk.exception.ParseException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Collections;
import java.util.List;

public class SyntaxErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        StringBuilder sb = new StringBuilder();
        sb.append("rule stack: ")
                .append(stack)
                .append(" ")
                .append("line ")
                .append(line)
                .append(":")
                .append(charPositionInLine)
                .append(" at ")
                .append(offendingSymbol)
                .append(": ")
                .append(msg);
        throw new ParseException(sb.toString());
    }
}
