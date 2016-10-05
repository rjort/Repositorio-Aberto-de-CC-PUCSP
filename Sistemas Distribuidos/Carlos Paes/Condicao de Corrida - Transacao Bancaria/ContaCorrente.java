
public class ContaCorrente {
	
	private String nome;
	private float saldo;
	private int numero_conta;
	
	public ContaCorrente(int nc, String s, float sld) {
		numero_conta = nc;
	    nome = s;
	    saldo = sld;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public int getNumero_conta() {
		return numero_conta;
	}
	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}
	
	public void retirada(float valor) {
		float novo_saldo;

        novo_saldo = getSaldo();
        novo_saldo = novo_saldo - valor;
        setSaldo(novo_saldo);
	}
	
	public void deposito(float valor) {
		 float novo_saldo;

	     novo_saldo = getSaldo();
	     novo_saldo = novo_saldo + valor;
	     setSaldo(novo_saldo);
		
	}
	
	
	

}
