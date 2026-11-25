package dev.javashell.terminal;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class TerminalManager implements AutoCloseable {

    private final Terminal terminal;
    private final LineReader reader;

    public TerminalManager() throws IOException {

        this.terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        this.reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public LineReader getReader() {
        return reader;
    }

    @Override
    public void close() throws IOException {
        terminal.close();
    }
}
