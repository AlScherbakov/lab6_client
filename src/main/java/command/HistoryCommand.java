package command;

import java.util.ArrayList;
import java.util.List;

/**
 * History command returns last 6 entries of called commands list
 */

public class HistoryCommand extends Command{
    private static final long serialVersionUID = 7L;
    public final CommandEnum name = CommandEnum.HISTORY;
    public HistoryCommand(){}
    @Override
    public String describe(){
        return "history : вывести последние 6 команд (без их аргументов)";
    }
}
