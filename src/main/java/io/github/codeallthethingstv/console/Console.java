package io.github.codeallthethingstv.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Optional;
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

    public Optional<Long> readLong() {
        return Optional.ofNullable(readLongOrNull());
    }

    public Optional<Long> readLong(final String text, final Object... args) {
        return Optional.ofNullable(readLongOrNull(text, args));
    }

    public Long readLongOrNull() {
        return fallbackNull(Long::parseLong, read());
    }

    public Long readLongOrNull(final String text, final Object... args) {
        write(text, args);
        return readLongOrNull();
    }


    public Optional<Integer> readInteger() {
        return Optional.ofNullable(readIntegerOrNull());
    }

    public Optional<Integer> readInteger(final String text, final Object... args) {
        return Optional.ofNullable(readIntegerOrNull(text, args));
    }

    public Integer readIntegerOrNull() {
        return fallbackNull(Integer::parseInt, read());
    }

    public Integer readIntegerOrNull(final String text, final Object... args) {
        write(text, args);
        return readIntegerOrNull();
    }

    public Optional<Double> readDouble() {
        return Optional.ofNullable(readDoubleOrNull());
    }

    public Optional<Double> readDouble(final String text, final Object... args) {
        return Optional.ofNullable(readDoubleOrNull(text, args));
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