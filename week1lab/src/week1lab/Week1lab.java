//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab BA20 Week 1 
package week1lab;
import java.util.*;

public class Week1lab {
    public static void main(String[] args) {
     
        int choice, mp = 0, vp = 0; //mp = jumlah Meat Lover, vp = jumlah Vegetarian
        int mpPrice = 80000, vpPrice = 50000; //harga pizza satuan
        int total;
        Scanner reader = new Scanner(System.in);
        do
        {
            System.out.println("\n\nWelcome to Yummy Delivery Pizza");
            System.out.println("===============================");
            System.out.println("1. Order Pizza\n2. Pay\n3. Exit");
            System.out.println("\nChoose: ");

            choice = reader.nextInt(); //input int choice

            switch(choice)
            {
                case 1: 
                    int order; 
                    do
                    {
                        System.out.println("\n\nChoose an order");
                        System.out.println("===============");
                        System.out.println("1. Meat Lover Pizza (@ Rp. 80000,-)");
                        System.out.println("2. Vegetarian Pizza (@ Rp. 50000,-)");
                        System.out.println("\nWhich pizza do you want to order [1-2]: ");

                        order = reader.nextInt();

                        if(order == 1)
                        {
                           mp++;
                        }

                        else if(order == 2)
                        {
                           vp++;
                        }
                    }while((order < 1) || (order > 2));
                    System.out.println("\nThank you...");
                    break;
                    
                case 2:
                    int payment, change;
                    
                    if(mp == 0 && vp == 0)
                    {
                        System.out.println("You are not buy anything..");
                        break;
                    }
                    
                    do
                    {
                        System.out.println("\n\nYou have ordered " + mp + " Meat Lover Pizza(s) and " + vp + " Vegetarian Pizza(s)");
                        total = (mp * mpPrice) + (vp * vpPrice);
                        System.out.println("\n\nTotal price: Rp. " + total);
                        System.out.println("Input your money [minimum Rp. " + total + "]: Rp. ");
                        payment = reader.nextInt();
                    }while(payment < total);

                    change = payment - total;

                    System.out.println("Your Change: Rp. " + change);
                    mp = 0;
                    vp = 0;
                    System.out.println("Thank you...");
                    break;               
            }
            
        }while(choice != 3);          
    } 
}
