package it.unisa.mgreco65;



import java.net.Socket;
import java.util.logging.Logger;
import java.io.*;

public class Client{
    static Logger logger = Logger.getLogger("global");
    public static void main(String args[]){
        try{
            Socket socket = new Socket("localhost", 9000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeObject("Marco");
            System.out.println(in.readObject());
            socket.close();
        }catch(EOFException e){
            logger.severe("Problemi di connessione: "+ e.getMessage());
            e.printStackTrace();
        }
        catch(Throwable t){
            logger.severe(("Lanciata Throwable: "+ t.getMessage()));
            t.printStackTrace();
        }
    }
}
