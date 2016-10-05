public class Retirada extends Thread {

   public Retirada(ContaCorrente cta) {
       conta = cta;
   }
   
    public void run() {

        while(true) {
           System.out.println("Vou retiarar R$10,00 !");
           conta.retirada(10);
           System.out.println("Saldo final retirada = "+conta.getSaldo());
           try {
             sleep(1000);
           } catch (Exception e) {
              e.printStackTrace();
            
            }
        }

    }
   
    private ContaCorrente conta;

}