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
    char buffer[BUFSIZ];
    int shmid;

    shmid = shmget((key_t)1234, MEM_SZ, 0666 | IPC_CREAT);

    memoria_comp = shmat(shmid, (void *)0, 0);
    compartilhado_uso = (struct uso_compartilhado *)memoria_comp;
    while(running) {
        while(compartilhado_uso->vez == 1) {
            sleep(1);            
            printf("waiting for client...\n");
        }
        printf("Entre com o Texto: ");
        fgets(buffer, BUFSIZ, stdin);
        
        strcpy(compartilhado_uso->texto, buffer);
        compartilhado_uso->vez = 1;

        if (strncmp(buffer, "fim", 3) == 0) {
                running = 0;
        }
    }
    shmdt(memoria_comp);
    exit(EXIT_SUCCESS);
}
