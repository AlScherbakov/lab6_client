package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import command.CommandEnum;
import command.Invoker;
import command.Receiver;
import util.DataInputSource;
import util.StudyGroup;

import java.io.IOException;
import java.net.*;
import java.util.*;

/**
 * Client class from Command pattern. Main process host. May be used for creation of several application instances
 */
public class Client {
    private final Scanner scan;
    boolean active = true;

    private InetAddress serverAddress = null;
    private int port = -1;

    private DatagramSocket socket;

    public Client(Scanner s) {
        scan = s;
        try{
            setPort();
            socket = new DatagramSocket();
            socket.setSoTimeout(10000);
            serverAddress = InetAddress.getByName("localhost");
        } catch (UnknownHostException | SocketException e){
            System.err.println("Ошибка при подключении к серверу\n" + e.getMessage());
        }
    };

    private void setPort() {
        System.out.println("----\nУкажите порт для подключения к серверу\n----");
        while (port == -1) {
            String numb = scan.nextLine();
            if (numb.matches("[0-9]+")) {
                int portCandidate = Integer.parseInt(numb);
                if (portCandidate < 65535 && portCandidate >= 0) {
                    port = portCandidate;
                } else {
                    System.out.println("----\nНедопустимый номер порта, введите снова\n----");
                }
            } else {
                System.out.println("----\nНедопустимый номер порта, введите снова\n----");
            }
        }
    }


    /**
     * run method
     * @throws IOException
     */
    public void run() throws IOException {
        String outputFilepath = System.getenv("lab5_data_filepath");
        Set<StudyGroup> groups = new TreeSet<>();
        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();
        String collectionInitializationDate = "";
//        try {
//            if (outputFilepath != null){
//                File outputFile = new File(outputFilepath);
//                if (!outputFile.exists()){
//                    throw new FileNotFoundException("Файл " + outputFilepath + " не найден. Проверьте переменную окружения 'lab5_data_filepath'");
//                } else if (!outputFile.canWrite()){
//                    throw new AccessDeniedException("Нет права на запись в файл " + outputFilepath);
//                } else if (!outputFile.canRead()){
//                    throw new AccessDeniedException("Нет права чтение файла " + outputFilepath);
//                } else {
//                    FileReader dataFileReader = new FileReader(outputFilepath);
//                    StudyGroup[] data = gson.fromJson(dataFileReader, StudyGroup[].class);
//                    StudyGroup[] clearData = Arrays.stream(data).filter(StudyGroup::isValid).toArray(StudyGroup[]::new);
//                    if(data.length != clearData.length){
//                        System.err.println("Некоторые данные некорректны");
//                    }
//                    Collections.addAll(groups, clearData);
//                    collectionInitializationDate = new Date(new File(outputFilepath).lastModified()).toString();
//                }
//            } else {
//                throw new RuntimeException("Переменная окружения 'lab5_data_filepath' не задана");
//            }
//        } catch (FileNotFoundException | AccessDeniedException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
        List<CommandEnum> history = new ArrayList<>();
        System.out.println("Введите команду (help - помощь)");
        DataInputSource inputSource = new DataInputSource(scan);
        Receiver programState = new Receiver(groups, outputFilepath, history, true, inputSource, collectionInitializationDate);
        while (programState.getWorking() && active){
            String command = programState.getSource().get();
            if (command.isEmpty()) {
                programState.removeFirstReader();
                continue;
            };
            Invoker invoker = new Invoker(programState, socket, serverAddress, port);
            programState = invoker.executeCommand(command);
        }
    }

    /**
     * stop method
     */
    public void stop(){
        active = false;
    }
}
