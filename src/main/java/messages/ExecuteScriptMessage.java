package messages;

import command.CommandEnum;

/**
 * Execute script command returns new BufferedReader from filepath
 */

public class ExecuteScriptMessage extends Message {
    private static final long serialVersionUID = 3L;
    public String scriptPath;
    public ExecuteScriptMessage(String scriptPath){
        this.name = CommandEnum.EXECUTE_SCRIPT;
        this.scriptPath = scriptPath;
    }
}
