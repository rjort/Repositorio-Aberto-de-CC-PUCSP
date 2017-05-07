public class Deposito extends Thread {

   public Deposito(Cliente cli) {
       cliente = cli;
   }

   public void depositar(float valor) {
        float novo_saldo;

        novo_saldo = cliente.getSaldo();
        novo_saldo = novo_saldo + valor;
        cliente.setSaldo(novo_saldo);
    }

    public void run() {

        while(true) {
           System.out.println("Vou depositar R$10,00 !");
           depositar(10);
	   System.out.println("Saldo final deposito = "+cliente.getSaldo());
           try {
             sleep(1000);
           } catch (Exception e) {
             e.printStackTrace();
           }
        }

    }

    private Cliente cliente;

}