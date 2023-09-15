package org.interview.parser;

import lombok.AllArgsConstructor;
import org.interview.error.InputError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class FileParser implements IParser<List<List<String>>> {
    private String fileName;

    @Override
    public List<List<String>> parse() throws InputError {
        try {
            final Path path = Paths.get(this.fileName);
            final List<String> lines = Files.readAllLines(path);
            return lines.stream().map(line -> Arrays.stream(line.split(" ")).toList()).toList();
        } catch (final IOException e) {
            throw new InputError();
        }
    }
}
