package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import command.CommandEnum;
import command.Invoker;
import command.Receiver;
import messages.Message;
import util.DataInputSource;
import util.StudyGroup;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.*;

/**
 * Client class from Command pattern. Main process host. May be used for creation of several application instances
 */
public class Client {
    private final Scanner scan;
    boolean active = true;

    private int PORT = 3333;
    private boolean isServerAlive = false;
//    private DatagramChannel channel;
    private InetAddress serverAddress;

    private DatagramSocket socket;

    public Client(Scanner s) {
        scan = s;
        try{
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName("localhost");
        } catch (UnknownHostException | SocketException exception) {
            System.err.println(exception.getMessage());
        }
    };

//    protected void setPort(){
//        InetSocketAddress localAddress = null;
//        System.out.println("----\nУкажите порт для подключения к серверу\n----");
//        while (localAddress.toString().length() < 1) {
//            String numb = scan.nextLine();
//            if (numb.matches("[0-9]+")) {
//                if (Integer.parseInt(numb) < 65535 && Integer.parseInt(numb) >= 0) {
//                    localAddress = new InetSocketAddress("localhost", Integer.parseInt(numb));
//                    this.serverAddress = localAddress;
//                } else {
//                    System.out.println("----\nНедопустимый номер порта, введите снова\n----");
//                }
//            } else {
//                System.out.println("----\nНедопустимый номер порта, введите снова\n----");
//            }
//        }
//    }


// buffered reader, custom tag

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
            Invoker invoker = new Invoker(programState, socket, serverAddress);
            programState = invoker.executeCommand(command);
            getMessage();
        }
    }

    public void getMessage () {
        System.out.println("getMessage call");
        try{
            byte[] bytes = new byte[16384];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(datagramPacket);
            System.out.println(datagramPacket);
            String received = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            Object serverResponse = objectInputStream.readObject();
            System.out.println("serverResponse:" + received);
//            if(clientMessage == null) return;
//            String response = new CommandExecutor((Message) clientMessage).execute();
//            server.sender.send(response);
//            byteArrayInputStream.close();
//            objectInputStream.close();

//            ByteBuffer receiveBuffer = ByteBuffer.allocate(16384);
//            channel.receive(receiveBuffer);
//            String received = extractMessage(receiveBuffer);
//            System.out.println(received + "- received");

        } catch (IOException e){
            System.err.println("Возникла ошибка при обработке ответа сервера");
        }
    }

    /**
     * stop method
     */
    public void stop(){
        active = false;
    }
}
