import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost");
        String msg = "asd";
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, IPAddress, 12345);

        clientSocket.send(datagramPacket);
        System.out.println("Sent to server: " + msg);
    }
}
