package messages;

import command.CommandEnum;

import java.io.Serializable;

/**
 * Abstract Command class - superclass for all commands - a part of Command pattern
 */

public abstract class Message implements Serializable {
    protected CommandEnum name;
    public CommandEnum getCommandName(){
        return name;
    }
}
