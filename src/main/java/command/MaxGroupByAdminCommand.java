package command;

import util.StudyGroup;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Max group by admin command returns the greatest collection elemets, comparing my groupAdmin field
 */

public class MaxGroupByAdminCommand extends Command{
    private static final long serialVersionUID = 9L;
    public final CommandEnum name = CommandEnum.MAX_BY_GROUP_ADMIN;
    public MaxGroupByAdminCommand(){}
//    Set<StudyGroup> collection;
//    public MaxGroupByAdminCommand(Set<StudyGroup> c){
//        collection = c;
//        this.name = CommandEnum.MAX_BY_GROUP_ADMIN;
//    }
//    @Override
//    public StudyGroup execute(){
//        TreeSet<StudyGroup> g = new TreeSet<>(Comparator.comparing(StudyGroup::getAdmin));
//        g.addAll(collection);
//        return g.last();
//    }
    @Override
    public String describe(){
        return "max_by_group_admin : вывести любой объект из коллекции, значение поля groupAdmin которого является максимальным";
    }
}
