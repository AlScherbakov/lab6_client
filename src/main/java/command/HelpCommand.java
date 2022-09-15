package command;

/**
 * Help command returns an info about all commands in the project
 */

public class HelpCommand extends Command {
    private static final long serialVersionUID = 6L;
    public final CommandEnum name = CommandEnum.HELP;
    public HelpCommand(){}
    @Override
    public String describe(){
        return "help : вывести справку по доступным командам";
    }
}
