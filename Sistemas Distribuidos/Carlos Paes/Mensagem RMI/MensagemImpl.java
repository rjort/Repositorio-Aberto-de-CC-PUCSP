import java.rmi.server.*;
import java.rmi.*;

public class MensagemImpl extends UnicastRemoteObject implements Mensagem {
    private String mensagem = "Inicial";

    public MensagemImpl() throws RemoteException {}

    public String getMensagem() throws RemoteException {
        return mensagem;
    }
    public void setMensagem(String msg) throws RemoteException { 
        mensagem = msg;
    }
}
