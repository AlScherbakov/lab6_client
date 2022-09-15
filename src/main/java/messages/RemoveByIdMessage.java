package messages;

import command.CommandEnum;

/**
 * Remove by id command returns collection without an element with given id
 */

public class RemoveByIdMessage extends Message {
    private static final long serialVersionUID = 11L;
    public int id;
    public RemoveByIdMessage(int id){
        this.name = CommandEnum.REMOVE_BY_ID;
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
