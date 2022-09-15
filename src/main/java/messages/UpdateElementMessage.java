package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Update element command returns new collection with updated element by given id
 */

public class UpdateElementMessage extends Message {
    private static final long serialVersionUID = 16L;
    public int id;
    public StudyGroup element;

    public UpdateElementMessage(int id, StudyGroup element){
        this.name = CommandEnum.UPDATE;
        this.id = id;
        this.element = element;
    }

    public StudyGroup getElement(){
        return element;
    }

    public int getId() {
        return id;
    }
}
