// openmp.cpp : Defines the entry point for the console application.
//


#include <omp.h>
#include <stdio.h>
//#include <unistd.h>
#include <math.h>

int main (int argc, char *argv[] )
{
   int a = 0;
   int i = 0;
   printf("Sequential part\n");

   #pragma omp parallel for
   for (i = 0; i< 10; i++)
   {
 
     a = i *i *i;
     a = pow((double)a,3.0);
     printf("I am a parallel region 1. a= %d\n", a);

   }


   #pragma omp parallel for
   for (i = 0; i< 10; i++)
   {
 
     a = i *i *i;
     a = pow((double)a,3.0);
     printf("I am parallel region 2. a= %d\n", a);

   }

   //more sequential
   printf("More sequential stuff\n");
   return 0;

}

