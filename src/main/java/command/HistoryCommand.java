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
//    private final List<CommandEnum> history;
//    public HistoryCommand(List<CommandEnum> h){
//        history = h;
//        this.name = CommandEnum.HISTORY;
//    }
//    @Override
//    public List<CommandEnum> execute(){
//        int historySize = history.size();
//        if (historySize <= 6){
//            return history;
//        } else{
//           return new ArrayList<>(history.subList(historySize - 6, historySize));
//        }
//    }
    @Override
    public String describe(){
        return "history : вывести последние 6 команд (без их аргументов)";
    }
}
