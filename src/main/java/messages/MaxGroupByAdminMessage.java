package messages;

import command.CommandEnum;

/**
 * Max group by admin command returns the greatest collection elemets, comparing my groupAdmin field
 */

public class MaxGroupByAdminMessage extends Message {
    private static final long serialVersionUID = 9L;
    public MaxGroupByAdminMessage(){
        this.name = CommandEnum.MAX_BY_GROUP_ADMIN;
    }
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
}
