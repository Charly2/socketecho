import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static Scanner data_in = new Scanner(System.in);
    public static void main(String arg[]) throws IOException, ClassNotFoundException {
        int portNum = 11113;
        while(true){
            Socket socket = new Socket("localhost", portNum);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Ingresa Tu mensaje");
            String msj = data_in.nextLine();
            out.writeObject(msj);
            String response = (String) in.readObject();
            System.out.println("El servidor te respondio: " +response);   
        }
            
    }
}