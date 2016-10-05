import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ConexaoTratador extends Thread {
	
	private BoundedBuffer buffer;
	
	public ConexaoTratador(BoundedBuffer bf) {
		buffer = bf;
	}
	
	public void run() {
		while(true) {
			Socket socket = (Socket) buffer.remove();
			System.out.println("Vou tratar um socket!!");
	        // Obtem o stream associado com o socket
	              OutputStream sout;
				try {
					sout = socket.getOutputStream();
					 DataOutputStream dos = new DataOutputStream(sout);
					 
		             // Envia uma string
		             dos.writeUTF("Hello Net World !!");
		 
		             // Fecha a conexao, mas nao o socket do servidor
		             dos.close();
		             socket.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
		}         	
	}

}
