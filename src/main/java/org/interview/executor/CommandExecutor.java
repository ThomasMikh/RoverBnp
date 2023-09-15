package org.interview.executor;

import org.interview.command.IRoverCommand;
import org.interview.parser.IParser;

import java.util.Queue;


public abstract class CommandExecutor<T, G> {
    abstract IParser<G> getParser();

    public final void run() {
        parseInput(getParser());
        getState();
        final Queue<IRoverCommand<T>> commands = initCommands();
        runCommands(commands);
    }

    abstract void parseInput(IParser<G> parser);

    abstract void getState();

    abstract Queue<IRoverCommand<T>> initCommands();

    abstract void runCommands(final Queue<IRoverCommand<T>> commands);
}

