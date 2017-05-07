#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define MAXLINE 4096

int main(int argc, char *argv[])
{
	 int n, fd[2];
	 pid_t pid;
	 char line[MAXLINE];
	 char lineout[MAXLINE];
	 int i;

	 if (pipe(fd) < 0)
	 	printf("erro no pipe!\n");

	 if ( (pid = fork()) < 0)
		printf("erro no fork\n");
	 else if (pid > 0) {/* pai */
		close(fd[0]); /* fecha extremidade não usada*/
		for(i=0;i<argc;i++) {
		    strcpy(lineout ,argv[i]);
		    strcat(lineout,"\n");
		    printf("Pai Enviando: %s\n",lineout);
		    write(fd[1],lineout,strlen(lineout)+1);
		    sleep(3);
		}
		//write(fd[1], "end\n",4);
	  } else {/* filho */
		    close(fd[1]); /* fecha extremidade não usada*/
		    for(i=0;i<argc;i++) {
                n = read(fd[0], line, MAXLINE);
                printf("Filho Recebendo %s e com %d caracteres\n",line,n);
		    }

		}
	 exit(0);
}
