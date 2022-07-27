package messages;

import command.CommandEnum;

/**
 * Clear command returns empty TreeSet
 */

public class ClearMessage extends Message {
    private static final long serialVersionUID = 2L;

    public ClearMessage(){
        this.name = CommandEnum.CLEAR;
    }
//
//    @Override
//    public Set<StudyGroup> execute (){
//        return new TreeSet<>();
//    }
}
