//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 6
package week6lab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Week6lab {
    static Scanner read = new Scanner(System.in);
    static ArrayList<Integer> num =  new ArrayList<Integer>();
    static ArrayList<String> name = new ArrayList<String>();

    public static void pressEnter() { 
        System.out.print("\nPress enter to return to main menu..");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {

        }  
    }    
    
    public static void title() {
        System.out.println(" _______       ___            _______  __   __  _______  ______    _______");
        System.out.println("|   _   |     |   |          |       ||  | |  ||   _   ||    _ |  |       |");
        System.out.println("|  |_|  |     |   |   ____   |  _____||  |_|  ||  |_|  ||   | ||  |    ___|");
        System.out.println("|       |     |   |  |____|  | |_____ |       ||       ||   |_||_ |   |___ ");
        System.out.println("|   _  |   ___|   |          |_____  ||       ||       ||    __  ||    ___|"); 
        System.out.println("|  |_|  | |       |           _____| ||   _   ||   _   ||   |  | ||   |___ ");
        System.out.println("|_______| |_______|          |_______||__| |__||__| |__||___|  |_||_______|\n");        
    }
    
    public static void menu() {
        title();
        System.out.println("+======================+");
        System.out.println("+Options               +");
        System.out.println("+======================+");
        System.out.println("+1. Start Sharing      +");
        System.out.println("+2. Update Participant +");
        System.out.println("+3. Delete Participant +");
        System.out.println("+4. Close App          +");
        System.out.println("+======================+");
        System.out.println("Choice >>");
    }
    
    public static void showList() {
        
        System.out.println("+========================================+");
        System.out.println("+ Share List                             +");
        System.out.print("+========================================+");
        
        for (int i=0; i<(name.size()); i++)
        {
            System.out.printf("\n|%2d   | %-22s|%-10d|", (i+1), name.get(i), num.get(i));
        }
        
        System.out.println("\n+========================================+");
    }
    
    public static void menu1() {
        int input_num;
        String input_name; 
        
        do
        {
            System.out.println("Input a number [0-100]: ");
            input_num = read.nextInt();
            read.nextLine();
        }while(input_num < 0 || input_num > 100);
        
        num.add(input_num);
        
        do
        {
            System.out.println("Could you give me your username [5-20 characters]? ");
            input_name = read.nextLine();  
        }while(input_name.length() < 5 || input_name.length() > 20);
        
        if(name.contains(input_name))
        {
            System.out.println("username has already been taken!!");
            pressEnter();
            return;
        }

        name.add(input_name);                 
                
        System.out.println("You are the " + name.size() + " that joins the game");
        System.out.println("You share number : " + input_num);
        pressEnter();
      
    }
    
    public static void menu2() {
        
        if(num.isEmpty() && name.isEmpty())
        {
            pressEnter();
            return;
        }
                
        showList();
        
        int a, update;
             
        do
        {
            if(name.size() == 1)
            {
                System.out.println("Which participant you would like to update [" + name.size() + "]"
                        + "[0 to exit]? ");            
            }

            else
            {
                System.out.println("Which participant you would like to update [1 - " + name.size() + "]"
                        + "[0 to exit]? ");            
            }

            a = read.nextInt();            
        }while(a < 0 || a > name.size());

        if(a == 0)
        {
            pressEnter();
        }
        
        else
        {
            do
            {
                System.out.println("Input a number [0-100]: ");
                update = read.nextInt();                
            }while(update < 0 || update > 100);
            
            for(int i = 0; i < num.size(); i++)
            {
                if(a-1 == i)
                {
                    num.set(i, update);
                }
            }            
            System.out.println("Update Successfull!");
            pressEnter();
        }
    }
    
    public static void menu3() {
        if(num.isEmpty() && name.isEmpty())
        {
            pressEnter();
            return;
        }        
        
        showList();
        
        int b, delete;
        
        do
        {
            if(name.size() == 1)
            {
                System.out.println("Which participant you would like to delete [" + name.size() + "]"
                        + "[0 to exit]? ");            
            }

            else
            {
                System.out.println("Which participant you would like to delete [1 - " + name.size() + "]"
                        + "[0 to exit]? ");            
            }

            b = read.nextInt();            
        }while(b < 0 || b > name.size());
        
        if(b == 0)
        {
            pressEnter();
        }
        
        else
        {            
            for(int i = 0; i < name.size(); i++)
            {
                if(b-1 == i)
                {
                    name.remove(i);
                }
            }   
            
            for(int i = 0; i < num.size(); i++)
            {
                if(b-1 == i)
                {
                    num.remove(i);
                }
            }               
            System.out.println("Participant successfully removed from event");
            pressEnter();
        }
        
    }
    
    public static void menu4() {
        ArrayList<Integer> num_after = (ArrayList<Integer>)num.clone();
        
        System.out.println("Here's the completed share list\nRemember, "
                + "sharing is caring, happy sharing :D");
        System.out.println("+=============================================+");
        System.out.println("+ Share List                                  +");
        System.out.println("+=============================================+"); 
        System.out.println("+ Username                  | Before | After  +");
        System.out.print("+=============================================+");        
        Collections.sort(name);
        Collections.shuffle(num);
        Collections.reverse(num_after);        

        
        for (int i=0; i<(name.size()); i++)
        {
            System.out.printf("\n| %-26s|%-8d|%-8d|", name.get(i), num.get(i), num_after.get(i));
        }
        System.out.println("\n+=============================================+");        
        
    }

    public static void main(String[] args) {
        int choice;

        try
        {
            do
            {
                menu();
                choice = read.nextInt();

                switch(choice)
                {
                    case 1:
                    {
                        menu1();
                        break;
                    }
                    
                    case 2:
                    {
                        menu2();
                        break;
                    }
                    
                    case 3:
                    {
                        menu3();
                        break;
                    }
                    
                    case 4:
                    {
                        menu4();
                        break;
                    }
                }
            }while(choice != 4);   
        }

        catch(Exception e)
        {
            System.out.println("Error");
        }            
    }
    
}
