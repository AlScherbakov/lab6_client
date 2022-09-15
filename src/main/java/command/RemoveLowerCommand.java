package command;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

import java.util.Set;
import java.util.TreeSet;

/**
 * Remove lower command filters collection and leaves only elements which are greater than given one
 */

public class RemoveLowerCommand extends Command{
    private static final long serialVersionUID = 13L;
    public final CommandEnum name = CommandEnum.REMOVE_LOWER;
    public StudyGroup element;
    public RemoveLowerCommand(StudyGroup element){
        this.element = element;
    }
    @Override
    public String describe() {
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
