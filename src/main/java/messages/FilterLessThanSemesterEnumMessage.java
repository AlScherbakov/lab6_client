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
}
