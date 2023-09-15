package org.interview.command;

import org.interview.rover.Rover;

import java.util.List;

public interface IRoverCommand<T> {
    List<T> commands();
    Rover rover();
}
