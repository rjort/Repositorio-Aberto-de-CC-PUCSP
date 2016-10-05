
import java.rmi.*;
import java.rmi.server.*;


public class CalculadoraClient
{  
   public static void main(String[] args)
   {  
      System.setProperty("java.security.policy", "client.policy");
      System.setSecurityManager(new RMISecurityManager());
      String url = "rmi://localhost/";
         
      try
      {  
         Calculadora c1 = (Calculadora)Naming.lookup(url + "calc1");
         Calculadora c2 = (Calculadora)Naming.lookup(url + "calc2");
         System.out.println(c1.getDescricao());
         System.out.println(c1.somarNumeros(30,40));
         System.out.println(c2.getDescricao());
         System.out.println(c1.subtrairNumeros(50,24));
      }
      catch(Exception e)
      {  
         e.printStackTrace();
      }
   }
}
