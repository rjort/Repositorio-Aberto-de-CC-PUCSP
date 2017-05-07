public class Cliente {


public Cliente(int nc, String s, float sld) {
    numero_conta = nc;
    nome = s;
    saldo = sld;
}


public void setNome(String novo_nome) {

      nome = novo_nome;
}
public String getNome() {

   return nome;
}

public void setSaldo(float novo_saldo) {
    saldo = novo_saldo;
}

public float getSaldo() {
  return saldo;
}

public int getNumeroConta() {
   return numero_conta;
}


private String nome;
private float saldo;
private int numero_conta;

}