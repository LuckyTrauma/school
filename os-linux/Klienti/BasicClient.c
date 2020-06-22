#include <sys/socket.h>  
#include <netinet/in.h>  
#include <stdio.h>  
#include <string.h>  
#include <stdlib.h> 
#include <arpa/inet.h> 
#include <unistd.h> 
#include "funkcie.h"
#define MSGSIZE 5

int main(int argc, char* argv[])
{

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


	int k,p[2],
	float ,strana_1,strana_2, strana_3, strana_4;
	char* jednotky;
	char buff[MSGSIZE];
	pid_t pid;

	sscanf(argv[1], "%d", &strana_1);
	sscanf(argv[2], "%d", &strana_2);
	sscanf(argv[3], "%d", &strana_3);
	sscanf(argv[4], "%d", &strana_4);
	sscanf(argv[5], "%d", jednotky);
	if (jednotky != 'm')
	{
		printf("Zle zadane jednotky/ziadne jednotky");
	}
	if (pipe(p) < 0)
		exit(1);

	pid = fork();
	if (pid < 0)
	{
		printf("Child creation failed");
	}	
	if (pid == 0)
	{
		strana1 = nasobenie(strana_1, strana_2);
	
		k = send(sock_desc, strana1, sizeof(float), 0);  // posielanie dat
		if (k == -1)
		{
			printf("cannot write to server!\n");
		}

		write(p[1], "done", MSGSIZE);

	}
	if (pid > 0)
	{
		read(p[0], buff, MSGSIZE);
		while(buff !="done")
		{
			sleep(1);
		}
		strana3 = nasobenie(strana_3, strana_4);
	
	k = send(sock_desc, strana3, sizeof(float), 0);  // posielanie dat
		if (k == -1)
		{
			printf("cannot write to server!\n");
		}

	}
	

    close(sock_desc);  // zatvorenie socketu
    printf("client disconnected\n");

    return 0;  
} 
