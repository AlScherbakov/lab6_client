package messages;

import command.CommandEnum;

/**
 * Info command returns an information about current collection state: type, initialization date, number of elements
 */

public class InfoMessage extends Message {
    private static final long serialVersionUID = 8L;
    public InfoMessage(){
        this.name = CommandEnum.INFO;
    }
}
