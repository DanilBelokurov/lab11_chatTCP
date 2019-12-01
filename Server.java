import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {

            ServerSocket server = new ServerSocket(5555);

            Socket socket = server.accept();
            System.out.println("Connected");

            InThread in = new InThread(new DataInputStream(socket.getInputStream()),
                                          new DataOutputStream(socket.getOutputStream()) );

            OutThread out = new OutThread(new DataOutputStream(socket.getOutputStream()));
            in.start();
            out.start();

            server.close();
            } catch (IOException e) { }
    }
}