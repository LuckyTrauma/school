#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
int obsah;

void * thread1(void *p)
{
	int a;
	a = *((int*)p);

	obsah = a*a;
}


void * thread2()
		{
	 printf("Obsah je : %d \n",obsah);
}


int main(int argc,char *argv[])
{
        pthread_t tid1,tid2;
	int a;
	sscanf(argv[1],"%d",&a);
	void *p=&a;
	//int x = atoi(argv[1]);
        pthread_create(&tid1,NULL,thread1,p);
        pthread_join(tid1,NULL);
        pthread_create(&tid2,NULL,thread2,NULL);
        pthread_join(tid2,NULL);
        return 0;
}
