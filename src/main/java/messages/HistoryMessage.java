package messages;

import command.CommandEnum;

/**
 * History command returns last 6 entries of called commands list
 */

public class HistoryMessage extends Message {
    private static final long serialVersionUID = 7L;
    public HistoryMessage(){
        this.name = CommandEnum.HISTORY;
    }
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
}
