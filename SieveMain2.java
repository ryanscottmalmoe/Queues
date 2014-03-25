//Ryan Malmoe | Prof: Tom Capaul | CSCD300 12:00
// This program computes all the prime numbers up to a given integer n.  It
// uses the classic "Sieve of Eratosthenes" to do so.

//This is also my menu driven main so you can test all of my exceptions etc.

import java.util.*;

public class SieveMain2 {
   public static void main(String[] args) {
      System.out.println("This program computes all prime numbers up to a");
      System.out.println("maximum using the Sieve of Eratosthenes.");
      System.out.println("This is a menu driven SieveMain.");
      System.out.println();
      Scanner console = new Scanner(System.in);
      Scanner kb = new Scanner(System.in);
      Sieve s = new Sieve();
      Sieve2 s2 = new Sieve2();
      System.out.println("1 : if you would like to test LinkedList.");
      System.out.println("2 : if you would like to test ArrayDeque.");
      int choice = kb.nextInt();
      kb.nextLine();
      int x = 0;
      int max = 0;
      while(choice != (int)choice && choice > 2)
      {
         System.out.println("Please enter an integer greater than 2.");
         choice = kb.nextInt();
      }
   
      do
      {
         System.out.println("Please select from the following choices.");
         System.out.println("1 : Report results without computing primes.");
         System.out.println("2 : Compute primes without printing any results.");
         System.out.println("3 : Compute and report results.");
         System.out.println("0 : Quit program.");
         x = kb.nextInt();
         while(x != (int)x && x > 2)
         {
            System.out.println("Please enter an integer greater than 2.");
            x = kb.nextInt();
         }
         if(x == 1)
         {
            if(choice == 1)
            {
               s.reportResults();
            }
            else
            {
               s2.reportResults();
            }
         }
         
         else if(x == 2)
         {
            if(choice == 1)
            {
               s.computeTo(max);
            }
            else
            {
               s2.computeTo(max);
            }
         }
         else if(x == 3)
         {
            for(;;) {
               System.out.print("Maximum n to compute (0 to quit)? ");
               max = console.nextInt();
               if(max == 0)
                  break;
               System.out.println();
               if(choice == 1)
               {
                  s.computeTo(max);
                  s.reportResults();
                  if(max < 2)
                  {
                     break;
                  }
                  int percent = s.getCount() * 100 / s.getMax();
                  System.out.println("% of primes = " + percent);
                  System.out.println();
               }
               else
               {
                  s2.computeTo(max);
                  s2.reportResults();
                  int percent = s2.getCount() * 100 / s2.getMax();
                  System.out.println("% of primes = " + percent);
                  System.out.println();
               }
            }
         }
         else
         {
            break;
         }
      }while(x != 0);
   }
}