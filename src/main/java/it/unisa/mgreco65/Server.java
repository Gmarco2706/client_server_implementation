package it.unisa.mgreco65;


import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    static Logger logger = Logger.getLogger("global");
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(9000);
            logger.info("Socketok, accetto conn...");
            Socket socket = serverSocket.accept();
            logger.info("Accettata una connessione...");
            ObjectOutputStream oS= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream iS = new ObjectInputStream(socket.getInputStream());
            String nome = (String) iS.readObject();
            logger.info("Ricevuto: "+ nome);
            oS.writeObject("Ciao " + nome);
            socket.close();
        }catch(EOFException e ){
            logger.severe("Problemi di connessione");
            e.printStackTrace();
        }catch(Throwable t ){
            logger.severe("Lanciata Throwable: "+t.getMessage());
            t.printStackTrace();
        }
    }
}