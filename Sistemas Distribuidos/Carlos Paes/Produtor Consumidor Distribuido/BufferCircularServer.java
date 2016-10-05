/**
   @version 1.10 1999-08-21
   @author Carlos Paes
*/

import java.rmi.*;
import java.rmi.server.*;

public class BufferCircularServer
{  
   public static void main(String args[])
   {  
      try
      {  
         System.out.println
            ("Construindo a implementacao do servidor...");

         BufferCircularImpl buffer1
            = new BufferCircularImpl();
       
         System.out.println
            ("Amarrando a implementacao ao registro...");

         Naming.rebind("buffer_prodcons", buffer1);

         System.out.println
            ("Aguardando as invocacoes dos cliente...");
      }
      catch(Exception e)
      {  
         e.printStackTrace();
      }
   }
}

