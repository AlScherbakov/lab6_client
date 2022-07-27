package command;

/**
 * Stops program execution with 0 code
 */

public class ExitCommand extends Command{
    private static final long serialVersionUID = 4L;
    public final CommandEnum name = CommandEnum.EXIT;
    public ExitCommand(){}
//    @Override
//    public Integer execute(){
//        System.exit(0);
//        return 0;
//    }
    @Override
    public String describe(){
        return "exit : завершить программу (без сохранения в файл)";
    }
}
