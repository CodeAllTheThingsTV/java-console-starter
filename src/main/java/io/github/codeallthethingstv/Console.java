package io.github.codeallthethingstv.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.function.Function;

public class Console {
    private final BufferedReader _in;
    private final PrintStream _out;

    public Console(BufferedReader in, PrintStream out) {
        _in = in;
        _out = out;
    }

    public Console() {
        this(new BufferedReader(new InputStreamReader(System.in)), System.out);
    }

    public String read(final String text, final Object... args) {
        write(text, args);
        return read();
    }

    public Long readLongOrNull() {
        return fallbackNull(Long::parseLong, read());
    }

    public Long readLongOrNull(final String text, final Object... args) {
        write(text, args);
        return readLongOrNull();
    }

    public Integer readIntegerOrNull() {
        return fallbackNull(Integer::parseInt, read());
    }

    public Integer readIntegerOrNull(final String text, final Object... args) {
        write(text, args);
        return readIntegerOrNull();
    }

    public Double readDoubleOrNull() {
        return fallbackNull(Double::parseDouble, read());
    }

    public Double readDoubleOrNull(final String text, final Object... args) {
        write(text, args);
        return readDoubleOrNull();
    }

    private <T> T fallbackNull(Function<String, T> parser, String text) {
        return fallback(parser,text, null);
    }

    private <T> T fallback(Function<String, T> parser, String text, T fallback) {
        try {
            return parser.apply(text);
        } catch (Exception e) {
            return fallback;
        }
    }

    public String read() {
        try {
            return _in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Oops, this should not have happened!");
        }
    }

    public void write(final String text, final Object... args) {
        _out.println(String.format(text, args));
    }
}