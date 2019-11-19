
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Server {
	public static void main(String[] args) {
		try {

            /*Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the port: ");
            String serverPort = scanner.nextLine();*/

            ServerSocket server = new ServerSocket(5555);
            Socket socket = server.accept();
            System.out.println("Connected");
            String entering = "Server is running!";
            InThread in = new InThread(new DataInputStream(socket.getInputStream()));
            OutThread out = new OutThread(new DataOutputStream(socket.getOutputStream()));
            in.start();
            out.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}