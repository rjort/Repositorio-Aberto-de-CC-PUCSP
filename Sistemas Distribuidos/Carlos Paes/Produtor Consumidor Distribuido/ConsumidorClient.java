
import java.rmi.*;
import java.rmi.server.*;

public class ConsumidorClient
{  
   public static void dormir() {
      int sleepTime = (int) (5*Math.random());

      try {
         Thread.sleep(sleepTime*1000);
      } catch (InterruptedException e) {}
   }

   public static void main(String[] args)
   {  
      System.setProperty("java.security.policy", "client.policy");
      System.setSecurityManager(new RMISecurityManager());
      
      String url = "rmi://localhost/";
      Object item;
         
      try
      {  
         BufferCircular b1 = (BufferCircular)Naming.lookup(url + "buffer_prodcons");
         while(true) {
            System.out.println("Invocando metodo remoto...");
            item = b1.remove();
            System.out.println("Item removido do buffer: "+item);
            dormir();
      
         }
      } catch(Exception e){  
         e.printStackTrace();
        }
   }
}
