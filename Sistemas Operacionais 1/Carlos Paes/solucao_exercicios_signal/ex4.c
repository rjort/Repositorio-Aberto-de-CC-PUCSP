#include <stdio.h> 
#include <signal.h>
#include <stdlib.h>

void main(int argc,char *argv[]) {

    int pid;
    int tempo;

    if (argc >= 3) {
       tempo = atoi(argv[1]);
       pid=fork();
       if (pid==0) {
           alarm(tempo);
           execlp(argv[2],argv[2],NULL);
       }

      wait();
      printf("\nFilho esgotou o tempo de %d segundos!\n",tempo);   

    } else
        printf("Argumentos nao definidos!\n");
    



}
