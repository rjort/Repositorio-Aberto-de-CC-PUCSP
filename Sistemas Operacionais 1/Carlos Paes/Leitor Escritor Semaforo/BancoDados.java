
public class BancoDados {

	private int rc;
	private int valor;
	
	public BancoDados (int v) {
		valor = v;
	}
	
	public int getRc() {
		return rc;
	}
	public void setRc(int rc) {
		this.rc = rc;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public void incremetarRc() {
	  rc = rc+1;	
	}
	public void decrementarRc() {
	  rc=rc-1;
	}
}
