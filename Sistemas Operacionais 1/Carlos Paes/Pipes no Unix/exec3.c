#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main()  {
	int p1fd[2];
        int p2fd[2];
        int pid1,pid2;

	pipe(p1fd);
        
        pid1 = fork();
        if (pid1 == 0) {
              pipe(p2fd);
              pid2 = fork();
               if (pid2 == 0) {
                     close(p1fd[0]);
                     close(p1fd[1]);
                     close(p2fd[1]);
		     dup2(p2fd[0], 0);
		     close(p2fd[0]);
                     execlp("wc", "wc","-l", (char *) 0);
                } else {
                     close(p1fd[1]);
	             dup2(p1fd[0], 0);
	             close(p1fd[0]);

                     close(p2fd[0]);
		     dup2(p2fd[1], 1);
		     close(p2fd[1]);
              	     execlp("sed", "sed","1d", (char *) 0);
                  }
	 } else {
		close(p1fd[0]);
		dup2(p1fd[1], 1);
		close(p1fd[1]);
		execlp("ps", "ps", (char *) 0);
	}
	exit(0);
}
