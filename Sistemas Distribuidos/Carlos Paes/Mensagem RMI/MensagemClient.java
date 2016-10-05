import java.rmi.*;

public class MensagemClient {
    public static void main(String[] args) throws Exception {

        String hostname = args[0];
        String objeto = args[1];
        Object obj = Naming.lookup("rmi://" + hostname + "/"+ objeto);
        Mensagem mens = (Mensagem) obj;
        System.out.println("Mensagem recebida:  "+ mens.getMensagem());
        mens.setMensagem("Fulano esteve aqui!");

    }
}
