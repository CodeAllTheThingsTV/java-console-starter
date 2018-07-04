package io.github.codeallthethingstv.console;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleTest {

    private String _input;
    private ByteArrayOutputStream _output;

    @Before
    public void setUp() {
        _input = null;
        _output = null;
    }

    @Test
    public void testRead() {
        givenInput("someText");
        assertThat(when().read()).isEqualTo("someText");
    }

    @Test
    public void testReadWithPreparedText() throws UnsupportedEncodingException {
        givenInput("someText");
        when().read("Please enter some value: ");
        thenConsoleOutputIs("Please enter some value: ");
    }

    @Test
    public void testReadInvalidLongReturnsNull() {
        givenInput("notALong");
        assertThat(when().readLongOrNull()).isNull();
    }

    @Test
    public void testReadLongReturnsLong() {
        givenInput("1000");
        assertThat(when().readLongOrNull()).isEqualTo(1000L);
    }

    @Test
    public void testReadLongWithPreparedText() throws UnsupportedEncodingException {
        givenInput("someInput");
        when().readLongOrNull("Please enter some value: ");
        thenConsoleOutputIs("Please enter some value: ");
    }

    @Test
    public void testReadIntegerWithPreparedText() throws UnsupportedEncodingException {
        givenInput("someInput");
        when().readIntegerOrNull("Please enter some value: ");
        thenConsoleOutputIs("Please enter some value: ");
    }

    @Test
    public void testReadDoubleWithPreparedText() throws UnsupportedEncodingException {
        givenInput("someInput");
        when().readDoubleOrNull("Please enter some value: ");
        thenConsoleOutputIs("Please enter some value: ");
    }

    private void thenConsoleOutputIs(String expected) throws UnsupportedEncodingException {
        assertThat(_output.toString("UTF8")).startsWith(expected);
    }

    @Test
    public void testReadInvalidIntegerReturnsNull() {
        givenInput("notAnInteger");
        assertThat(when().readIntegerOrNull()).isNull();
    }

    @Test
    public void testReadIntegerReturnsInteger() {
        givenInput("1000");
        assertThat(when().readIntegerOrNull()).isEqualTo(1000);
    }

    @Test
    public void testReadInvalidDoubleReturnsNull() {
        givenInput("notADouble");
        assertThat(when().readDoubleOrNull()).isNull();
    }

    @Test
    public void testReadDoubleReturnsDouble() {
        givenInput("1000.45");
        assertThat(when().readDoubleOrNull()).isEqualTo(1000.45d);
    }

    private void givenInput(final String input) {
        _input = input;
    }

    private Console when() {
        _output = new ByteArrayOutputStream();
        return new Console(new BufferedReader(new StringReader(_input)), new PrintStream(_output));
    }
}