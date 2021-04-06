//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 7
package weeklab7;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Weeklab7 {
    static Scanner read = new Scanner(System.in);
    static ArrayList<cake> cakes = new ArrayList<>();
    
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
        System.out.println("\nHOMEMADE CAKE\n=============");
        System.out.println("1.Add cake to be baked\n2.Bake cake\n"
                + "3.Change cake topping\n4.View cake list\n5.Exit");
        System.out.print("Choice: ");
    }
    
    public static void addCake() {
        String iFlavor, iTopping;
        int iFlour;
        
        do
        {
            System.out.print("Choose cake flavor[Cheese | Chocolate | Vanilla]"
                    + "(Case Sensitive): ");
            iFlavor = read.next();            
        }while(!"Cheese".equals(iFlavor) && !"Chocolate".equals(iFlavor) 
                && !"Vanilla".equals(iFlavor));
        
        do
        {
            System.out.print("Input how many flour will be used (gram)[>0]: ");
            iFlour = read.nextInt();            
        }while(iFlour <= 0);
        
        do
        {
            System.out.print("Input your cake topping[Cream | Oreo]"
                    + "(Case Sensitive): ");
            iTopping = read.next();
        }while(!"Cream".equals(iTopping) && !"Oreo".equals(iTopping));
        
        cake cake = new cake(iFlavor, iFlour, iTopping);
        
        cakes.add(cake);
        
        System.out.println("The cake is made!");
        
        System.out.println(cakes.size() + " cake(s) are in the list");
        
        pressAnyKey();
    }

    public static void bakeCake() {
        if(cakes.isEmpty())
        {
            System.out.println("There is no cake that has been made yet!");
            pressAnyKey();
            return;
        }
        
        for(int i = 0; i < (cakes.size()); i++)
        {
            System.out.println("\nCake number " + (i+1) + "\n===========");
            cakes.get(i).show();
        }
        
        int input;
        
        if(cakes.size() == 1)
        {
            System.out.print("\nInput cake number[" + cakes.size() + "..1]: ");
        }
        
        else
        {
            System.out.print("\nInput cake number[1.." + cakes.size() + "]: ");
        }
        
        input = read.nextInt();
        
        for(int j = 0; j < cakes.size(); j++)
        {
            if(input - 1 == j)
            {
                if(cakes.get(j).isBaked == true)
                {
                    System.out.println("This cake has been baked");
                    pressAnyKey();
                    return;
                }
                
                System.out.println("Mixing " + cakes.get(j).flavor + " flavor"
                        + ", " + cakes.get(j).flour + " gram of flour, "
                        + cakes.get(j).sugar + " gram of sugar");
                System.out.println("Baking the cake..");
                cakes.get(j).isBaked = true;
            }
        }
        
        pressAnyKey();
    }
    
    public static void changeCake() {
        if(cakes.isEmpty())
        {
            System.out.println("There is no cake that has been made yet!");
            pressAnyKey();
            return;
        }
        
        for(int i = 0; i < (cakes.size()); i++)
        {
            System.out.println("\nCake number " + (i+1) + "\n===========");
            cakes.get(i).show();
        }  
        
        int input;
        
        if(cakes.size() == 1)
        {
            System.out.print("\nInput cake number[" + cakes.size() + "..1]: ");
            
        }
        
        else
        {
            System.out.print("\nInput cake number[1.." + cakes.size() + "]: ");
        }
        
        input = read.nextInt();
        
        String newTopping;
        
        for(int j = 0; j < cakes.size(); j++)
        {
            if(input - 1 == j)
            {
                if(cakes.get(j).isBaked == true)
                {
                    System.out.println("This cake has been baked");
                    pressAnyKey();
                    return;
                }
                
                do
                {
                    System.out.print("Input your new cake topping[Cream | Oreo]: ");
                    newTopping = read.next();            
                }while(!"Cream".equals(newTopping) && !"Oreo".equals(newTopping));
                
                cakes.get(j).updateTopping(newTopping);
            }
        }        
        
    }
    
    public static void viewCake() {
        if(cakes.isEmpty())
        {
            System.out.println("There is no cake that has been made yet!");
            pressAnyKey();
            return;
        }

        for(int i = 0; i < (cakes.size()); i++)
        {
            System.out.println("\nCake number " + (i+1) + "\n===========");
            cakes.get(i).show();
        }        
        
        pressAnyKey();
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
                        addCake();
                        break;
                    }
                    
                    case 2:
                    {
                        bakeCake();
                        break;
                    }
                    
                    case 3:
                    {
                        changeCake();
                        break;
                    }
                    
                    case 4:
                    {
                        viewCake();
                        break;
                    }
                }
                
            }while(choice != 5);            
        }
        
        catch(Exception e)
        {
            System.out.println("ERROR! Wrong input type");
        }

    }
    
}
