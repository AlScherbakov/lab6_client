package command;

import util.StudyGroup;

import java.util.Set;

/**
 * Info command returns an information about current collection state: type, initialization date, number of elements
 */

public class InfoCommand extends Command{
    private static final long serialVersionUID = 8L;
    public final CommandEnum name = CommandEnum.INFO;
    public InfoCommand(){}
    @Override
    public String describe() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
