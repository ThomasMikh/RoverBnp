package org.interview;

import org.interview.error.InputError;
import org.interview.executor.CommandStdExecutor;
import org.interview.parser.FileParser;
import org.interview.parser.IParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new InputError();
        }
        final IParser<List<List<String>>> fileParser = new FileParser(args[0]);
        final CommandStdExecutor cmdExec = new CommandStdExecutor(fileParser);
        cmdExec.run();
    }
}