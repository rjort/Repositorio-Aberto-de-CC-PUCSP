#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>


int main(void)
{
	 int n, fd[2];
	 pid_t pid;
	 char nome[60];
	 char idade[10];
	 char line[255];

	 if (pipe(fd) < 0)
	 	printf("erro no pipe!\n");

	 if ( (pid = fork()) < 0)
		printf("erro no fork\n");
	 else if (pid > 0) {/* pai */
		close(fd[0]); /* fecha extremidade não usada*/

		printf("Entre com o nome:");
		scanf("%s",nome);
		printf("\nEntre com a idade:");
		scanf("%s",idade);


		write(fd[1],nome, strlen(nome)+1);
		sleep(3);
		write(fd[1],idade, strlen(idade)+1);
		printf("\nProcesso Pai enviou os dados!\n");

	  } else {/* filho */

		close(fd[1]); /* fecha extremidade não usada*/

		n = read(fd[0], line, 255);
		printf("Filho recebeu: %s\n",line);
		n = read(fd[0], line, 255);
		printf("Filho recebeu: %s\n",line);

	 }
	 exit(0);
}
