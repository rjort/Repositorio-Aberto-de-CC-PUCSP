#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>

#define MEM_SZ 4096

struct uso_compartilhado {
    int vez;
    char texto[BUFSIZ];
};

int main()
{
    int running = 1;
    void *memoria_comp = (void *)0;
    struct uso_compartilhado *compartilhado_uso;
    int shmid;

    shmid = shmget((key_t)1234, MEM_SZ, 0666 | IPC_CREAT);

    memoria_comp = shmat(shmid, (void *)0, 0);
    compartilhado_uso = (struct uso_compartilhado *)memoria_comp;
    compartilhado_uso->vez = 0;
    while(running) {
        if (compartilhado_uso->vez) {
            printf("Valor Lido: %s", compartilhado_uso->texto);
            sleep(5);
            compartilhado_uso->vez = 0;
            if (strncmp(compartilhado_uso->texto, "fim", 3) == 0) {
                running = 0;
            }
        }
    }
    shmdt(memoria_comp);
    shmctl(shmid, IPC_RMID, 0);
    exit(EXIT_SUCCESS);
}
