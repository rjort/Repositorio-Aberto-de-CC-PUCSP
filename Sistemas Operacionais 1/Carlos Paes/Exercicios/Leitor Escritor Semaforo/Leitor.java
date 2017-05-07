
public class Leitor extends Thread {

	private Semaforo mutex;
	private Semaforo semDB;
	private BancoDados bd;
	
	public Leitor(BancoDados banco, Semaforo m, Semaforo semDB) {
		this.semDB = semDB;
		mutex = m;
		bd = banco;	
	}
	
	public void run() {
		
		int i = 0;
		int valorLido;
		
		while(i<100) {
			mutex.P();
			bd.incremetarRc();
			if (bd.getRc() == 1) semDB.P(); //primeiro leitor trava o acesso ao BD
			mutex.V();
			valorLido = bd.getValor();
			mutex.P();
			bd.decrementarRc();
			if (bd.getRc() == 0) semDB.V(); //último leitor libera o acesso ao BD
			mutex.V();			
			System.out.println("Valor lido do BD = "+valorLido);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
	}
	
}
