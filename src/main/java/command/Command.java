package command;

import java.io.Serializable;

/**
 * Abstract Command class - superclass for all commands - a part of Command pattern
 */

public abstract class Command implements Serializable {
    protected CommandEnum name;
    public abstract String describe();
    public CommandEnum getName(){
        return name;
    }
}
