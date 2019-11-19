import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Server1 implements Runnable {

    private static Socket clientDialog;
    public Server1(Socket client){
        this.clientDialog = client;
    }
    @Override
    public void run(){
        try {
            
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());

            while (!clientDialog.isClosed()) {
                String entry = in.readUTF();
                System.out.println("Someone: " + entry);
                if(entry.equals("@quit")){
                    out.writeUTF("Server reply -- " + entry + " -- OK");
                    break;
                }
            }


        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}