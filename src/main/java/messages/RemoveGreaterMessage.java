package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Remove greater command filters collection and leaves only elements which are lower than given one
 */

public class RemoveGreaterMessage extends Message {
    private static final long serialVersionUID = 12L;
//    TreeSet<StudyGroup> collection;
//    DataInputSource source;
    public StudyGroup element;

    public RemoveGreaterMessage(StudyGroup element){
        this.name = CommandEnum.REMOVE_GREATER;
        this.element = element;
    }

    public StudyGroup getElement(){
        return element;
    }

//    public RemoveGreaterCommand(TreeSet<StudyGroup> c, DataInputSource s){
//        collection = c;
//        source = s;
//        this.name = CommandEnum.REMOVE_GREATER;
//    }
//
//    @Override
//    public Set<StudyGroup> execute(){
//        System.out.println("Введите новый элемент для сравнения:");
//        StudyGroup aGroup = new DataCollector(source).requestStudyGroup();
//        Set<StudyGroup> groupsToRemove = collection.tailSet(aGroup);
//        collection.removeAll(groupsToRemove);
//        return collection;
//    }
}
