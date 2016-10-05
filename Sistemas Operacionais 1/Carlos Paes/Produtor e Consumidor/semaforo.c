/* Opera��es com sem�foros */
/* Sistemas Operacionais I & II */
/* Prof. Carlos Paes */

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>

#include "semaforo.h"


int set_semaforo(int valor,int sem_id)
{
    union semun sem_union;

    sem_union.val = valor;
    if (semctl(sem_id, 0, SETVAL, sem_union) == -1) return(0);
    return(1);
}

void del_semaforo(int sem_id)
{
    union semun sem_union;
    
    if (semctl(sem_id, 0, IPC_RMID, sem_union) == -1)
        fprintf(stderr, "Falha na remocao do semaforo\n");
}

int P(int sem_id)
{
    struct sembuf sem_b;
    
    sem_b.sem_num = 0;
    sem_b.sem_op = -1; /* P() */
    sem_b.sem_flg = 0;
    if (semop(sem_id, &sem_b, 1) == -1) {
        fprintf(stderr, "Falha na operacao P()\n");
        return(0);
    }
    return(1);
}

int V(int sem_id)
{
    struct sembuf sem_b;
    
    sem_b.sem_num = 0;
    sem_b.sem_op = 1; /* V() */
    sem_b.sem_flg = 0;
    if (semop(sem_id, &sem_b, 1) == -1) {
        fprintf(stderr, "Falha na operacao V()\n");
        return(0);
    }
    return(1);
}


