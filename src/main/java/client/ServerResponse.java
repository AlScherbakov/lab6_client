package client;

import messages.Message;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerResponse {
    private final DatagramSocket socket;
    private final InetAddress serverAddress;
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
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, serverAddress, port);
            socket.send(datagramPacket);
        } catch (IOException exception){
            System.err.println("Ошибка при отправке запроса на сервер\n" + exception.getMessage());
        }
    }

    private void getMessage () {
        try{
            byte[] bytes = new byte[16384];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(datagramPacket);
            String received = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(received);
        } catch (IOException e){
            System.err.println("Ошибка при обработке ответа сервера\n" + e.getMessage());
        }
    }
}
