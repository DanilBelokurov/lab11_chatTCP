
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 5555);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

           /* System.out.println("Client connected");

            while (!socket.isOutputShutdown()) {
                System.out.print(you + ": ");
                String message = scanner.nextLine();

                if (message.equals("@name")) {
                    System.out.println("Type your new name: ");
                    you = scanner.nextLine();
                    out.writeUTF(message);
                    out.writeUTF(you);
                    continue;
                }else if (message.equals("@quit")) {
                    String quitMessage = "You typed QUIT, our dialog is over! :(";
                    out.writeUTF(quitMessage);
                    socket.close();
                    System.exit(0);
                }
                out.writeUTF(message);
                if(br.ready()){
                    String m = br.readLine();
                    out.writeUTF(m);
                    out.flush();
                }
            }

            System.out.println("Address: ");
            String address = scan.nextLine();
            InetAddress ip = InetAddress.getByName(address);

            System.out.println("Port: ");
            int port = Integer.parseInt(scan.nextLine());

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
*/
            InThread inT = new InThread(in);
            OutThread outT = new OutThread(out);
            inT.start();
            outT.start();
            outT.join();
        }catch (Exception ex) {}
    }
}
