package com.fujitsu.pi;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
  final static int QUIT = 0;
  final static int FIRST_BEST = 1;
  final static int PICK_OWN_ITERATIONS = 2;

  public static void main(String[]args)
  {
    Scanner inputReader = new Scanner(System.in);
    int user_input = -1;
    int iterations = -1;
    do{
       System.out.println("Enter " + FIRST_BEST + " to stop at first value that starts with 3.14.");
       System.out.println("Enter " + PICK_OWN_ITERATIONS + " to pick your own number of iterations.");
       System.out.println("My input (Ctrl-C to quit) : ");
       inputUntilInteger(inputReader);
       user_input = inputReader.nextInt();

    }while(user_input<1 || user_input >2);

    if(user_input == PICK_OWN_ITERATIONS){
       do{
         System.out.print("Enter desired number of iterations (positive non zero ODD integer; greater than 1 and less than 2147483647 ): ");
         inputUntilInteger(inputReader);
         iterations = inputReader.nextInt();
       }while((iterations <= 1 || iterations >= 2147483647) || (iterations%2 == 0 ));
    }
    System.out.println("Given your input, calculated approx. numeric Value of PI : " + getNumericValueOfPi(user_input,iterations));

  }

	public static double getNumericValueOfPi(int user_input,int iterations) {
    double term = 0;
    double pi = 0;
    double y = 1;
    int x = 1;
    long start = System.nanoTime();
    while( (user_input == FIRST_BEST && (pi >= 3.15 || pi <3.14) )
           || (iterations > 0 && (x+1)/2 <= iterations ) ) {
      term = term + (y/x);
      y = -y;
      x += 2;
      pi = 4 * term;
    }
    System.out.println("Total "+ x/2 +" iterations.\nTime elapsed : " + ( System.nanoTime() - start ) +" nanoseconds");
    return pi;
  }

  public static void inputUntilInteger(Scanner inputReader){
    while (!inputReader.hasNextInt()) {
      String input = inputReader.next();
      System.out.println("Invalid input, try again (Ctrl-C  to quit): ");
    }
  }

}
