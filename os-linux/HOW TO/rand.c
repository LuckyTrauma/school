#include <stdlib.h>
#include <stdio.h>
#include <time.h>
int main(int argc,char *argv[])
{
	srand(time(NULL));
	int r,hhranica,dhranica,cislo,vstup=0,pocet=0;

 sscanf(argv[1],"%d",&dhranica);
 sscanf(argv[2],"%d",&hhranica);
 cislo = rand()%((hhranica + 1  - dhranica)+ dhranica);
 printf("Hadajte cislom medzi %d a %d \n",hhranica,dhranica);
while(vstup!=cislo)
	{
 pocet++;
 scanf("%d",&vstup);
  if(vstup < cislo)
 printf("Hladane cislo je vacsie\n");
  if(vstup > cislo)
 printf("Hladane cislo je mensie\n");
   }


printf("win,na %d.pokus\n",pocet);

}
