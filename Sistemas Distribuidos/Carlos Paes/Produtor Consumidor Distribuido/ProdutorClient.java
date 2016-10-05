import java.rmi.*;
import java.rmi.server.*;

public class ProdutorClient
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
      String item;
      int i=0;
         
      try
      {  
         BufferCircular b1 = (BufferCircular)Naming.lookup(url + "buffer_prodcons");
         
         while(true) {
            System.out.println("Invocando metodo remoto...");
            System.out.println("Gerando um novo item...");
            item = "ITEM #"+i;
            i++;
            b1.enter(item);
            System.out.println("Item inserido no buffer: "+item);
            dormir();
         }
      } catch(Exception e){  
         e.printStackTrace();
        }
   }
}
