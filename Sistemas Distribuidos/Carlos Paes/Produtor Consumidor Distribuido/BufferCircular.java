
import java.rmi.*;

/**
   The interface for remote product objects.
*/

public interface BufferCircular extends Remote
{ 
   public void enter(Object item) throws RemoteException;
   public Object remove() throws RemoteException;
   
}
