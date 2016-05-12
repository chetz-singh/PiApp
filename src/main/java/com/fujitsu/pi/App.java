package com.fujitsu.pi;

public class App {

  public static void main(String[]args)
  {
    System.out.println("Numeric Value of PI :" + getNumericValueOfPi());
  }

	public static double getNumericValueOfPi() {
    double term = 0;
    double pi = 0;
    double y = 1;
    int x=1;
    long start = System.nanoTime();
    while( pi >= 3.15 || pi <3.14) {
      term = term + (y/x);
      y = -y;
      x += 2;
      pi = 4 * term;
    }
    return pi;
  }

}
