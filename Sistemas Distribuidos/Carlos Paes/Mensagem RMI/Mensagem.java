import java.rmi.*;

public interface Mensagem extends Remote {

    public String getMensagem() throws RemoteException;
    public void setMensagem(String msg) throws RemoteException;

}
