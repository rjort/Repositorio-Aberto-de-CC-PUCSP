#include <signal.h>
#include <stdio.h>

static void sig_usr(); /*função que gerencia os dois sinais */

int main(void)
{
        char ch;

	if (signal(SIGUSR1, sig_usr) == SIG_ERR)
		printf("Nao pode capturar SIGUSR1\n");
	printf("Rotina de tratamento do SIGUSR1 instalada e pid = %d\n",getpid());
        printf("Aperte alguma tecla para finalizar!\n");
        ch=getchar();
}
static void sig_usr() {
	printf("recebido o sinal SIGUSR1!\n");
	return;
}

