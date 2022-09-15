package command;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

import java.util.Set;
import java.util.TreeSet;

/**
 * Remove greater command filters collection and leaves only elements which are lower than given one
 */

public class RemoveGreaterCommand extends Command{
    private static final long serialVersionUID = 12L;
    public final CommandEnum name = CommandEnum.REMOVE_GREATER;
    public StudyGroup element;

    public RemoveGreaterCommand(StudyGroup element){
        this.element = element;
    }
    @Override
    public String describe() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
