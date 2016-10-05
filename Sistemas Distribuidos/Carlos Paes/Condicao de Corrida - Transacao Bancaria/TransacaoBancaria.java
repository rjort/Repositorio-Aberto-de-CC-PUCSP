public class TransacaoBancaria {


public static void main(String args[]) {

    ContaCorrente conta = new ContaCorrente(124,"Jose da Silva",5000);
    Deposito dep = new Deposito(conta);
    Retirada ret = new Retirada(conta);

    System.out.println("Vou disparar as threads!!");
    dep.start();
    ret.start();
    while(true) {
       
    }
}


}