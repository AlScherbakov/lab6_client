package command;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

/**
 * Add element command requests and returns new StudyGroup from DataCollector
 */

public class AddElementCommand extends Command{
    private static final long serialVersionUID = 1L;
    public final CommandEnum name = CommandEnum.ADD;
    public StudyGroup element;
//    private final DataInputSource source;

    public AddElementCommand(StudyGroup element) {
        this.element = element;
    }
//    @Override
//    public StudyGroup execute(){
//        return new DataCollector(source).requestStudyGroup();
//    }
    @Override
    public String describe(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
