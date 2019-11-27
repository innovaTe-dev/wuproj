#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main()
{
    pid_t pid;

    printf("Before fork() \n");
    pid = fork();
    printf("After fork() \n");
    if (pid<0) {
        fprintf(stderr, "Fork Failed\n");
        return 1;
    }

    else if (pid==0) {
        printf("I'm the child\n");
        printf("My PID is: %d\n", getpid());
        printf("My parent PID is: %d\n", getppid());
        execlp("/bin/ps", "ps", NULL);
    }

    else {
        wait(NULL);
        printf("Child Complete\n");
    }

    printf("Parent exiting\n");
    return 0;
    }
}