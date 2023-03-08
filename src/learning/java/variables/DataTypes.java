package learning.java.variables;

public class DataTypes {

  public static void main(String[] args) {
    double x = 5;
    double y = 2;

    System.out.println(x);
    System.out.println(y);
    double result = x/y;
    System.out.println("the result is " + (result +10));
    System.out.println(result + 10);
   /* int result = x / y;
    float resultFloat = x / y;*/

/*    System.out.println(result);
    System.out.println(resultFloat);*/

    boolean flag = x > y && y < 100;
    System.out.println(x > y && y < 100);

    x+=10; // x = x + 10;
    x-=1; // x = x - 1;
    x--; // x = x -1;
    x++; // x =  x + 1;
    System.out.println(x);
    System.out.println(x++); // post incremento
    System.out.println(++x); // pre incremento
    System.out.println(x);

    String myString = "ciao";
    System.out.print(myString);
    System.out.print(" a tutti");

  /*  int a;

    int z = a + 1; // a non è inizializzata! */

  }
}
