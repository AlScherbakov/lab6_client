package command;

import messages.*;
import util.DataCollector;
import util.Semester;
import util.StudyGroup;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Invoker {
    private final Receiver state;
    static final List<CommandEnum> history = new ArrayList<>();
    private final DatagramChannel channel;
    private final SocketAddress serverAddress;

    public Invoker(Receiver programState, DatagramChannel channel, SocketAddress serverAddress) {
        state = programState;
        this.channel = channel;
        this.serverAddress = serverAddress;
    }

    public Receiver executeCommand(String rawCommand) {
        rawCommand = rawCommand.trim();
        Message message = null;
        if (rawCommand.matches("help")) {
//            history.add(CommandEnum.HELP);
            message = new HelpMessage();
        } else if (rawCommand.matches("info")) {
            message = new InfoMessage();
//                history.add(CommandEnum.INFO);
        } else if (rawCommand.matches("show")) {
            message = new ShowMessage();
//                history.add(CommandEnum.SHOW);
        } else if (rawCommand.matches("add")) {
            try {
                StudyGroup newGroup = new DataCollector(state.getSource()).requestStudyGroup();
                if (newGroup != null) {
                    message = new AddElementMessage(newGroup);
//                    state.addToCollection(newGroup);
//                    System.out.println("Элемент успешно добавлен в коллекцию");
                } else {
                    throw new RuntimeException("Элемент не был добавлен в коллекцию");
//                    System.out.println("Элемент не был добавлен в коллекцию");
                }
            } finally {
                history.add(CommandEnum.ADD);
            }
        } else if (rawCommand.matches("clear")) {
            message = new ClearMessage();
//            try {
//                state.setCollection(new ClearCommand().execute());
//                System.out.println("Коллекция очищена");
//            } finally {
//                history.add(CommandEnum.CLEAR);
//            }
        } else if (rawCommand.matches("save")) {
            System.out.println("Команду save из клиентского приложения необходимо убрать.");
//            try {
//                new SaveCommand(state.getOutputFilepath(), state.getCollection()).execute();
//                System.out.println("Коллекция сохранена в файл");
//            } catch (IOException e) {
//                System.err.println("Возникла ошибка при выполнении команды save. Проверьте путь и права доступа к файлу");
//            } finally {
//                history.add(CommandEnum.SAVE);
//            }
        } else if (rawCommand.matches("exit")) {
            System.exit(0);
//            try {
//                new ExitCommand().execute();
//            } finally {
//                history.add(CommandEnum.EXIT);
//            }
        } else if (rawCommand.matches("remove_greater")) {
            try {
                StudyGroup aGroup = new DataCollector(state.getSource()).requestStudyGroup();
                message = new RemoveGreaterMessage(aGroup);
//                state.setCollection(new RemoveGreaterCommand((TreeSet<StudyGroup>) state.getCollection(), state.getSource()).execute());
//                System.out.println("Все элементы, превышающие заданный, удалены из коллекции");
            } catch (ClassCastException e) {
                System.err.println("Возникла ошибка при выполнении команды remove_greater");
//            } finally {
//                history.add(CommandEnum.REMOVE_GREATER);
            }
        } else if (rawCommand.matches("remove_lower")) {
            try {
                StudyGroup aGroup = new DataCollector(state.getSource()).requestStudyGroup();
                message = new RemoveLowerMessage(aGroup);
//                state.setCollection(new RemoveLowerCommand((TreeSet<StudyGroup>) state.getCollection(), state.getSource()).execute());
//                System.out.println("Все элементы, меньшие, чем заданный, удалены из коллекции");
            } catch (ClassCastException e) {
                System.err.println("Возникла ошибка при выполнении команды remove_lower");
//            } finally {
//                history.add(CommandEnum.REMOVE_LOWER);
            }
        } else if (rawCommand.matches("history")) {
            message = new HistoryMessage();
//            try {
//                List<CommandEnum> historyToShow = new HistoryCommand(history).execute();
//                historyToShow.forEach(System.out::println);
//            } finally {
//                history.add(CommandEnum.HISTORY);
//            }
        } else if (rawCommand.matches("max_by_group_admin")) {
            message = new MaxGroupByAdminMessage();
//            try {
//                System.out.println(new MaxGroupByAdminCommand(state.getCollection()).execute());
//            } finally {
//                history.add(CommandEnum.MAX_BY_GROUP_ADMIN);
//            }
        } else if (rawCommand.matches("print_field_descending_group_admin")) {
            message = new PrintFieldDescendingGroupAdminMessage();
//            try {
//                System.out.println(new PrintFieldDescendingGroupAdminCommand(state.getCollection()).execute());
//            } finally {
//                history.add(CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN);
//            }
        } else if (rawCommand.matches("update\\s*\\d+")) {
//            try {
                int id = Integer.parseInt(rawCommand.split(" ")[1]);
                StudyGroup updatedGroup = new DataCollector(state.getSource()).requestStudyGroup();
                message = new UpdateElementMessage(id, updatedGroup);
//                state.setCollection(new UpdateElementCommand(id, state.getCollection(), state.getSource()).execute());
//                System.out.printf("Элемент #%d обновлён (show - список элементов)", id);
//            } finally {
//                history.add(CommandEnum.UPDATE);
//            }
        } else if (rawCommand.matches("remove_by_id\\s*\\d+")) {
//            try {
                int id = Integer.parseInt(rawCommand.split(" ")[1]);
                message = new RemoveByIdMessage(id);
//                state.setCollection(new RemoveByIdCommand(id, state.getCollection()).execute());
//                System.out.printf("Элемент #%d удалён из коллекции (show - список элементов)", id);
//            } finally {
//                history.add(CommandEnum.REMOVE_BY_ID);
//            }
        } else if (rawCommand.matches("execute_script\\s*.+")) {
//            try {
                String scriptPath = rawCommand.split(" ")[1];
                message = new ExecuteScriptMessage(scriptPath);
//                state.pushReader(new ExecuteScriptCommand(scriptPath).execute());
//            }
//            finally {
//                history.add(CommandEnum.EXECUTE_SCRIPT);
//            }
        } else if (rawCommand.matches("filter_less_than_semester_enum\\s*[A-Z]+")) {
//            try {
                Semester semester = Semester.valueOf(rawCommand.split(" ")[1]);
                message = new FilterLessThanSemesterEnumMessage(semester);
//                state.setCollection(new FilterLessThanSemesterEnumCommand(semesterEnum, state.getCollection()).execute());
//                System.out.println("Коллекция отфильтрована (show - список элементов)");
//            } finally {
//                history.add(CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM);
//            }
        } else {
            System.out.printf("Команды '%s' не существует (help - список команд) или аргумент команды не задан\n", rawCommand);
        }
        Set<StudyGroup> updatedCollection = new ServerResponse(state, message, channel, serverAddress).getUpdatedCollection();
        state.setCollection(updatedCollection);
        return state;
        //return new ServerResponse(state, command).getState();
    }
}