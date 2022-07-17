package com.bug.henong.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

public class StringEscapeEditor extends PropertyEditorSupport {
    private boolean escapeHTML;
    private boolean escapeJavaScript;
    private boolean escapeSQL;

    public StringEscapeEditor() {  super(); }
    public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeSQL) {
        super();
        this.escapeHTML = escapeHTML;
        this.escapeJavaScript = escapeJavaScript;
        this.escapeSQL = escapeSQL;
    }

    public static String escapeSql(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.replace(str, "'", "''");
    }

    @Override
    public void setAsText(String text) {
        if (text == null) {
            setValue(null);
        } else {
            String value = text;
            if (escapeHTML) {
                value = StringEscapeUtils.escapeHtml4(value);
            }
            if (escapeJavaScript) {
                value = StringEscapeUtils.escapeEcmaScript(value);
            }
            if (escapeSQL) {
                value = escapeSql(value);
            }
            setValue(value);     }
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString(): "";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringEscapeEditor(false, false, false));
    }
}