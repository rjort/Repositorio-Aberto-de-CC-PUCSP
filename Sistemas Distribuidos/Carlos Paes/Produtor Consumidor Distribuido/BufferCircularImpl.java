/**
   @version 1.00 1996-09-07
   @author Carlos Paes
*/

import java.rmi.*;
import java.rmi.server.*;

public class BufferCircularImpl
   extends UnicastRemoteObject
   implements BufferCircular
{ 
   
   public BufferCircularImpl() throws RemoteException
   {  
      in = 0;
      out = 0;
      count = 0;
      buffer = new Object[BUFFER_SIZE];
   }

   public synchronized void enter(Object item) throws RemoteException
   {  
      if (count == BUFFER_SIZE) {
         try {
           System.out.println("Cliente Produtor bloqueado.. Buffer esta cheio...");
           wait();
         } catch (InterruptedException e) { }
      }
      ++count;
      buffer[in] = item;
      in = (in+1) % BUFFER_SIZE;
      if (count == BUFFER_SIZE)
         System.out.println("Produtor entrou com um item no Buffer: "+item+" Buffer esta cheio");
      else
         System.out.println("Produtor entrou com um item no Buffer: "+item+" Posicao: "+count);
      notify();
   }
   
   public synchronized Object remove() throws RemoteException
   {
      Object item;

      if (count == 0) {
         try {
           System.out.println("Cliente Consumidor bloqueado.. Buffer esta vazio...");
           wait();
         } catch (InterruptedException e) { }
      }
      --count;
      item = buffer[out];
      out = (out+1) % BUFFER_SIZE;
      if (count == 0)
        System.out.println("Consumidor retirou um item: "+item+" Buffer esta vazio");
      else
         System.out.println("Consumidor retirou um item: "+item+" Posicao: "+count);
      notify();
      return item;
   }

   private static final int BUFFER_SIZE = 5;
   private int count,in,out;
   private Object[] buffer;
}
