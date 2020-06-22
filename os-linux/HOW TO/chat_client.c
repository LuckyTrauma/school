#include <sys/socket.h>  
#include <netinet/in.h>  
#include <stdio.h>  
#include <string.h>  
#include <stdlib.h> 
#include <arpa/inet.h> 
#include <unistd.h> 

int main(int argc, char *argv[]) 
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
    if (connect(sock_desc, (struct sockaddr*)&client, sizeof(client)) != 0)
    {
        printf("cannot connect to server!\n");
        close(sock_desc);
    }

    int Second_sock_desc = socket(AF_INET, SOCK_STREAM, 0);

    if (Second_sock_desc == -1)
    {
        printf("cannot create socket!\n");
        return 0;
    }

 	int k, hrana;

    sscanf(argv[1],"%d",&hrana);
          k = send(sock_desc,&hrana, sizeof(int), 0);  // posielanie dat
            if (k == -1)
            {
                printf("cannot write to server!\n");
            }
sleep(3);

	k = recv(sock_desc,&hrana,sizeof(int), 0);
        if (recv == -1)
        {
            printf("\ncannot read from client!\n");
        }

        if (recv == 0)
        {
            printf("\nclient disconnected.\n");
        }

 printf("\n%d\n",hrana);

    close(sock_desc);  // zatvorenie socketu
    printf("client disconnected\n");

    return 0;  
} 
