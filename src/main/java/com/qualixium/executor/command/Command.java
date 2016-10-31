package com.qualixium.executor.command;

public class Command {
    public String name;
    public String command;

    public Command(String name, String command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public String toString() {
        return name;
    }

}