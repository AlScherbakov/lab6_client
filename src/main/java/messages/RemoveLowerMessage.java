package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Remove lower command filters collection and leaves only elements which are greater than given one
 */

public class RemoveLowerMessage extends Message {
    private static final long serialVersionUID = 13L;
//    TreeSet<StudyGroup> collection;
//    DataInputSource source;
    public StudyGroup element;
    public RemoveLowerMessage(StudyGroup element){
        this.name = CommandEnum.REMOVE_LOWER;
        this.element = element;
    }

    public StudyGroup getElement(){
        return element;
    }

//    public RemoveLowerCommand(TreeSet<StudyGroup> c, DataInputSource s){
//        collection = c;
//        source = s;
//        this.name = CommandEnum.REMOVE_LOWER;
//    }
//
//    @Override
//    public Set<StudyGroup> execute(){
//        System.out.println("Введите новый элемент для сравнения:");
//        StudyGroup aGroup = new DataCollector(source).requestStudyGroup();
//        Set<StudyGroup> groupsToRemove = collection.headSet(aGroup);
//        collection.removeAll(groupsToRemove);
//        return collection;
//    }
}
