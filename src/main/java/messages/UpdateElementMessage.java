package messages;

import command.CommandEnum;
import util.StudyGroup;

/**
 * Update element command returns new collection with updated element by given id
 */

public class UpdateElementMessage extends Message {
    private static final long serialVersionUID = 16L;
    public int id;
    public StudyGroup element;

    public UpdateElementMessage(int id, StudyGroup element){
        this.name = CommandEnum.UPDATE;
        this.id = id;
        this.element = element;
    }

    public StudyGroup getElement(){
        return element;
    }

    public int getId() {
        return id;
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
}
