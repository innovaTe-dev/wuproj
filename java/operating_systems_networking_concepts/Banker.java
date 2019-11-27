/**
 * Write a description of class Banker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import java.text.*;
import java.lang.Integer;

public class Banker
{
    public static void main( String[] args )
    throws FileNotFoundException
    {
        // decalre and initialize variables and arrays
        // prompt for data file name
        // read data into variables and arrays
        Scanner keyboard = new Scanner( System.in );
        String filename = "";
        System.out.printf("\u000cFile name: ");
        filename = keyboard.nextLine();
        File fh = new File( filename );
        Scanner inF = new Scanner( fh ); 
        String data = "";
        int i=0, j=0;
        long start = System.currentTimeMillis();

        data = inF.nextLine(); //read comment
        System.out.printf("%s%n",data);

        final int NUMBER_OF_RESOURCES = inF.nextInt();

        String[] numbers = new String[NUMBER_OF_RESOURCES];
        System.out.printf("%2d%n",NUMBER_OF_RESOURCES);
        
        data = inF.nextLine();
        data = inF.nextLine(); //read comment
        System.out.printf("%s%n",data);

        final int NUMBER_OF_THREADS = inF.nextInt();        
        System.out.printf("%2d%n",NUMBER_OF_THREADS);

        boolean[] finished = new boolean[NUMBER_OF_THREADS]; 
        for( i=0; i<NUMBER_OF_THREADS; i++)
            finished[i]= false;

        data = inF.nextLine();
        data = inF.nextLine(); //read comment
        System.out.printf("%s%n",data);
        /* the available amount of each resource */
        int[] available = new int[NUMBER_OF_RESOURCES];
        /*the maximum demand of each thread */
        int[][] maximum = new int[NUMBER_OF_THREADS][NUMBER_OF_RESOURCES];

        /* the amount currently allocated to each thread */
        int[][] allocation = new int [NUMBER_OF_THREADS][NUMBER_OF_RESOURCES];

        /* the total allocated of each resource type */
        int[] allocationSum = new int [NUMBER_OF_RESOURCES];

        /* the remaining need of each thread */
        int[][] need = new int [NUMBER_OF_THREADS][NUMBER_OF_RESOURCES];

        /*available resources to work with */
        int[] work = new int [NUMBER_OF_RESOURCES];
        // data = inF.nextLine(); //read comment
        data = inF.nextLine(); //read comment
        System.out.printf("%s%n",data);
        numbers = data.split(",");
        for(i=0; i<numbers.length; i++)
            available[i] = Integer.parseInt(numbers[i]);

        data = inF.nextLine(); //read comment  
        System.out.printf("%s%n",data);
        // read, split and convert data for maximum required by each thread
        for (i=0; i<NUMBER_OF_THREADS; i++)
        {
            data = inF.nextLine();
            for(j=0; j<NUMBER_OF_RESOURCES; j++)
            {

                numbers = data.split(",");
                System.out.printf("%2d ", Integer.parseInt(numbers[j]));
                maximum[i][j] = Integer.parseInt(numbers[j]);
            }

            System.out.printf("%n");
        }

        data = inF.nextLine(); //read comment  
        System.out.printf("%s%n",data);
        // read, split, convert and print data for starting allocations for each thread
        for (i=0; i<NUMBER_OF_THREADS; i++)
        {
            data = inF.nextLine(); 
            for( j=0; j<NUMBER_OF_RESOURCES; j++)
            {

                numbers = data.split(",");
                System.out.printf("%2d ", Integer.parseInt(numbers[j]));
                allocation[i][j] = Integer.parseInt(numbers[j]);
            }
            System.out.printf("%n");
        }
        
        //fill and print allocationSum array
        System.out.printf("//sum of allocations%n");
        for( i=0; i<NUMBER_OF_RESOURCES; i++)
        {
            for(j=0; j<NUMBER_OF_THREADS; j++)
            {
                allocationSum[i] += allocation[j][i];

            }                
            System.out.printf("%2d ", allocationSum[i]);
        }

        //fill and print work (currently avaiable resources)
        System.out.printf("%n//work array%n");
        for( i=0; i<NUMBER_OF_RESOURCES; i++)
        {

            work[i] = available[i] - allocationSum[i];

            System.out.printf("%2d ", work[i]);
        }
        System.out.printf("%n");

        //fill and print need array (additional resources each thread may request)
        System.out.printf("//need array%n");
        for( i=0; i<NUMBER_OF_THREADS; i++)
        {
            for( j=0; j<NUMBER_OF_RESOURCES; j++)
            {
                need[i][j] = maximum[i][j] - allocation[i][j];

                System.out.printf("%2d ", need[i][j]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");

        // begin checking for safe order to process threads
        for (int o = 0; o < finished.length; o++) {
        checkSafety(work, need, allocation, finished, NUMBER_OF_THREADS, NUMBER_OF_RESOURCES);
    }
        // end of checking
        if (complete(finished) == true) {System.out.println("finished!");}
        if (complete(finished) == false) {System.out.println("System is unsafe!");}
        inF.close();
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds\n");
    }

    // check if a thread can run safely - if so, release allocated resources and set finished[thread_number] to true
    public static void checkSafety( int[] work, int[][] need, int[][] allocation, boolean[] finished, int NUMBER_OF_THREADS, int NUMBER_OF_RESOURCES)
    {
        for (int g = 0; g < finished.length; g++) {
            if (!finished[g] && threadCanRun( work, need[g], NUMBER_OF_RESOURCES)) {
            release_resources(work, allocation[g]);
                    finished[g] = true;
                    System.out.printf("Thread %d can safely run%n", g);
                    print_work(work);
                }
          
            }
        for (int y = 0; y < finished.length; y++) {
             if (finished[y] && !threadCanRun( work, need[y], NUMBER_OF_RESOURCES)) {
                System.out.println("System is unsafe!");
            }
        }
    }
    
    // add allocated resources to work for a thread
    public static void release_resources(int[] work, int[] allocation)
    {
        for (int f = 0; f < work.length; f++) {
            work[f] = work[f] + allocation[f];
        }

    }

    // check if need <= work for a thread, if so, return true else return false
    public static boolean threadCanRun( int[] work, int[] need, int NUMBER_OF_RESOURCES )
    {
        for (int i = 0; i < work.length; i++) {
            if (need[i] > work[i]) {
                return false;
            }
        }
        return true;
    }
    
    // if all finished = true, then return true, else return false
    public static boolean complete( boolean[] finished )
    {
        for (int j = 0; j < finished.length; j++) {
            if (finished[j] == false) {
                return false;
            }
        }
        return true;
    }

    // print the work array
    public static void print_work( int[] work)
    {
        System.out.printf("New work is:");
        for (int k = 0; k < work.length; k++) {
            System.out.printf(" %d", work[k]);
    }
    System.out.println("");
}
}

