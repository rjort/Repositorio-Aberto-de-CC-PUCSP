public class Deposito extends Thread {

   public Deposito(ContaCorrente cta) {
       conta = cta;
   }

  
    public void run() {

        while(true) {
           System.out.println("Vou depositar R$10,00 !");
           conta.deposito(10);
	   System.out.println("Saldo final deposito = "+conta.getSaldo());
           try {
             sleep(1000);
           } catch (Exception e) {
             e.printStackTrace();
           }
        }

    }

    private ContaCorrente conta;

}