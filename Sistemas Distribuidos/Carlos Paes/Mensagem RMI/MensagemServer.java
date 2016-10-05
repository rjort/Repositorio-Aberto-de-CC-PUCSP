import java.rmi.*;
import java.io.*;

public class MensagemServer {

    public static void main(String[] args) throws RemoteException {
        Mensagem mens = new MensagemImpl();
        try {
        Naming.rebind("mensagens", mens);
        System.out.println("Servidor no ar.  Nome do objeto servido: "
		+ "mensagens" +"'");
        } catch (IOException e) {
            // ignorar
       }
        
    }

}
