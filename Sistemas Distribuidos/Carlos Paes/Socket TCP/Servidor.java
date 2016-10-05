import java.net.*;
import java.io.*;

public class Servidor {


   public static void main(String args[]) {

      
      // Registro do servico na porta 5432

      try {
           ServerSocket  server = new ServerSocket(5432,50);             
             
          // Executa o loop de aceitacao infinitamente

          while(true) {

              // para neste ponto e aguarda por uma conexao 

              Socket s1 = server.accept();
         
              // Obtem o stream associado com o socket
              OutputStream sout = s1.getOutputStream();
              DataOutputStream dos = new DataOutputStream(sout);
 
             // Envia uma string
             dos.writeUTF("Hello Net World !!");
 
             // Fecha a conexao, mas nao o socket do servidor
             dos.close();
             s1.close();
        }
      } catch (IOException e) {
            // ignorar
       }       
 
    }

}

