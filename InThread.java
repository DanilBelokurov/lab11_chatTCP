
import java.net.*;
import java.io.*;

public class InThread extends Thread {
    private DataInputStream in;
    private DataOutputStream out;

    public InThread(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
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
                }
                if (message.contains("@cat")) {
                    String filename = message.substring(5);
                    String filepath = System.getProperty("user.dir");

                    File folder = new File(filepath);
                    File[] listOfFiles = folder.listFiles();
        
                    boolean check = false;
                    for(int i = 0; i < listOfFiles.length; i++){
                        listOfFiles[i].toString().substring(filepath.length() + 1);
                        if(listOfFiles[i].getName().equals(filename)){
                            check = true;
                            out.writeUTF(readTXT(filename));
                            break;
                        }
                    }
                    if(!check){
                        out.writeUTF("Sorry, your file was not find");
                        continue;
                    }
                    continue;
                }
                System.out.println(message);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String readTXT(String filename) throws IOException {
        StringBuffer result = new StringBuffer();
        
        BufferedReader  fin = new BufferedReader( new InputStreamReader(new FileInputStream(filename)));
        String str ;
        
        while( (str = fin.readLine() ) != null )
            result.append(str + '\n');
        
        fin.close() ;
        return result.toString();
    }
}