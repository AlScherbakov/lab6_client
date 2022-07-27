package messages;

import command.CommandEnum;

/**
 * Print field descending group admin command returns a list of group admins in descending order comparing by age of an admin
 */

public class PrintFieldDescendingGroupAdminMessage extends Message {
    private static final long serialVersionUID = 10L;
//    Set<StudyGroup> collection;
    public PrintFieldDescendingGroupAdminMessage(){
        this.name = CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN;
    }

//    public PrintFieldDescendingGroupAdminCommand(Set<StudyGroup> c){
//        collection = c;
//        this.name = CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN;
//    }
//
//    @Override
//    public String execute() {
//        TreeSet<StudyGroup> g = new TreeSet<>((o1, o2) -> o2.getAdmin().compareTo(o1.getAdmin()));
//        g.addAll(collection);
//        ArrayList<String> admins = new ArrayList<>();
//        g.forEach((StudyGroup e) -> admins.add(e.getAdmin().toString()));
//        return String.join("\n", admins);
//    }

}
