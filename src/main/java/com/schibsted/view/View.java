package com.schibsted.view;

import java.io.*;

public abstract class View implements Closeable {
    private boolean hasBeenClosed;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public View(Reader reader, Writer writer) {
        this.hasBeenClosed = false;
        this.reader = new BufferedReader(reader);
        this.writer = new PrintWriter(writer);
    }

    public abstract void onRender();
    public abstract void onCommand(String command);

    public final void show() throws IOException {
        this.hasBeenClosed = false;
        while (!this.hasBeenClosed) {
            this.clearScreen();
            onRender();
            writer.flush();
            String line = reader.readLine();
            onCommand(line);
        }
    }

    @Override
    public void close() throws IOException {
        this.hasBeenClosed = true;
    }

    protected BufferedReader getReader() {
        return reader;
    }

    protected PrintWriter getWriter() {
        return writer;
    }

    protected final void navigateTo(View view) {
        try {
            this.close();
            view.show();
        } catch (Exception e) {
            throw new Error(e);
        }
    }


    private void clearScreen() {
        writer.print("\033[H\033[2J");
        writer.flush();
    }
}