import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;
public class client{

    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader inputstreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try{
            socket = new Socket("localHost",1234);

            inputstreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputstreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);

            while(true){
                String msg = scanner.nextLine();

                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("server "+bufferedReader.readLine());

                if(msg.equalsIgnoreCase("Q")){
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}