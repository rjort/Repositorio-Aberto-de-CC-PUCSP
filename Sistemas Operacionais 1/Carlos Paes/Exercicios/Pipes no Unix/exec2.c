#include <stdio.h>
#include <unistd.h>

int main(void)
{
	 int n, fdping[2],fdpong[2];
	 pid_t pid;
	 char msg[20];

        
        if (pipe(fdping) < 0)
	 	printf("erro no pipe ping!\n");
        if (pipe(fdpong) < 0)
	 	printf("erro no pipe pong!\n");

	if ( (pid = fork()) < 0)
		printf("erro no fork\n");
	else if (pid > 0) {/* pai */
		close(fdping[0]); /* fecha extremidade não usada*/
                printf("Processo Pai: enviando ping para o Filho!\n");
		write(fdping[1], "ping\n", 5);            
                close(fdpong[1]);
                n = read(fdpong[0], msg, 5);
                printf("[Processo Pai] recebeu a mensagem:");
                fprintf(stdout,msg,n);
	} else {/* filho */
		close(fdping[1]); /* fecha extremidade não usada*/
		n = read(fdping[0], msg, 5);
                printf("[Processo Filho] recebeu a mensagem:");
                fprintf(stdout,msg,n);               
		close(fdpong[0]);
                printf("\nProcesso Filho: enviando pong para o Pai!\n");
                write(fdpong[1],"pong\n",5);
	 }
	 exit(0);
}
