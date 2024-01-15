import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket socket = null;

        try {
            InetAddress address = InetAddress.getByName("localhost");
            socket = new Socket(address, 1900);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            socket.getOutputStream())), true);

            for(int i = 0; i < 10; i++) {
                out.println("message " + i);
                String str = in.readLine();
                System.out.println(str);
            }

            out.println("END");
        }
        catch (Exception ex) {ex.printStackTrace();}
        finally {
            socket.close();
        }
    }
}
