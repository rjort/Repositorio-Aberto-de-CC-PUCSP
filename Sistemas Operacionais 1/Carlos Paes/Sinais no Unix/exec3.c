#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int main(){

    int valor;

    signal(SIGINT,SIG_IGN); // ignorando crtl+C

    do {

       printf("Entre com um valor:");
       scanf("%d",&valor);
       printf("\n");

    } while(valor != 10);

    exit(0);

}
