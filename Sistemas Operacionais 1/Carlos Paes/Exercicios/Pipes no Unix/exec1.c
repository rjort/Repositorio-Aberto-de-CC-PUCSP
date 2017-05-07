#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define MAXLINE 4096

int main(void)
{
	 int n, fd[2];
	 pid_t pid;
	 char line[MAXLINE];

	 if (pipe(fd) < 0)
	 	printf("erro no pipe!\n");

	 if ( (pid = fork()) < 0)
		printf("erro no fork\n");
	 else if (pid > 0) {/* pai */
		close(fd[0]); /* fecha extremidade não usada*/
		write(fd[1], "Sou filho\n", 10);
	  } else {/* filho */
		close(fd[1]); /* fecha extremidade não usada*/
		n = read(fd[0], line, MAXLINE);
		printf("%s\n",line);
	 }
	 exit(0);
}
