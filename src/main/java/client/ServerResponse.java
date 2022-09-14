package client;

import command.Receiver;
import messages.Message;
import util.StudyGroup;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;

public class ServerResponse {
    Set<StudyGroup> updatedCollection;
    private final DatagramSocket socket;
    private final InetAddress serverAddress;
    private byte[] bytes = new byte[16384];
    private int port = -1;
    Message message;

    public ServerResponse(Message message, DatagramSocket socket, InetAddress serverAddress, int port) {
        this.socket = socket;
        this.serverAddress = serverAddress;
        this.message = message;
        this.port = port;
        sendPacket();
        getMessage();
    }

    private void sendPacket(){
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, serverAddress, port);
            socket.send(datagramPacket);
            System.out.println("----\nПакет отправлен.\n----");
        } catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }

    private void getMessage () {
        System.out.println("getMessage call");
        try{
            byte[] bytes = new byte[16384];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(datagramPacket);
            System.out.println(datagramPacket);
            String received = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(received);
        } catch (IOException e){
            System.err.println("Возникла ошибка при обработке ответа сервера");
        }
    }

    public Set<StudyGroup> getUpdatedCollection(){
        return updatedCollection;
    }
}
