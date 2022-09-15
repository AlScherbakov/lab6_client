package messages;

import command.CommandEnum;

/**
 * Save command writes data into output file
 */

public class SaveMessage extends Message {
    private static final long serialVersionUID = 14L;
    public SaveMessage(){
        this.name = CommandEnum.SAVE;
    }
}