public class TransacaoBancaria {


public static void main(String args[]) {

    Cliente cliente = new Cliente(124,"Jose da Silva",5000);
    Deposito dep = new Deposito(cliente);
    Retirada ret = new Retirada(cliente);

    System.out.println("Vou disparar as threads!!");
    dep.start();
    ret.start();

    try {
    
    	dep.join();
        ret.join();
        
    } catch(Exception e) {}
    
}


}