
import java.util.*;

public class Producer extends Thread
{
   public Producer(BoundedBuffer b, Semaforo m, Semaforo e, Semaforo f) {
      buffer = b;
      mutex = m;
      empty = e;
      full = f;
   }
   
   public void run()
   {
   Date message;
     
      while (true)
      {
  	      BoundedBuffer.napping();
          // produce an item & enter it into the buffer
         message = new Date();      
         System.out.println("Producer produced " + message);
         empty.P();
         mutex.P();  
         buffer.enter(message);
         mutex.V();
         full.V();
      }
   }
   
   private BoundedBuffer buffer;
   private Semaforo mutex;
   private Semaforo empty;
   private Semaforo full;
}
