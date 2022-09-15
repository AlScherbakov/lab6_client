package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Remove greater command filters collection and leaves only elements which are lower than given one
 */

public class RemoveGreaterMessage extends Message {
    private static final long serialVersionUID = 12L;
    public StudyGroup element;

    public RemoveGreaterMessage(StudyGroup element){
        this.name = CommandEnum.REMOVE_GREATER;
        this.element = element;
    }

    public StudyGroup getElement(){
        return element;
    }
}
