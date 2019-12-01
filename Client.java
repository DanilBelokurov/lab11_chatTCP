import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5555);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            InThread inT = new InThread(in, out);
            OutThread outT = new OutThread(out);
            inT.start();
            outT.start();
            outT.join();

        }catch (Exception ex) {}
    }
}
