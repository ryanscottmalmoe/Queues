//Ryan Malmoe | Prof: Tom Capaul | CSCD300 12:00

//Used some advice from Stackoverflow.com to help me to cast objects to ints. 

import java.lang.Math.*;
import java.util.*;
import java.lang.*;

//LinkedList is slower than ArrayDeque by .044543 seconds on primes up to 10000.
//This class has a slower computeTo.


public class Sieve
{
   long sTimeSieve; //Declaration of start time.
   long eTimeSieve; //Declaration of end time.
  
   int tCalls = 0; //Total Calls to computeTo
   int nOP = 0; //Number of Primes
   int lastN = 0; //Last value of n called to computeTo
   String resultP = ""; //Result primes.
  
   int getMax() //Returns total number of calls to computeTo(or returns 0 if no calls have been made)
   {
      try
      {
         if(this.tCalls == 0);
      }
      catch(IllegalStateException e)
      {
         System.out.println("No call to computeTo has been made yet");
         return 0;
      }
      return this.lastN;
   }
  
   int getCount()//Returns the number of primes in the last call to computeTo
   {
      try
      {
         if(this.tCalls == 0);
      }
      catch(IllegalStateException e)
      {
         System.out.println("No call to computeTo has been made yet");
         return 0;
      }
      return this.nOP;
   }
  
   void reportResults()//Prints results string with System.out.
   {
      try
      {
         if(this.tCalls == 0);
      }
      catch(IllegalStateException e)
      {
         System.out.println("No call to computeTo has been made yet");
         return;
      }
      System.out.println(this.resultP);
   }
  
  
  
   void computeTo(int n) //Computes number of primes from 2 to the given n number.
   {
      sTimeSieve = System.nanoTime(); //Start time 
      try
      {
         if(n < 2)
         {
            throw new IllegalArgumentException("n is less than 2");
         }
      }
      catch(IllegalArgumentException e)
      {
         System.out.println("n is less than 2");
         return;
      }
   
      resultP = "";
      tCalls++;
      this.lastN = n;
      Queue<Integer> primes = new LinkedList<Integer>();
      Queue<Integer> allNums = new LinkedList<Integer>();
      for(int i = 2; i < n + 1; i++)
      {
         allNums.add(i);
      }
      int counter = n - 2;
      int p = 0;
      Object obj = null;
      Object obj2 = null;
      do
      {
         try
         {
            obj = (Object)allNums.remove();
         }
         catch(Exception e)
         {
            System.out.println("Error dequeue your queue.");
            return;
         }
         p = Integer.valueOf(obj.toString());
         resultP += p + " ";
         primes.add(p);
         for(int i = 0; i < counter; i++)
         {
            try
            {
               obj2 = (Object)allNums.peek();
            }
            catch(Exception e)
            {
               System.out.println("Error peeking your queue.");
            }
            if(((Integer.valueOf(obj2.toString())) % p) != 0)
            {
               try
               {
                  Integer stillPrime = allNums.remove();
                  allNums.add(stillPrime);
               }
               catch(Exception e)
               {
                  System.out.println("Error dequeue/enqueue your queue.");
               }
            }
            else
            {
               try
               {
                  allNums.remove();
               }
               catch(Exception e)
               {
                  System.out.println("Error dequeue your queue.");
               }
            }
         }
         counter = allNums.size() - 1;
      }while(p < Math.sqrt(n));
      while(!allNums.isEmpty())
      {
         obj = (Object)allNums.remove();
         p = Integer.valueOf(obj.toString());
         resultP += p + " ";
         primes.add(p);
      }
      nOP = 0;
      for(int c = 0; c < primes.size(); c++)
      {
         this.nOP++;
      }
      eTimeSieve = System.nanoTime() - sTimeSieve;
      double seconds = (double)eTimeSieve / 1000000000.0;
      // System.out.println();
   //       System.out.print("Seconds: " + seconds);
   //       System.out.println();
   }
}