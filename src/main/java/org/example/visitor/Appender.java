package org.example.visitor;

public class Appender {
    private final StringBuilder stringBuilder = new StringBuilder();
    private int indent;
    public void indent() {
        indent(indent);
    }

    public void indent(int amount) {
        stringBuilder.append("  ".repeat(Math.max(0, amount)));
    }

    public void appendSingleQuote(String str) {
        appendWithQuotes(str, false);
    }

    public void appendDoubleQuote(String str) {
        appendWithQuotes(str, true);
    }

    private Appender appendWithQuotes(String str, boolean doubleQuotes) {
        String quotes = "'";
        if (doubleQuotes) {
            quotes = "\"";
        }
        stringBuilder.append(quotes);
        stringBuilder.append(str);
        stringBuilder.append(quotes);

        return this;
    }


    public void newLine() {
        stringBuilder.append("\n");
    }

    public void append(String str) {
        if (str != null) {
            stringBuilder.append(str);
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    public void increaseIndent() {
        indent++;
    }

    public void decreaseIndent() {
        indent--;
    }
}
