package command;

import util.StudyGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Show command returns an info string about each element in collection
 */

public class ShowCommand extends Command{
    private static final long serialVersionUID = 15L;
    public final CommandEnum name = CommandEnum.SHOW;
    @Override
    public String describe(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
