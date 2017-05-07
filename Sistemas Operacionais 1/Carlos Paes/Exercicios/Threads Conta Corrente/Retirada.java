public class Retirada extends Thread {

   public Retirada(Cliente cli) {
       cliente = cli;
   }

   public void retirar(float valor) {
        float novo_saldo;

        novo_saldo = cliente.getSaldo();
        novo_saldo = novo_saldo - valor;
        cliente.setSaldo(novo_saldo);
    }

    public void run() {

        while(true) {
           System.out.println("Vou retiarar R$10,00 !");
           retirar(10);
           System.out.println("Saldo final retirada = "+cliente.getSaldo());
           try {
             sleep(1000);
           } catch (Exception e) {
              e.printStackTrace();
            
            }
        }

    }
   
    private Cliente cliente;

}