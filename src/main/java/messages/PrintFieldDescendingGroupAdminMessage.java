package messages;

import command.CommandEnum;

/**
 * Print field descending group admin command returns a list of group admins in descending order comparing by age of an admin
 */

public class PrintFieldDescendingGroupAdminMessage extends Message {
    private static final long serialVersionUID = 10L;
    public PrintFieldDescendingGroupAdminMessage(){
        this.name = CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN;
    }
}
