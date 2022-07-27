package messages;

import command.CommandEnum;

/**
 * Info command returns an information about current collection state: type, initialization date, number of elements
 */

public class InfoMessage extends Message {
    private static final long serialVersionUID = 8L;
    public InfoMessage(){
        this.name = CommandEnum.INFO;
    }
//    Set<StudyGroup> collection;
//    String creationDate;
//    public InfoCommand(Set<StudyGroup> t, String d){
//        collection = t;
//        creationDate = d;
//        this.name = CommandEnum.INFO;
//    }
//    @Override
//    public String execute(){
//        return String.format("Тип коллекции - %s. Дата инициализации - %s. Количество элементов - %d\n", collection.getClass(), creationDate, collection.size());
//    }
}
