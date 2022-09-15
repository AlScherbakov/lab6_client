package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Remove lower command filters collection and leaves only elements which are greater than given one
 */

public class RemoveLowerMessage extends Message {
    private static final long serialVersionUID = 13L;
    public StudyGroup element;
    public RemoveLowerMessage(StudyGroup element){
        this.name = CommandEnum.REMOVE_LOWER;
        this.element = element;
    }

    public StudyGroup getElement(){
        return element;
    }
}
