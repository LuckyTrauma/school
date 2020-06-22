#include <sys/socket.h>  
#include <netinet/in.h>  
#include <stdio.h>  
#include <string.h>  
#include <stdlib.h> 
#include <arpa/inet.h> 
#include <unistd.h> 

int main(int argc, char *argv[]) 
{  
	sleep(2);
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
    if (connect(sock_desc, (struct sockaddr*)&client, sizeof(client)) != 0)
    {
        printf("cannot connect to server!\n");
        close(sock_desc);
    }

 	int k;
	float podlaha, strana_1, strana_2, ;
	char *jednotky,*recvbuff;
	sscanf(argv[1], "%f", strana_1);
	sscanf(argv[2], "%f", strana_2);
	sscanf(argv[3], "%s", jednotky);
	if (jednotky != 'm')
	{
		printf("Zle zadane jednotky/ziadne jednotky");
	}

	podlaha = nasobenie(strana_1, strana_2);

	k = recv(sock_desc, recvbuff, EMSGSIZE, 0);

	while (recvbuff != "ready");
	{
		k = recv(sock_desc, recvbuff, EMSGSIZE, 0);
	}

        k = send(sock_desc,podlaha, sizeof(float), 0);  // posielanie dat
            if (k == -1)
            {
                printf("cannot write to server!\n");
            }
	
 

    close(sock_desc);  // zatvorenie socketu
    printf("client disconnected\n");

    return 0;  
} 
