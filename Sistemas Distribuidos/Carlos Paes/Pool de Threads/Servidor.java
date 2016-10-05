import java.net.*;
import java.io.*;

public class Servidor {


   public static void main(String args[]) {

		BoundedBuffer buffer = new BoundedBuffer();
		
      // Registro do servico na porta 5432
	  
	  System.out.println("Iniciando o servidor....");
	  System.out.println("Criando o pool de threads....");
	  for(int i = 0;i<30;i++) 
		  (new ConexaoTratador(buffer)).start();
      System.out.println("Pool de threads criado!!!");
      try {
           ServerSocket  server = new ServerSocket(5400,50);             
             
          // Executa o loop de aceitacao infinitamente

          while(true) {

              // para neste ponto e aguarda por uma conexao 
              System.out.println("Aguardando conexao do cliente.....");
              Socket s1 = server.accept();
			  System.out.println("Conexao recebida!");
              buffer.enter(s1);
        }
      } catch (IOException e) {
            // ignorar
       }       
 
    }

}

