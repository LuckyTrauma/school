#include <sys/socket.h>  
#include <netinet/in.h>  
#include <stdio.h>  
#include <string.h> 
#include <stdlib.h>  
#include <arpa/inet.h> 
#include <unistd.h> 

main()
{
	int k,cislo1,cislo2,cislo3,cislo4,cislo5,sum,cena,pocet ;
	sscanf(argv[1], "%d", &a);
    // vytvorenie socketu
    int sock_desc = socket(AF_INET, SOCK_STREAM, 0);
    if (sock_desc == -1)
    {
        printf("cannot create socket!\n");
        return 0;
    }

    // nastavenie socketu
	struct sockaddr_in server;  
    memset(&server, 0, sizeof(server));  
    server.sin_family = AF_INET;
    server.sin_addr.s_addr = INADDR_ANY;  
    server.sin_port = htons(58322);  

    if (bind(sock_desc, (struct sockaddr*)&server, sizeof(server)) != 0)
    {
        printf("cannot bind socket!\n");
        close(sock_desc);  
        return 0;
    }
    	
    if (listen(sock_desc, 5) != 0)
    {
        printf("cannot listen on socket!\n");
        close(sock_desc);  
        return 0;
    }

    struct sockaddr_in client;
    memset(&client, 0, sizeof(client));
    socklen_t len = sizeof(client);
    int client1_sock_desc = accept(sock_desc, (struct sockaddr*)&client, &len);
    if (client1_sock_desc == -1)
    {
        printf("cannot accept client1!\n");
        close(sock_desc);
        return 0;
    }

    struct sockaddr_in client2;
    memset(&client,0,sizeof(client2);
    socklen_t  c2_len= sizeof(client2);
	int client2_sock_desc = accept(sock_desc,(struct sockaddr*)&client2,&c2_len);
	if (client2_sock_desc == -1)
	{
		printf("cannot accept client2!\n");
		close(sock_desc);
		return 0;
	}

	struct sockaddr_in client3;
	memset(&client, 0, sizeof(client3);
	socklen_t  c3_len = sizeof(client3);
	int client3_sock_desc = accept(sock_desc, (struct sockaddr*) & client3, &c3_len);
	if (client3_sock_desc == -1)
	{
		printf("cannot accept client3!\n");
		close(sock_desc);
		return 0;
	}

	struct sockaddr_in client4;
	memset(&client, 0, sizeof(client4);
	socklen_t  c4_len = sizeof(client4);
	int client4_sock_desc = accept(sock_desc, (struct sockaddr*) & client4, &c4_len);
	if (client4_sock_desc == -1)
	{
		printf("cannot accept client4!\n");
		close(sock_desc);
		return 0;
	}

	k = recv(client1_sock_desc,&cislo1,sizeof(float),0);
		if (recv == -1) printf("\nClient 1 connection lost\n");
		if (recv==0) printf("\nClient 1 disconnected\n");
    k = recv(client1_sock_desc, &cislo2, sizeof(float), 0);
	    if (recv == -1) printf("\nClient 1 connection lost!\n");
        if (recv == 0)  printf("\nClient 1 disconnected.\n");
	
	k = send(client2_sock_desc,"ready", EMSGSIZE, 0);

	k=recv(client2_sock_desc,&cislo3,sizeof(float),0);
        if (recv == -1) printf("\nClient 2 connection lost!\n");
        if (recv == 0)  printf("\nClient 2 disconnected.\n");
	k=recv(client2_sock_desc,&cislo4,sizeof(float),0);
        if (recv == -1) printf("\nClient 2 connection lost!\n");
        if (recv == 0)  printf("\nClient 2 disconnected.\n");

	k = send(client3_sock_desc, "ready", EMSGSIZE, 0);

	k = recv(client3_sock_desc, &cislo5, sizeof(float), 0);
	if (recv == -1) printf("\nClient 3 connection lost!\n");
	if (recv == 0)  printf("\nClient 3 disconnected.\n");

semaforik;
	k=send(client4_sock_desc,&cena,sizeof(float),0);
semaforik;
	k=send(client4_sock_desc,&sum,sizeof(float),0);
semaforik;
	k=send(client4_sock_desc,&pocet,sizeof(float),0);
semaforik;

	close(client1_sock_desc);
	close(client2_sock_desc);	
    close(client3_sock_desc);
    close(client4_sock_desc);
    close(sock_desc);
    printf("server disconnected\n");
    return 0;
} 
