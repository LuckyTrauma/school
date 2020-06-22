#include <sys/socket.h>  
#include <netinet/in.h>  
#include <stdio.h>  
#include <string.h>  
#include <stdlib.h> 
#include <arpa/inet.h> 
#include <unistd.h> 
#include <pthread.h>
#include "funkcie.h"
float stena_1,stena_2;

void* thread1(void* premenne_1)
{
	float a, b;
	a = premenne_1.strana_1;
	b = premenne_1.strana_2;
	stena_1 = nasobenie(a, b);
}

void* thread2(void* premenne_2)
{
	float a, b;
	a = premenne_2.strana_3;
	b = premenne_2.strana_4;
	stena_2 = nasobenie(a, b);
}
typedef struct premenne_1
{
	float strana_1;
	float strana_2;
}premenne_1;
typedef struct premenne_2
{
	float strana_3;
	float strana_4;
}premenne_2;

int main(int argc, char* argv[])
{
	sleep(1);
	// vytvorenie socketu
	int sock_desc = socket(AF_INET, SOCK_STREAM, 0);
	if (sock_desc == -1)
	{
		printf("cannot create socket!\n");
		return 0;
	}

	// nastavenie socketu
	struct sockaddr_in client;
	memset(&client, 0, sizeof(client));
	client.sin_family = AF_INET;
	client.sin_addr.s_addr = inet_addr("127.0.0.1");
	client.sin_port = htons(58322);

	// pripojenie socketu
	if (connect(sock_desc, (struct sockaddr*) & client, sizeof(client)) != 0)
	{
		printf("cannot connect to server!\n");
		close(sock_desc);
	}

	int k;
	char* jednotky, * strana_2, * strana_4, * strana_3, * strana_1, recvbuff[EMSGSIZE];
	pthread_t tid1, tid2;

	sscanf(argv[1], "%s", premenne_1.strana_1);
	sscanf(argv[2], "%s", premenne_1.strana_2);
	sscanf(argv[3], "%s", premenne_2.strana_3);
	sscanf(argv[4], "%s", premenne_2.strana_4);
	sscanf(argv[5], "%s", jednotky);
	if (jednotky != 'm')
	{
		printf("Zle zadane jednotky/ziadne jednotky");
	}

	pthread_create(&tid1, NULL, thread1, &premenne_1);
	pthread_join(tid1, NULL);

	pthread_create(&tid2, NULL, thread2, &premenne_2);
	pthread_join(tid2, NULL);

	k = recv(sock_desc, recvbuff, EMSGSIZE, 0);

	while (recvbuff != "ready");
	{
		k = recv(sock_desc, recvbuff, EMSGSIZE, 0);
	}

	k = send(sock_desc,stena_1, sizeof(float), 0);  // posielanie dat
            if (k == -1)
            {
                printf("cannot write to server!\n");
            }

	k = send(sock_desc, stena_2, sizeof(float), 0);  // posielanie dat
			if (k == -1)
			{
				printf("cannot write to server!\n");
			}

 printf("\n%d\n",cislo1);

    close(sock_desc);  // zatvorenie socketu
    printf("client disconnected\n");

    return 0;  
} 
