import java.net.*;
import java.util.*;
import java.io.*;

public class OutThread extends  Thread{
    private Scanner scanner = new Scanner(System.in);
    private DataOutputStream out;

    public OutThread(DataOutputStream out){
        this.out = out;
    }

    @Override
    public void run(){
        try{
            String name = "You";
            while (true) {

                System.out.print(name + ": ");
                String message = scanner.nextLine();

                if (message.equals("@name")) {
                    System.out.println("Type your new name: ");
                    name = scanner.nextLine();
                    out.writeUTF(message);
                    out.writeUTF(name);
                    continue;
                
                }else if (message.equals("@quit")) {
                    String quitMessage = "You typed QUIT, our dialog is over! :(";
                    out.writeUTF(quitMessage);
                    out.close();
                    System.exit(0);
                }else if (message.contains("@cat")) {
                    out.writeUTF(message);
                    continue;
                }

                out.writeUTF(message);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally{
            scanner.close();
        }
    }
}
