#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int main() {

    int pid;

    printf("Entre com o pid do processo:");
    scanf("%d",&pid);

    kill(pid,SIGUSR1);
    printf("SIGUSR1 enviado ao processo %d",pid);
    sleep(5);
    kill(pid,SIGKILL);
    printf("SIGKILLenviado ao processo %d",pid);

    exit(0);
}
