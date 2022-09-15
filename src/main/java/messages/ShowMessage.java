package messages;

import command.CommandEnum;

/**
 * Show command returns an info string about each element in collection
 */

public class ShowMessage extends Message {
    private static final long serialVersionUID = 15L;
    public ShowMessage(){
        this.name = CommandEnum.SHOW;
    }
}
