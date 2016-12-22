import java.util.Scanner;
import Calculator.Calculator;

public class Main { 

public static void main(String[] args) 
{ 

	
    Scanner in = new Scanner(System.in);
    
    String string = in.nextLine();
    Calculator calc = new Calculator (string);
    
	System.out.println(calc.answ);
	
	in.close();
} 
}