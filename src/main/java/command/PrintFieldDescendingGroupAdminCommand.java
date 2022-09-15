package command;

import util.StudyGroup;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Print field descending group admin command returns a list of group admins in descending order comparing by age of an admin
 */

public class PrintFieldDescendingGroupAdminCommand extends Command{
    private static final long serialVersionUID = 10L;
    public final CommandEnum name = CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN;
    public PrintFieldDescendingGroupAdminCommand(){}

    @Override
    public String describe() {
        return "print_field_descending_group_admin : вывести значения поля groupAdmin всех элементов в порядке убывания";
    }
}
