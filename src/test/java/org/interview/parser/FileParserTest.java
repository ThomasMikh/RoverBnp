package org.interview.parser;

import org.interview.error.InputError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    final static String FILENAME = "./src/main/resources/input.txt";

    @Test
    void testNoFile() {
        final FileParser parser = new FileParser("./nofile.tx");
        assertThrows(InputError.class, parser::parse);
    }

    @Test
    void testExistingFile() {
        final FileParser parser = new FileParser(FILENAME);
        assertDoesNotThrow(parser::parse);
    }
}