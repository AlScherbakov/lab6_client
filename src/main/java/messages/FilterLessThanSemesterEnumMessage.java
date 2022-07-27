package messages;

import command.CommandEnum;
import util.Semester;

/**
 * Filter less than semester enum command returns a collection of StudyGroups, which semester is lower than given one
 */

public class FilterLessThanSemesterEnumMessage extends Message {
    private static final long serialVersionUID = 5L;
    public Semester semester;
    public FilterLessThanSemesterEnumMessage(Semester semester){
        this.name = CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM;
        this.semester = semester;
    }
    public Semester getSemester(){
        return semester;
    }
//    Semester semester;
//    Set<StudyGroup> collection;
//    public FilterLessThanSemesterEnumCommand(Semester s, Set<StudyGroup> c){
//        semester = s;
//        collection = c;
//        this.name = CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM;
//    }
//    @Override
//    public Set<StudyGroup> execute(){
//        Set<StudyGroup> g = new TreeSet<>(Comparator.comparing(StudyGroup::getSemesterEnum));
//        g.addAll(collection);
//        g.removeIf((StudyGroup x) -> semester.compareTo(x.getSemesterEnum()) <= 0);
//        if (g.size() > 0){
//            return g;
//        } else {
//            System.out.println("Нет элементов, значение поля semesterEnum которых меньше " + semester);
//            return collection;
//        }
//    }
}
