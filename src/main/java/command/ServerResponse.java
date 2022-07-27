package command;

import messages.Message;
import util.StudyGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Set;

public class ServerResponse {
    Receiver prevState;
    Set<StudyGroup> updatedCollection;

    public ServerResponse(Receiver prevState, Message message, DatagramChannel channel, SocketAddress serverAddress) {
        System.out.println(message);
        System.out.println(channel);
        System.out.println(serverAddress);

        try{
            this.prevState = prevState;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(message);
            ByteBuffer sendBuffer = ByteBuffer.allocate(16384);
            sendBuffer.put(byteArrayOutputStream.toByteArray());
            objectOutputStream.flush();
            byteArrayOutputStream.flush();
            sendBuffer.flip();
            channel.send(sendBuffer, serverAddress);
            System.out.println("----\nСообщение отправлено.\n----");
            objectOutputStream.close();
            byteArrayOutputStream.close();
            sendBuffer.clear();
        } catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
    public Set<StudyGroup> getUpdatedCollection(){
        return updatedCollection;
    }
}
