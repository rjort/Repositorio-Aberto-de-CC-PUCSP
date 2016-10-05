#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
    int pid;
    int time;
    char cmd[30];

    if (argc > 2) {

        pid = fork(); /* cria outro processo */
        if (pid < 0) { /* ocorrência de erro*/
            printf("Criação Falhou");
            exit(-1);
        }
        else if (pid == 0) { /* processo filho*/
            time = atoi(argv[1]);
            strcpy(cmd,"./");
            strcat(cmd,argv[2]);
            alarm(time);
            execlp(cmd, argv[2], NULL);
        }
        else { /* processo pai */
            wait (NULL); /* pai irá esperar o filho completar execução */
            printf ("Filho Completou Execução!\n");

        }

    }
     else printf("Falta parametros! exec5 <tempo alarme> <nome programa> \n");

    exit(0);
}
