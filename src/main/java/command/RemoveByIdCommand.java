package command;

import util.StudyGroup;

import java.util.Objects;
import java.util.Set;

/**
 * Remove by id command returns collection without an element with given id
 */

public class RemoveByIdCommand extends Command {
    private static final long serialVersionUID = 11L;
    public int id;
    public final CommandEnum name = CommandEnum.REMOVE_BY_ID;
    public RemoveByIdCommand(int id){
        this.id = id;
    }
    @Override
    public String describe() {
        return "remove_by_id (int)id : удалить элемент из коллекции по его id";
    }
}
