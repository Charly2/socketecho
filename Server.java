import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int portNum = 11113;
        ServerSocket listener = new ServerSocket(portNum);
        System.out.println("Servidor en linea en el puerto:" + portNum);
        while (true) {
            try {
                Socket clientSocket = listener.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                String req = (String) in.readObject();
                System.out.println("El cliente te dijo: " +req);
                out.writeObject(req);
                System.out.println(req);
                out.close();
                in.close();
                clientSocket.close();
            } finally {
                //System.out.println("Adios");
            }
        }
    }

}