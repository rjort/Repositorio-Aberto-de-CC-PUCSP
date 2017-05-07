#include <signal.h>
#include <stdio.h>

static void sig_int();
static void sig_alrm();

int main(void)
{
	if (signal(SIGINT, sig_int) == SIG_ERR)
		printf("Nao pode capturar SIGUSR1\n");
	if (signal(SIGALRM, sig_alrm) == SIG_ERR)
		printf("Nao pode capturar SIGUSR2\n");
    alarm(5);
	for ( ; ; );
}

static void sig_int()
{
    printf("Sinal crtl+C recebido pelo processo!\n");
	return;
}

static void sig_alrm()
{
    printf("Sinal de Alarme recebido pelo processo!\n");
	return;
}
