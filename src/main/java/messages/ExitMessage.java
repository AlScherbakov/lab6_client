package messages;

import command.CommandEnum;

/**
 * Stops program execution with 0 code
 */

public class ExitMessage extends Message {
    private static final long serialVersionUID = 4L;
    public ExitMessage(){
        this.name = CommandEnum.EXIT;
    }
//    @Override
//    public Integer execute(){
//        System.exit(0);
//        return 0;
//    }
}
