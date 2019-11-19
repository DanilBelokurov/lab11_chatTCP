
import java.net.*;
import java.io.*;

public class InThread extends Thread {
    private DataInputStream in;

    public InThread(DataInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String name = "Server";
            while (true) {
                String message = in.readUTF();

                if (message.equals("@name")) {
                    String newName = in.readUTF();
                    name = newName;
                } else {
                    System.out.println(name + ": " + message);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}