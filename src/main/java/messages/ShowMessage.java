package messages;

import command.CommandEnum;

/**
 * Show command returns an info string about each element in collection
 */

public class ShowMessage extends Message {
    private static final long serialVersionUID = 15L;
    public ShowMessage(){
        this.name = CommandEnum.SHOW;
    }
//    Set<StudyGroup> collection;
//    public ShowCommand(Set<StudyGroup> c){
//        collection = c;
//        this.name = CommandEnum.SHOW;
//    };
//    @Override
//    public String execute(){
//        if (collection.size() < 1){
//            return "Коллекция пуста";
//        } else {
//            List<String> groups = new ArrayList<>();
//            collection.forEach((StudyGroup g) -> groups.add(g.toString()));
//            return String.join("\n", groups);
//        }
//    }
}
