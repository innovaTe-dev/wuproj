// poly.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>
// WinThreads.cpp : Defines the entry point for the console application.
//Computer the hypotenuse of a right triangle using two threads
//Thread 1 will sum the squares and thread 2 will compute the square root.
//#include "stdafx.h"
#include "windows.h"
#include "stdio.h"
#include "math.h"

double x, y; // Shared data area

//functuion for thread1
DWORD WINAPI partOne(LPVOID)
{

	y = x + (pow(x, 2) * 2); //compute part of the polynomial
	return 0;
}


//functuion for thread2
DWORD WINAPI partTwo(LPVOID)
{

	y = y + (pow(x, 4) * 3) + pow(x, 6);  //compute part of the polynomial
	return 0;
}


int main(int argc, char* argv[])
{
	DWORD ThreadID1, ThreadID2;
	HANDLE ThreadHandle1, ThreadHandle2;

	// get paramaters from commandline and convert to doubles
	x = strtod(argv[1], NULL);


	// create the thread1
	ThreadHandle1 = CreateThread(
		NULL, //Default security attributes
		10, // Default stack size
		partOne, // Thread function
		NULL, //Parameter to thread function
		0, //default flags
		&ThreadID1); // Returns thread identifier


	// create the thread2
	ThreadHandle2 = CreateThread(
		NULL, //Default security attributes
		10, // Default stack size
		partTwo, // Thread function
		NULL, //Parameter to thread function
		0, //default flags
		&ThreadID2); // Returns thread identifier

	//now wait for threads to finish
	WaitForSingleObject(ThreadHandle1, INFINITE);
	WaitForSingleObject(ThreadHandle2, INFINITE);

	// close the thread handle
	CloseHandle(ThreadHandle1);
	CloseHandle(ThreadHandle2);

	printf("y= x + 2x^2 + 3x^4 + x^6 for x = %.2f is %.2f\n", x, y);

}
