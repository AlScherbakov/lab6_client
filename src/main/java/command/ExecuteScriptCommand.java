package command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Execute script command returns new BufferedReader from filepath
 */

public class ExecuteScriptCommand extends Command{
    private static final long serialVersionUID = 3L;
    public String scriptPath;
    public final CommandEnum name = CommandEnum.EXECUTE_SCRIPT;
    public ExecuteScriptCommand(String scriptPath){
        this.scriptPath = scriptPath;
    }
//    @Override
//    public BufferedReader execute() {
//        try {
//            return new BufferedReader(new FileReader(scriptPath), 16384);
//        } catch (FileNotFoundException e) {
//            System.out.println("Ошибка чтения скрипта " + scriptPath);
//            return null;
//        }
//    }
    @Override
    public String describe() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
