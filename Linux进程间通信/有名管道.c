#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
int main(){
	int pfd[2];
	int pid;
	int status=0;

	char w_cont[]={"Hello child, I'm parent!"};
	char r_cont[255]={0};
	int write_len=strlen(w_cont);

	if(pipe(pfd)<0){
		exit(1);
	}else{
		if((pid=fork())<0){
			
		}else if(pid>0){
			close(pfd[0]);
			write(pfd[1],w_cont,write_len);
			close(pfd[1]);
			wait(&status);
		}else{
			sleep(2);
			close(pfd[1]);
			read(pfd[0],r_cont,write_len);
			printf("child process read: %s\n",r_cont);
		}
	}
	return 0;
} 
