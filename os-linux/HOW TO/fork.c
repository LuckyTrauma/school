#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv)
{
   printf("--beginning of program\n");

    pid_t pid_2,pid_3,pid_4,pid_5,pid_6,pid = fork();


    if (pid == 0)
    {
       pid_3=fork();
    }
    else if (pid > 0)
    {
      pid_2=fork();
    }
    if (pid_2 == 0)
      {
        pid_4=fork();

      }
    if(pid_2 > 0)
	{

	}
    if(pid_3 == 0 )
    {

    }
    if(pid_3 > 0)
	{
	 pid_5=fork();
	}
    if(pid_4 > 0)
	{
	 pid_6=fork();
	}
 
    else
    {
        // fork failed
        printf("fork() failed!\n");
        return 1;
    }

    printf("\n--end of program--\n");

    return 0;
}
