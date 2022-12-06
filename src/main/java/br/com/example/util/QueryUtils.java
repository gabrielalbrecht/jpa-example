package br.com.example.util;

import org.springframework.stereotype.Component;

@Component
public class QueryUtils {
    public String parameterValueContains(String value) {
        return new StringBuilder()
                .append('%')
                .append(value)
                .append('%')
                .toString();
    }

    public String parameterValueStartsWith(String value) {
        return new StringBuilder()
                .append(value)
                .append('%')
                .toString();
    }

    public String parameterValueEndsWith(String value) {
        return new StringBuilder()
                .append('%')
                .append(value)
                .toString();
    }
}
