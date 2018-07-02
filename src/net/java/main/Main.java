package net.java.main;

import net.java.main.core.EngineImpl;
import net.java.main.dispachers.CommandDispatcherImpl;
import net.java.main.io.OutputWriter;

public class Main {
    public static final int ROW = 5;
    public static final int COL = 5;

    public static void main(String[] args) {
        OutputWriter writer = new OutputWriter();
        CommandDispatcherImpl commandDispatcher = new CommandDispatcherImpl();

        EngineImpl gameEngine = new EngineImpl(writer, commandDispatcher);
        gameEngine.start();
    }
}
