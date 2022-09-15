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
}
