#include <signal.h>
#include <stdio.h>

static void sig_usr(int); /*função que gerencia os dois sinais */

int main(void)
{
	if (signal(SIGUSR1, sig_usr) == SIG_ERR)
		printf("Nao pode capturar SIGUSR1\n");
	for ( ; ; );
}

static void sig_usr(int signo) /* argumento e' numero do sinal */
{
	int pid,ppid;

	pid = getpid();
	ppid = getppid();
	printf("PID do processo = %d e PPID = %d\n",pid,ppid);

	return;
}
