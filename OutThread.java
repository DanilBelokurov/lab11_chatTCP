
import java.net.*;
import java.util.Scanner;
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
                } else if(message.contains("@cat") ){
                    String filename = message.substring(5);
                    String filepath = System.getProperty("user.dir");

                    File folder = new File(filepath);
                    File[] listOfFiles = folder.listFiles();
                    
                    boolean check = false;
                    for(int i = 0; i < listOfFiles.length; i++){
                        if(listOfFiles[i].getName().equals(filename))
                            check = true;
                    }
                    
                    if(!check){
                        out.writeUTF("Sorry, your file was not find");
                    }

                    

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
