import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        Socket socket = null;

        try {
            String line = "";

            ss = new ServerSocket(1900);

            socket = ss.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader((socket.getInputStream())));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(
                            socket.getOutputStream())), true);

            while(!line.equals("END")) {
                line = in.readLine();
                out.println("ECHO " + line);
            }
        }
        catch (Exception e) {e.printStackTrace();}
        finally {
            ss.close();
            if(socket != null)
                socket.close();
        }
    }
}
