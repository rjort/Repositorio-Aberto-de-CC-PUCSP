#include <stdio.h>
#include <signal.h>

void main() {

   int valor;

   signal(SIGINT,SIG_IGN);

   do {
      printf("Entre com um valor = \n");
      scanf("%d",&valor);
   } while(valor != 10);

   printf("\nFim da execução!!\n");

}
