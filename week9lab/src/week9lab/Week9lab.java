//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 9
package week9lab;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jonathan
 */
public class Week9lab {
    static Scanner read = new Scanner(System.in);
    static ArrayList<Animal> animals = new ArrayList<>();
    static Random r = new Random();
    static int nowCan = 0, maxCan = 0, nowFel = 0, maxFel = 0;
    
    public static void pressAnyKey() { 
        System.out.print("\nPress any key to continue...");
        read.nextLine();
    }      
    
    public static void menu() {
        System.out.println("\nBJ ZOO");
        System.out.println("+=======================+");
        System.out.println("+ Menu List             +");
        System.out.println("+=======================+");
        System.out.println("+ 1. Add Zoo Animal     +");
        System.out.println("+ 2. View Zoo Animal    +");
        System.out.println("+ 3. Take For A Walk    +");
        System.out.println("+ 4. Release Zoo Animal +");
        System.out.println("+ 5. Close Program      +");
        System.out.println("+=======================+");
        System.out.print("Choice >> ");
    }
    
    public static void menu1() {
        String name, gender, genus;
        int speed;
        
        do
        {
            System.out.print("What's the name [5 - 15 characters]? ");
            name = read.nextLine();            
        }while(name.length() < 5 || name.length() > 15);
        
        do
        {
            System.out.print("What's its gender [male | female]? ");
            gender = read.nextLine();
        }while(!"male".equals(gender) && !"female".equals(gender));
        
        do
        {
            System.out.print("What's its genus [canine | feline]? ");
            genus = read.nextLine();
        }while(!"canine".equals(genus) && !"feline".equals(genus));
        
        if("canine".equals(genus))
        {
            do
            {
                System.out.print("What's its speed [1 - 80]? ");
                speed = read.nextInt();            
            }while(speed < 1 || speed > 80);    
            
            Canine can = new Canine(name, gender, genus, speed);
            animals.add(can);
            
            nowCan++;
            maxCan++;
        }
        
        else
        {
            speed = r.nextInt(80 - 1) + 1;
            Feline fel = new Feline(name, gender, genus, speed);
            animals.add(fel);
            
            nowFel++;
            maxFel++;
        }
        
        mood();
        System.out.println("Another animal has joined the zoo!!");       
        
    }
    
    public static void mood() {
        String mood = null;
        
        for(int i = 0; i < animals.size(); i++)
        {
            if(animals.get(i).getGenus().equals("canine"))
            {
                if(nowCan == 1 && maxCan == 1)
                {
                    mood = "happy";
                }
                
                else if(nowCan < maxCan)
                {
                    mood = "happy";
                }
                
                else
                {
                    mood = "unhappy";
                }
            }
            
            else if(animals.get(i).getGenus().equals("feline"))
            {
                if(nowFel == 1 && maxFel == 1)
                {
                    mood = "happy";
                }
                
                else if(nowFel < maxFel)
                {
                    mood = "unhappy";
                }
                
                else
                {
                    mood = "happy";
                }
            }
            
            animals.get(i).setMood(mood);
        }
    }
    
    public static void menu2() {
        
        System.out.println("+========================================================+");
        System.out.println("+ No. | Name            | Genus    | Mood       | Gender +");
        System.out.println("+========================================================+");
        
        if(animals.isEmpty())
        {
            System.out.println("+ No Zoo Animal Spotted                                  +");
            System.out.println("+========================================================+");
            return;
        }

        else
        {
            for(int i = 0; i < animals.size(); i++)
            {
                System.out.printf("+ %2d. | %-16s| %-8s | %-10s | %-6s |\n",i+1,animals.get(i).getName()
                        ,animals.get(i).getGenus(),animals.get(i).getMood(),animals.get(i).getGender());
            }
            
        }   
        
        System.out.println("+========================================================+");
    }
    
    public static void menu3() {
        int choice = 0;
        
        if(animals.isEmpty())
        {
            menu2();
            return;
        }
        
        else
        {
            menu2();
            
            do
            {
                System.out.print("Choose animal to take for a stroll [1 - " + animals.size() + "]? ");
                choice = read.nextInt();
                read.nextLine();
            }while(choice < 1 || choice > animals.size());
        }
        
        int roamingTime = 0;
        
        do{
            System.out.print("Input roaming time [0-50]: ");
            
            try 
            {
                roamingTime = read.nextInt();
            } 
            
            catch (Exception e) 
            {
                System.out.println("Input must be numeric");
                read.nextLine();
            }
        }while(roamingTime<0 || roamingTime>50);
        
        if (animals.get(choice-1).getGenus().equals("canine")) 
        {
            if(roamingTime==0)
            {
                roamingTime = 60;
            }
            animals.get(choice-1).setRoamingTime(roamingTime);
            animals.get(choice-1).roam();
        }
        
        else if(animals.get(choice-1).getGenus().equals("feline"))
        {
            if(roamingTime==0)
            {
                roamingTime = 30;
            }
            
            else
            {
                roamingTime = roamingTime/2;
            }
            
            animals.get(choice-1).setRoamingTime(roamingTime);

            int rand = r.nextInt(1 - 0) + 0;
            
            if(rand==0)
            {
                System.out.println("Feline " + animals.get(choice-1).getName() 
                        + " doesn't feel like roaming at all today....");
            }
            
            else
            {
                animals.get(choice-1).roam();
            }
        }
    }
    
    public static void menu4() {
        int choice = 0;
        
        if(animals.isEmpty())
        {
            menu2();
            return;
        }
        
        else if(animals.size() == 1)
        {
            System.out.println("Can't release if animal less than 2");
            return;
        }
        
        else
        {
            do
            {
                menu2();
                System.out.print("Choose animal to take for a stroll [1 - " + animals.size() + "]? ");
                try {
                    choice = read.nextInt();
                } catch (Exception e) {
                    System.out.println("Input must be numeric");
                    read.nextLine();
                }                
            }while(choice < 1 || choice > animals.size());
            
            int rand;
            
            do
            {
               rand = r.nextInt(animals.size() - 1) + 1;                       
            }while(rand == choice);

            if(animals.get(choice-1).getGenus().equals("canine") && animals.get(rand-1).getGenus().equals("canine"))
            {
                if (!animals.get(choice-1).getGender().equals(animals.get(rand-1).getGender()))
                {
                    animals.get(choice-1).makeSound(1);
                    
                    if(choice > rand)
                    {
                        animals.remove(choice-1);
                        animals.remove(rand-1);
                    }
                    else
                    {
                        animals.remove(rand-1);
                        animals.remove(choice-1);
                    }
                }
                
                else
                {
                    animals.get(choice-1).makeSound();
                    animals.remove(choice-1);
                }               
            }
            
            else if(animals.get(choice-1).getGenus().equals("feline") && animals.get(rand-1).getGenus().equals("feline"))
            {
                if(!animals.get(choice-1).getGender().equals(animals.get(rand-1).getGender()))
                {
                    animals.get(choice-1).makeSound(1);
                    if(choice>rand)
                    {
                        animals.remove(choice-1);
                        animals.remove(rand-1);
                    }
                    else
                    {
                        animals.remove(rand-1);
                        animals.remove(choice-1);
                    }
                }
                
                else
                {
                    animals.get(choice-1).makeSound();
                    animals.remove(choice-1);
                }                
            }
            
            else
            {
                System.out.println("Different Genus can't be released");
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
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

                    case 4:
                    {
                        menu4();
                        pressAnyKey();
                        break;
                    }
                }        

            }while(choice != 5);            
        }
        
        catch(Exception e)
        {
            System.out.println("ERROR! Wrong Input Type");
        }
                
    }
    
}
