package messages;

import command.CommandEnum;

/**
 * Help command returns an info about all commands in the project
 */

public class HelpMessage extends Message {
    private static final long serialVersionUID = 6L;
    public HelpMessage(){
        this.name = CommandEnum.HELP;
    }
//    @Override
//    public String execute() {
//        return "help : вывести справку по доступным командам\ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\nadd {element} : добавить новый элемент в коллекцию\nupdate (int)id {element} : обновить значение элемента коллекции, id которого равен заданному\nremove_by_id (int)id : удалить элемент из коллекции по его id\nclear : очистить коллекцию\nsave : сохранить коллекцию в файл\nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме\nexit : завершить программу (без сохранения в файл)\nremove_greater {element} : удалить из коллекции все элементы, превышающие заданный\nremove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\nhistory : вывести последние 6 команд (без их аргументов)\nmax_by_group_admin : вывести любой объект из коллекции, значение поля groupAdmin которого является максимальным\nfilter_less_than_semester_enum (SECOND, THIRD, SIXTH, SEVENTH) : вывести элементы, значение поля semesterEnum которых меньше заданного\nprint_field_descending_group_admin : вывести значения поля groupAdmin всех элементов в порядке убывания";
//    }
}
