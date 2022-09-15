package messages;

import command.CommandEnum;

/**
 * History command returns last 6 entries of called commands list
 */

public class HistoryMessage extends Message {
    private static final long serialVersionUID = 7L;
    public HistoryMessage(){
        this.name = CommandEnum.HISTORY;
    }
}
