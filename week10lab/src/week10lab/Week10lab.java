//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 10
package week10lab;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author jonathan
 */
public class Week10lab {
    
    static Scanner read = new Scanner(System.in);
    static Random r = new Random();
    static ArrayList<Animal> runners = new ArrayList<>(); 
    static int hareWin = 0, turtleWin = 0;
    
    public static void pressAnyKey() { 
        System.out.print("\nPress any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {

        }  
    }       
    
    public static void menu() {
        System.out.println(" _______      ___            ______    __   __   __    _");
        System.out.println("|  _    |    |   |          |    _ |  |  | |  | |  |  | |");
        System.out.println("| |_|   |    |   |   ____   |   | ||  |  | |  | |   |_| |");
        System.out.println("|       |    |   |  |____|  |   |_||_ |  |_|  | |       |");
        System.out.println("|  _   |  ___|   |          |    ___ ||       | |  _    |");
        System.out.println("| |_|   ||       |          |   |  | ||       | | | |   |");
        System.out.println("|_______||_______|          |___|  |_||_______| |_|  |__|\n");
        System.out.println("+=======================+");
        System.out.println("+ Menu List             +");
        System.out.println("+=======================+");
        System.out.println("+ 1. Add Runner         +");
        System.out.println("+ 2. Join Run           +");
        System.out.println("+ 3. View Standing      +");
        System.out.println("+ 4. Close Program      +");
        System.out.println("+=======================+");
        System.out.print("Choice >> ");
    }
    
    public static void menu1() {
        String type, name;
        int speed;
        
        do
        {
            System.out.print("Which animal will you rooting for [hare | turtle]? ");
            type = read.nextLine();            
        }while(!"hare".equals(type) && !"turtle".equals(type));
        
        do
        {
            System.out.print("What's the name [5 - 15 characters]? ");
            name = read.nextLine();
        }while(name.length() < 5 || name.length() > 15);
        
        if("hare".equals(type))
        {
            speed = r.nextInt(50)+1 + 25;
            Hare hare = new Hare(name, type, speed);
            runners.add(hare);
        }
        
        else
        {
            speed = r.nextInt(25)+1 + 25;
            Turtle turtle = new Turtle(name, type, speed);
            runners.add(turtle);
        }
        
        System.out.println("Another runner has joined the race!!");
    }
    
    public static void menu2() {
        
        if(runners.isEmpty())
        {
            System.out.print("\nNo Data...");
            return;
        }
        
        int totalDistance;
        
        totalDistance = r.nextInt(3);
        
        switch (totalDistance) {
            case 0:
                totalDistance = 150;
                break;
            case 1:
                totalDistance = 250;
                break;
            case 2:
                totalDistance = 500;
                break;
            default:
                break;
        }
        
        
        for(int a = 0; a < 3; a++)
        {
            System.out.print("Generating data statistic");
            
            for(int b = 0; b <= a; b++)
            {
                System.out.print(".");
            }
            
            System.out.print("\n");
            read.nextLine();
        }
        
        if(runners.size() == 1)
        {
            System.out.println("Need more runner...");
            return;
        }
        
        do
        {
            System.out.println("\n+===========================================+");
            System.out.println("+ Current Standing                     " + totalDistance + "  +");
            System.out.println("+===========================================+");
            System.out.println("+ No. | Name            | Type   | Distance +");
            System.out.println("+===========================================+");

            for(int i = 0; i < runners.size(); i++)
            {
                runners.get(i).move();
                runners.get(i).setDistance();
                Collections.sort(runners, Collections.reverseOrder());
            }   

            for(int i = 0; i < runners.size(); i++)   
            {
               System.out.printf("+ %2d. | %-16s| %-7s| %-9s+", i+1, runners.get(i).getName(),
                       runners.get(i).getType(), runners.get(i).getDistance());
               read.nextLine();  
            }

           System.out.println("+===========================================+\n"); 
           read.nextLine();
        }while(runners.get(0).getDistance() < totalDistance);
        
        System.out.println("The winner is ...\n " + runners.get(0).getName() + " the " +
                runners.get(0).getType() + "!!!");
        
        if(runners.get(0).getType().compareTo("hare") == 0)
        {
            hareWin++;
        }
        
        else
        {
            turtleWin++;
        }
        
        for(int i = 0; i < runners.size(); i++)
        {
            runners.get(i).setDistance();
        }
    }
    
    public static void menu3() {
        if(hareWin == turtleWin)
        {
            System.out.println(" ______   ______    _______  _     _");
            System.out.println("|      | |    _ |  |   _   || | _ | |");
            System.out.println("|  _    ||   | ||  |  |_|  || || || |");
            System.out.println("| | |   ||   |_||_ |       ||       |");
            System.out.println("| |_|   ||    ___ ||       ||       |");
            System.out.println("|       ||   |  | ||   _   ||   _   |");
            System.out.println("|______| |___|  |_||__| |__||__| |__|");            
        }
        
        else if(hareWin > turtleWin)
        {
            System.out.println(" __   __  _______  ______    _______    ___      _______  _______  ______   _______ ");
            System.out.println("|  | |  ||   _   ||    _ |  |       |  |   |    |       ||   _   ||      | |       |");
            System.out.println("|  |_|  ||  |_|  ||   | ||  |    ___|  |   |    |    ___||  |_|  ||  _    ||  _____|");
            System.out.println("|       ||       ||   |_||_ |   |___   |   |    |   |___ |       || | |   || |_____ ");
            System.out.println("|       ||       ||    __  ||    ___|  |   |___ |    ___||       || |_|   ||_____  |");
            System.out.println("|   _   ||   _   ||   |  | ||   |___   |       ||   |___ |   _   ||       | _____| |");
            System.out.println("|__| |__||__| |__||___|  |_||_______|  |_______||_______||__| |__||______| |_______|");            
        }
        
        else
        {
            System.out.println(" _______  __   __  ______    _______  ___      _______    ___      _______  _______  ______   _______ ");
            System.out.println("|       ||  | |  ||    _ |  |       ||   |    |       |  |   |    |       ||   _   ||      | |       |");
            System.out.println("|_     _||  | |  ||   | ||  |_     _||   |    |    ___|  |   |    |    ___||  |_|  ||  _    ||  _____|");
            System.out.println("  |   |  |  |_|  ||   |_||_   |   |  |   |    |   |___   |   |    |   |___ |       || | |   || |_____ ");
            System.out.println("  |   |  |       ||    ___ |  |   |  |   |___ |    ___|  |   |___ |    ___||       || |_|   ||_____  |");
            System.out.println("  |   |  |       ||   |  | |  |   |  |       ||   |___   |       ||   |___ |   _   ||       | _____| |");
            System.out.println("  |___|  |_______||___|  |_|  |___|  |_______||_______|  |_______||_______||__| |__||______| |_______|");            
        }
            System.out.printf("+=================================+\n");
            System.out.printf("+      Hare      +     Turtle     +\n");
            System.out.printf("+=================================+\n");
            System.out.printf("+ %-14d + %-14d +\n", hareWin, turtleWin);
            System.out.printf("+=================================+\n");
    }
    
   
    public static void main(String[] args) {
        int choice; 
        try
        {
            do
            {
                menu();
                choice = read.nextInt();
                read.nextLine();

                switch(choice)
                {
                    case 1:
                    {
                        menu1();
                        pressAnyKey();
                        break;
                    }
                    
                    case 2:
                    {
                        menu2();
                        pressAnyKey();
                        break;
                    }
                    
                    case 3:
                    {
                        menu3();
                        pressAnyKey();
                        break;
                    }
                }

            }while(choice != 4);            
        }
        
        catch(Exception e)
        {
            System.out.println("ERROR! Wrong Input Type");
        }

    }
    
}
