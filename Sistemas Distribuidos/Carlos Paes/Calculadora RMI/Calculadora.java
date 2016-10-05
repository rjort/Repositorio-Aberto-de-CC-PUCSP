
import java.rmi.*;


public interface Calculadora extends Remote
{ 
   String getDescricao() throws RemoteException;
   float somarNumeros(float n1,float n2) throws RemoteException;
   float subtrairNumeros(float n1,float n2) throws RemoteException;
}
