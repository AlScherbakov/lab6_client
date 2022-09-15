package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Add element command requests and returns new StudyGroup from DataCollector
 */

public class AddElementMessage extends Message {
    private static final long serialVersionUID = 1L;
    public StudyGroup element;

    public AddElementMessage(StudyGroup element) {
        this.name = CommandEnum.ADD;
        this.element = element;
    }
    public StudyGroup getElement(){
        return element;
    }
}
