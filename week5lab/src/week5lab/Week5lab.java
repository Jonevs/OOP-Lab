//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 5
package week5lab;
import java.util.Scanner;

public class Week5lab {
    
    public static int getnum()
    {
        int num;
        Scanner read = new Scanner(System.in);

        do
        {
            System.out.println("Input the number [1-100]");
            num = read.nextInt();    
        }while(num < 1 || num > 100);  
        
        return num;
    }
    
    public static void binary(int a)
    {
        int i;
        int bin[] = new int[10];
        
        System.out.print("The Result of Binary Number " + a + ": ");
        
        for(i = 0; a > 0; i++)
        {
            bin[i] = a % 2;
            a = a / 2;
        }
        
        for(i = i - 1; i >= 0; i--)
        {
            System.out.print(bin[i]);
        } 
    }
    
    public static void binaryStep(int a)
    {
        int i, b = a;
        int bin[] = new int[10];
        
        System.out.println("The Result of Binary Number");
        
        for(i = 0; a > 0; i++)
        {
            bin[i] = a % 2;
            System.out.print("\nStep " + (i+1) + ": " + a + "/2, ");
            a = a / 2;
            System.out.print(" Remainder = " + bin[i] + ", ");
            System.out.println(" Quotient = " + a);
        }
        
        System.out.print("\n" + b + " in decimal = ");
        for(i = i - 1; i >= 0; i--)
        {
            System.out.print(bin[i]);
        } 
        System.out.println(" in binary");
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int choice;
        
        do
        {
            System.out.println("\nBinary Number Calculation");
            System.out.println("=========================");
            System.out.println("1.Binary Number\n2.Binary Number with step\n3.Exit");

            System.out.println("Choose: ");  
            choice = read.nextInt();
            
            switch(choice)
            {
                case 1:
                {
                    int num = getnum();
                    binary(num);
                    break;
                }
                
                case 2:
                {
                    int num = getnum();
                    binaryStep(num);
                    break;
                }
                
                case 3:
                {
                    System.out.println("Thank you and have a nice day.. ^^");
                    break;
                }
                
            }
            
        }while(choice != 3);
        
    }
    
}
