package command;

import util.StudyGroup;

import java.util.Set;
import java.util.TreeSet;

/**
 * Clear command returns empty TreeSet
 */

public class ClearCommand extends Command{
    private static final long serialVersionUID = 2L;
    public final CommandEnum name = CommandEnum.CLEAR;

    public ClearCommand(){}
//
//    @Override
//    public Set<StudyGroup> execute (){
//        return new TreeSet<>();
//    }

    @Override
    public String describe() {
        return "clear : очистить коллекцию";
    }
}
