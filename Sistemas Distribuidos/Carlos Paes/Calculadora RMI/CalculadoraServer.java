
import java.rmi.*;
import java.rmi.server.*;


public class CalculadoraServer
{  
   public static void main(String args[])
   {  
      try
      {  
         System.out.println
            ("Construindo a implementacao do Servidor...");

         CalculadoraImpl calc1
            = new CalculadoraImpl("Calculadora 1");
         CalculadoraImpl calc2
            = new CalculadoraImpl("Calculadora 2");

         System.out.println
            ("Ligando a implementação do servidor no registro...");

         Naming.rebind("calc1", calc1);
         Naming.rebind("calc2", calc2);

         System.out.println
            ("Aguardando a invocacao dos clientes...");
      }
      catch(Exception e)
      {  
         e.printStackTrace();
      }
   }
}

