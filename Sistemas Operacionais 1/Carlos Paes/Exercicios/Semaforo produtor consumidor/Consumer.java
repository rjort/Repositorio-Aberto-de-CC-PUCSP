
import java.util.*;

public class Consumer extends Thread
{
   public Consumer(BoundedBuffer b, Semaforo m, Semaforo e, Semaforo f)
   {
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
         
         // consume an item from the buffer
         System.out.println("Consumer wants to consume.");
         full.P();
         mutex.P();  
         message = (Date)buffer.remove();
         mutex.V();
         empty.V();
      }
   }
   
   private  BoundedBuffer buffer;
   private Semaforo mutex;
   private Semaforo empty;
   private Semaforo full;
}


