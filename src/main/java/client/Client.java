package client;

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
        System.out.println("Укажите порт для подключения к серверу:");
        while (port == -1) {
            String numb = scan.nextLine();
            if (numb.matches("[0-9]+")) {
                int portCandidate = Integer.parseInt(numb);
                if (portCandidate < 65535 && portCandidate >= 0) {
                    port = portCandidate;
                } else {
                    System.out.println("Недопустимый номер порта, попробуйте ещё раз:");
                }
            } else {
                System.out.println("Недопустимый номер порта, попробуйте ещё раз:");
            }
        }
    }


    /**
     * run method
     */
    public void run() {
        Set<StudyGroup> groups = new TreeSet<>();
        String collectionInitializationDate = "";
        System.out.println("Введите команду (help - помощь)");
        DataInputSource inputSource = new DataInputSource(scan);
        Receiver programState = new Receiver(groups, true, inputSource, collectionInitializationDate);
        while (programState.getWorking() && active){
            try{
                String command = programState.getSource().get();
                if (command.isEmpty()) {
                    programState.removeFirstReader();
                    continue;
                };
                Invoker invoker = new Invoker(programState, socket, serverAddress, port);
                programState = invoker.executeCommand(command);
            } catch (IOException e){
                System.err.println("Ошибка обработки команды");
            }
        }
    }

    /**
     * stop method
     */
    public void stop(){
        active = false;
    }
}
