#include <stdio.h>
#include <signal.h>

static void rotinaAlarme();

void main() {

    signal(SIGALRM,rotinaAlarme);
    while(1) {
      //printf("Estou processando!!\n");
    }
}

static void rotinaAlarme() {
    printf("\nAlarme chegou!!!\n");
}
