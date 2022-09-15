package messages;

import command.CommandEnum;

/**
 * Help command returns an info about all commands in the project
 */

public class HelpMessage extends Message {
    private static final long serialVersionUID = 6L;
    public HelpMessage(){
        this.name = CommandEnum.HELP;
    }
}
