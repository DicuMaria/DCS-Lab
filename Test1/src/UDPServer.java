import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception{
        int port = 12345;
        DatagramSocket serverSocket = new DatagramSocket(port);
        // declare an array of bytes
        byte[] dataBytes = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(dataBytes, dataBytes.length);

        serverSocket.receive(datagramPacket);

        String sentence = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        System.out.println("Received: " + sentence);
    }
}