#include "pch.h"
#include "stdio.h"
#include "windows.h"
#include "tchar.h"

int _tmain(int argc, _TCHAR *argv[]) {
	STARTUPINFO si;
	PROCESS_INFORMATION pi;

	//allocate memory

	ZeroMemory(&si, sizeof(si));
	si.cb = sizeof(si);
	ZeroMemory(&pi, sizeof(pi));

	//create child process

	if (!CreateProcess(TEXT("C:\\WINDOWS\\system32\\mspaint.exe"), //run paint program
		NULL, //use cli
		NULL, //don't inherit process handle
		NULL, //don't inherit thread handle
		FALSE, //disable handle inheritance
		0, //no inheritance flags
		NULL, //use parents environment block
		NULL, //use parent's directory
		&si, //pointer to si
		&pi)) //pointer to pi

	{
		fprintf(stderr, "Create Process Failed");
		return -1;
	}
	//wait for child
	WaitForSingleObject(pi.hProcess, INFINITE);
	printf("Child Complete");

	//close handles
	CloseHandle(pi.hProcess);
	CloseHandle(pi.hThread);


	return 0;
}