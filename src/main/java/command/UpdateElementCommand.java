package command;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Update element command returns new collection with updated element by given id
 */

public class UpdateElementCommand extends Command{
    private static final long serialVersionUID = 16L;
    public int id;
    public StudyGroup element;
    public final CommandEnum name = CommandEnum.UPDATE;

    public UpdateElementCommand(int id, StudyGroup element){
        this.id = id;
        this.element = element;
    }

    //    Set<StudyGroup> collection;
//    DataInputSource source;
//    public UpdateElementCommand(int i, Set<StudyGroup> c, DataInputSource s){
//        id = i;
//        collection = c;
//        source = s;
//        this.name = CommandEnum.UPDATE;
//    }
//    @Override
//    public Set<StudyGroup> execute(){
//        TreeSet<StudyGroup> g = new TreeSet<>(collection);
//        g.removeIf(x -> !Objects.equals(x.getId(), id));
//        StudyGroup aGroup = g.first();
//        assert aGroup != null;
//        StudyGroup updatedGroup = new DataCollector(source).requestStudyGroup();
//        collection.remove(aGroup);
//        collection.add(updatedGroup);
//        return collection;
//    }
    @Override
    public String describe(){
        return "update (int)id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
