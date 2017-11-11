#include <stdio.h>
#include <signal.h>

void main() {

   int pid;

   printf("Entre com o pid do processo: ");
   scanf("%d",&pid);
   kill(pid,SIGUSR1);
   printf("\nSinal SIGAUSR1 enviado! Vou dormir 5 segundo e depois mandar um SIGKILL!\n");
   sleep(5);
   kill(pid,SIGKILL);

}
