
public class Escritor extends Thread {
	
	private Semaforo semDB;
	private BancoDados bd;
	
	public Escritor(BancoDados banco, Semaforo semDB) {
		this.semDB = semDB;
		bd = banco;	
	}
	
	public void run() {
		
		int i = 0;
		while(i<100) {
			semDB.P();
			bd.setValor(bd.getValor()+i);
			System.out.println("Escritor alterou o valor do BD para: "+bd.getValor());
			semDB.V();
			
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
