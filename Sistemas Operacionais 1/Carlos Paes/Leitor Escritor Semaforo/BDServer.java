
public class BDServer {

	public static void main(String[] args) {


		Semaforo mutex = new Semaforo(1);
		Semaforo semdb = new Semaforo(1);
		BancoDados bd = new BancoDados(500);
		
		Leitor[] leitores = new Leitor[5];
		Escritor[] escritores = new Escritor[5];
		
		for(int i=0;i<5;i++){
			leitores[i] = new Leitor(bd,mutex,semdb);
			escritores[i] = new Escritor(bd,semdb);
			leitores[i].start();
			escritores[i].start();
		}	
		
		for(int i=0;i<5;i++) {
			try {
				leitores[i].join();
				escritores[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Fim da execução das threads Leitoras e Escritoras!");
		
	}

}
