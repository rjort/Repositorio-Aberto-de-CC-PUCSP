import java.net.*;
import java.io.*;

public class Cliente {


   public static void main(String args[]) {

      
         try {
            // abre um conexao com o localhost na porta 5432
            Socket s1 = new Socket("localhost",5432);
         
            // Obtem um input stream a partir do socket
            InputStream sinput = s1.getInputStream();
            DataInputStream dinput = new DataInputStream(sinput);
 
            // Le a entrada e imprime na saida padrao
            System.out.println(dinput.readUTF());
 
            // Quando finalizar, apenas fecha o stream e a conexao
            dinput.close();
            s1.close();
        } catch (IOException e) {
            // ignorar
        }
       
 
    }

}
