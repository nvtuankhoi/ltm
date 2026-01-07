import java.net.*;
import java.io.*;
import java.util.*;

public class sample {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        InetAddress address = InetAddress.getByName("203.162.10.109");
        int port = 2207;

        String code = ";B22DCCN466;sample;";
        DatagramPacket sendPacket = new DatagramPacket(code.getBytes(), code.length(), address, port);
        socket.send(sendPacket);
        byte[] buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivePacket);

        String requestId = new String(receivePacket.getData(), 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData(), 8, receivePacket.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = ois.readObject();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.flush();
        byte[] sendData = baos.toByteArray();
        byte[] finalData = new byte[8 + baos.size()];
        System.arraycopy(requestId.getBytes(), 0, finalData, 0, 8);
        System.arraycopy(sendData, 0, finalData, 8, sendData.length);
        DatagramPacket sendPacket1 = new DatagramPacket(finalData, finalData.length, address, port);
        socket.send(sendPacket1);
        socket.close();
    }
}
