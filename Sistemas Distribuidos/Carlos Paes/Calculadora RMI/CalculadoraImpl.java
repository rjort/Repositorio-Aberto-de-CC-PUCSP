
import java.rmi.*;
import java.rmi.server.*;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora
{ 
   public CalculadoraImpl(String n) throws RemoteException
   {  
      nome = n;
   }

   public String getDescricao() throws RemoteException
   {  
      return "Eu sou a calculadora = " + nome;
   }

   public float somarNumeros(float n1,float n2) throws RemoteException
   {
       return n1+n2;
   
   }

   public float subtrairNumeros(float n1,float n2) throws RemoteException
   {
       return n1-n2;
   }

   private String nome;
}
