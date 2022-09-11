package client;

import command.Receiver;
import messages.Message;
import util.StudyGroup;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class ServerResponse {
    Receiver prevState;
    Set<StudyGroup> updatedCollection;
    private DatagramSocket socket;
    private InetAddress serverAddress;
    private byte[] bytes = new byte[16384];

    public ServerResponse(Receiver prevState, Message message, DatagramSocket socket, InetAddress serverAddress) {
        System.out.println(message);
        System.out.println(socket);
        System.out.println(serverAddress);
        this.socket = socket;
        this.serverAddress = serverAddress;
        try{
            this.prevState = prevState;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, serverAddress, 3333);
            socket.send(datagramPacket);
            System.out.println("----\nПакет отправлен.\n----");

//            ByteBuffer sendBuffer = ByteBuffer.allocate(16384);
//            sendBuffer.put(byteArrayOutputStream.toByteArray());
//            objectOutputStream.flush();
//            byteArrayOutputStream.flush();
//            sendBuffer.flip();
//
//            channel.send(sendBuffer, serverAddress);
//            System.out.println("----\nСообщение отправлено.\n----");
//
//            objectOutputStream.close();
//            byteArrayOutputStream.close();
//            sendBuffer.clear();


        } catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }

    public Set<StudyGroup> getUpdatedCollection(){
        return updatedCollection;
    }
}
