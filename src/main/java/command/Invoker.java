package command;

import client.ServerResponse;
import messages.*;
import util.DataCollector;
import util.Semester;
import util.StudyGroup;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class Invoker {
    private final Receiver state;
    private final DatagramSocket socket;
    private final InetAddress serverAddress;
    private int port = -1;

    public Invoker(Receiver programState, DatagramSocket socket, InetAddress serverAddress, int port) {
        state = programState;
        this.socket = socket;
        this.serverAddress = serverAddress;
        this.port = port;
    }

    public Receiver executeCommand(String rawCommand) {
        rawCommand = rawCommand.trim();
        Message message = null;
        if (rawCommand.matches("help")) {
            message = new HelpMessage();
        } else if (rawCommand.matches("info")) {
            message = new InfoMessage();
        } else if (rawCommand.matches("show")) {
            message = new ShowMessage();
        } else if (rawCommand.matches("add")) {
            try {
                StudyGroup newGroup = new DataCollector(state.getSource()).requestStudyGroup();
                if (newGroup != null) {
                    message = new AddElementMessage(newGroup);
                } else {
                    throw new RuntimeException("Элемент не был добавлен в коллекцию");
                }
            } catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
        } else if (rawCommand.matches("clear")) {
            message = new ClearMessage();
        } else if (rawCommand.matches("exit")) {
            System.exit(0);
        } else if (rawCommand.matches("remove_greater")) {
            try {
                StudyGroup aGroup = new DataCollector(state.getSource()).requestStudyGroup();
                message = new RemoveGreaterMessage(aGroup);
            } catch (ClassCastException e) {
                System.err.println("Возникла ошибка при выполнении команды remove_greater");
            }
        } else if (rawCommand.matches("remove_lower")) {
            try {
                StudyGroup aGroup = new DataCollector(state.getSource()).requestStudyGroup();
                message = new RemoveLowerMessage(aGroup);
            } catch (ClassCastException e) {
                System.err.println("Возникла ошибка при выполнении команды remove_lower");
            }
        } else if (rawCommand.matches("history")) {
            message = new HistoryMessage();
        } else if (rawCommand.matches("max_by_group_admin")) {
            message = new MaxGroupByAdminMessage();
        } else if (rawCommand.matches("print_field_descending_group_admin")) {
            message = new PrintFieldDescendingGroupAdminMessage();
        } else if (rawCommand.matches("update\\s*\\d+")) {
            int id = Integer.parseInt(rawCommand.split(" ")[1]);
            StudyGroup updatedGroup = new DataCollector(state.getSource()).requestStudyGroup();
            message = new UpdateElementMessage(id, updatedGroup);
        } else if (rawCommand.matches("remove_by_id\\s*\\d+")) {
            int id = Integer.parseInt(rawCommand.split(" ")[1]);
            message = new RemoveByIdMessage(id);
        } else if (rawCommand.matches("execute_script\\s*.+")) {
            String scriptPath = rawCommand.split(" ")[1];
            boolean isSuccessfullySetScript = state.pushReader(new ExecuteScriptCommand(scriptPath).execute(), scriptPath);
            if(isSuccessfullySetScript) message = new ExecuteScriptMessage(scriptPath);
        } else if (rawCommand.matches("filter_less_than_semester_enum\\s*[A-Z]+")) {
            Semester semester = Semester.valueOf(rawCommand.split(" ")[1]);
            message = new FilterLessThanSemesterEnumMessage(semester);
        } else {
            System.out.printf("Команды '%s' не существует (help - список команд) или аргумент команды не задан\n", rawCommand);
        }
        System.out.println("message to be sent " + message);
        if (message != null) {
            new ServerResponse(message, socket, serverAddress, port);
        }
        return state;
    }
}