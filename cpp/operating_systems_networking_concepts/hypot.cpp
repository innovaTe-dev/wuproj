// WinThreads.cpp : Defines the entry point for the console application.
//Computer the hypotenuse of a right triangle using two threads
//Thread 1 will sum the squares and thread 2 will compute the square root.
//#include "stdafx.h"
#include "windows.h"
#include "stdio.h"
#include "math.h"

double Sum, Side1, Side2; // Shared data area

//functuion for thread1
DWORD WINAPI SumOfSquares(LPVOID)
{
	
	Sum = Side1 * Side1 + Side2 * Side2; //compute sum of the squares of the two sides and store in shared area
	return 0;
}


//functuion for thread2
DWORD WINAPI sqRt(LPVOID)
{
	
	Sum = pow(Sum, 0.5);  //compute the square root of the value of Sum
	return 0;
}


int main(int argc, char *argv[])
{
	DWORD ThreadID1, ThreadID2;
	HANDLE ThreadHandle1, ThreadHandle2;
	
	// get paramaters from commandline and convert to doubles
	Side1 = strtod(argv[1], NULL); 
	Side2 = strtod(argv[2], NULL);


	// create the thread1
	ThreadHandle1 = CreateThread(
		NULL, //Default security attributes
		10, // Default stack size
		SumOfSquares, // Thread function
		NULL, //Parameter to thread function
		0, //default flags
		&ThreadID1); // Returns thread identifier

	
	// create the thread2
	ThreadHandle2 = CreateThread(
		NULL, //Default security attributes
		10, // Default stack size
		sqRt, // Thread function
		NULL, //Parameter to thread function
		0, //default flags
		&ThreadID2); // Returns thread identifier

	//now wait for threads to finish
	WaitForSingleObject(ThreadHandle1, INFINITE);
	WaitForSingleObject(ThreadHandle2, INFINITE);

	// close the thread handle
	CloseHandle(ThreadHandle1);
	CloseHandle(ThreadHandle2);

	printf("The hypotenuse of a right triangle with sides of length %.2f and %.2f is %.2f\n", Side1, Side2, Sum);

}