package org.interview.executor;

import static org.junit.jupiter.api.Assertions.*;

import org.interview.parser.FileParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class CommandStdExecutorTest {
    final static String FILENAME = "./src/main/resources/input.txt";

    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(stdOut);
    }

    @Test
    void validationTest() {
        final String firstLine = "1 3 N";
        final String secondLine = "5 1 E";
        FileParser fileParser = new FileParser(FILENAME);
        final CommandStdExecutor cmdExec = new CommandStdExecutor(fileParser);
        cmdExec.run();
        final List<String> results = Arrays.stream(captor.toString().trim().split("\n")).toList();
        assertEquals(results.size(), 2);
        assertEquals(firstLine, results.get(0).replace("\n", "").replace("\r", ""));
        assertEquals(secondLine, results.get(1));
    }
}