#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>

#include "semaforo.h"


#define BUFFER_SIZE 10

struct item {
  int valor;
  char texto[100];
 
};

struct buffer_circular {
  struct item buffer[BUFFER_SIZE];
};

int main(int argc, char *argv[])
{
    void *shared_memory = (void *)0;
    struct buffer_circular *shared_buffer;
    int shmid;
    int semid_mutex;
    int semid_full;
    int semid_empty;
    int out = 1;
    struct item item_consumido;

    srand((unsigned int)getpid());    

    shmid = shmget((key_t)1234, sizeof(struct buffer_circular), 0666 | IPC_CREAT);

    if (shmid == -1) {
        fprintf(stderr, "shmget failed\n");
        exit(EXIT_FAILURE);
    }

    semid_mutex = semget((key_t)4321, 1, 0666 | IPC_CREAT);
    semid_full = semget((key_t)4322, 1, 0666 | IPC_CREAT);
    semid_empty = semget((key_t)4323, 1, 0666 | IPC_CREAT);
 


    shared_memory = shmat(shmid, (void *)0, 0);
    if (shared_memory == (void *)-1) {
        fprintf(stderr, "shmat failed\n");
        exit(EXIT_FAILURE);
    }

    if (argc > 1) {
        if (!set_semaforo(1,semid_mutex)) {
            fprintf(stderr, "Falha na inicializacao do semaforo mutex !!\n");
            exit(EXIT_FAILURE);
        }
       if (!set_semaforo(0,semid_full)) {
            fprintf(stderr, "Falha na inicializacao do semaforo full !!\n");
            exit(EXIT_FAILURE);
        }
        if (!set_semaforo(BUFFER_SIZE,semid_empty)) {
            fprintf(stderr, "Falha na inicializacao do semaforo empty !!\n");
            exit(EXIT_FAILURE);
        }
        sleep(2);
    }

    printf("Memoria vinculada no endereco: %X\n", (int)shared_memory);

    shared_buffer = (struct buffer_circular *)shared_memory;
    while(1) {
      P(semid_full);
      P(semid_mutex);
      item_consumido.valor = shared_buffer->buffer[out-1].valor;      
      strcpy(item_consumido.texto,shared_buffer->buffer[out-1].texto);
      printf("Consumindo da posicao  %d\n",out-1);
      printf("Item valor: %d      Item texto: %s\n",item_consumido.valor,item_consumido.texto);
      V(semid_mutex);
      V(semid_empty);
      out = (out%BUFFER_SIZE)+1;
      sleep(item_consumido.valor%3);
    }

    if (shmdt(shared_memory) == -1) {
        fprintf(stderr, "shmdt failed\n");
        exit(EXIT_FAILURE);
    }

    if (argc > 1) {
       if (shmctl(shmid, IPC_RMID, 0) == -1) {
           fprintf(stderr, "shmctl(IPC_RMID) failed\n");
           exit(EXIT_FAILURE);
       }
       del_semaforo(semid_mutex);
       del_semaforo(semid_full);
       del_semaforo(semid_empty);
    }
    
    exit(EXIT_SUCCESS);
}

        

