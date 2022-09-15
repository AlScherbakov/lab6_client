package command;

import util.Semester;
import util.StudyGroup;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Filter less than semester enum command returns a collection of StudyGroups, which semester is lower than given one
 */

public class FilterLessThanSemesterEnumCommand extends Command{
    private static final long serialVersionUID = 5L;
    public Semester semester;
    public final CommandEnum name = CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM;
    FilterLessThanSemesterEnumCommand(Semester semester){
        this.semester = semester;
    }
    @Override
    public String describe() {
        return "filter_less_than_semester_enum (SECOND, THIRD, SIXTH, SEVENTH) : вывести элементы, значение поля semesterEnum которых меньше заданного";
    }
}
