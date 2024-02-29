import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
    public static void main(String[] args) throws IOException{
        
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(1234);

        while(true){

            try{
            socket = serverSocket.accept();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            while(true){
                String msg = bufferedReader.readLine();

                System.out.println("Client: "+msg);
                bufferedWriter.write("msg recieved.");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if(msg.equalsIgnoreCase("bye")){
                    System.out.println("connection ended ");
                    break;
                }
                
            }
            socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();

        
    }catch(IOException e){
        e.printStackTrace();
    }

    
    }
}
}