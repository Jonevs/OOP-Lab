//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab BA20 Week 3
package week3lab;
import java.util.Scanner;
import java.util.Random;

public class Week3lab {

    public static void main(String[] args) {
        
        int gas = 100, choice;
        Scanner reader = new Scanner(System.in);
        do
        {
            System.out.println("\n\nYour gasoline's car: " + gas + " liters");
            System.out.println("=================================");
            System.out.println("1. Start driving\n2. Rest\n3. Exit\nChoose: ");

            choice = reader.nextInt();

            switch(choice)
            {
                case 1:
                {
                    Random r = new Random();
                    int speed;
                    speed = r.nextInt(100 - 1) + 1;

                    System.out.println("\nYour speed: " + speed + " km/hour");

                    if(gas >= 0)
                    {
                        if(speed < 50)
                        {   
                            if(gas >= 20)
                            {
                                System.out.println("You have spent 20 liters");
                                gas = gas - 20;                               
                            }
                            
                            else
                            {
                                System.out.println("Your gasoline is not enough to run the car...");
                            }
                        }

                        else if(speed >= 50)
                        {
                            if(gas >= 40)
                            {
                                System.out.println("You have spent 40 liters");
                                gas = gas - 40;                           
                            }
                            
                            else
                            {
                                System.out.println("Your gasoline is not enough to run the car...");
                            } 
                        }
                    }

                    else
                    {
                        System.out.println("Your gasoline is not enough to run the car...");
                    }
                    
                    pressEnter();
                    break;
                }
                
                case 2:
                {
                    if(gas == 100)
                    {
                        System.out.println("\n\nYour gasoline is full...");
                    }
                    
                    else
                    {
                        gas = gas + 20;
                        System.out.println("\n\nSuccessfully recharge 20 liters gasoline...");
                    }
                        
                    pressEnter();
                    break;
                    
                }
                
            }
        }while(choice != 3);

    }
    
    
        public static void pressEnter() { 
            System.out.print("\nPress enter to return to main menu..");
            try
            {
                System.in.read();
            }  
            catch(Exception e)
            {
                
            }  
    }
    
}


