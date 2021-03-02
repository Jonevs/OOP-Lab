//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab BA20 Week 2

package week2lab;
import java.util.Scanner;
import java.util.Random;

public class Week2lab {
    
    //Main Menu
    public static void main(String[] args) {
        int choice;
        Scanner reader = new Scanner(System.in);
        
        do{
            System.out.println("\nSUBJECT\n=======");
            System.out.println("1. Mathematics\n2. English\n3. Exit\n");
            System.out.println("Choice: ");

            choice = reader.nextInt();    
            
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
               
            }
        }while(choice != 3);
    }
   
    //Math Menu
    public static void menu1(){
        int choiceMenu1; 
        Scanner reader = new Scanner(System.in);
      
        do
        {
            System.out.println("\nMATH MENU\n=========");
            System.out.println("\n1. Calculate circle area\n2. Calculate rectangle area");
            System.out.println("\nChoice: "); 
            choiceMenu1 = reader.nextInt();
            
        }while((choiceMenu1 < 1) || (choiceMenu1 > 2));



        switch(choiceMenu1)
        {
            case 1:
            {   
                double area, phi = 3.14;
                int radius, diameter;
                String input;
                
                do
                {
                    System.out.println("\nChoose input type[Radius|Diameter] (Case Insensitive): ");
                    input = reader.next();                   
                }while(!"radius".equalsIgnoreCase(input) && !"diameter".equalsIgnoreCase(input));

                if("radius".equalsIgnoreCase(input)) 
                {

                    Random r = new Random();    
                    radius = r.nextInt(100 - 1) + 1;

                    System.out.println("\nThe generated radius value is " + radius);

                    area = phi * Math.pow(radius, 2);

                    System.out.println("\nThe area of the circle is " + area);

                }

                else if("diameter".equalsIgnoreCase(input))
                {
                    Random r = new Random();
                    diameter = r.nextInt(100 - 1) + 1;
                    
                    System.out.println("\nThe generated diameter value is " + diameter);

                    area = phi *  Math.pow(diameter / 2, 2);

                    System.out.println("\nThe area of circle is " + area);

                }  

                break;
            }

            case 2:
            {
                int area, width, length;
                String wl; //string yang diinput 
                
                do
                {
                    System.out.println("\nInput width and length[format: WidthxLength]: ");
                    wl = reader.next();                    
                }while(!wl.contains("x"));

                
                String index[] = wl.split("x"); //buat tampung string dari wl yang dipecah
                
                width = Integer.parseInt(index[0]);
                length = Integer.parseInt(index[1]);
                area = width * length;

                System.out.println("\nThe area of rectangle is " + area);

                break;
            }
        }     
      
    }
    
    //English Menu
    public static void menu2(){
        Scanner reader = new Scanner(System.in);
        String word, tense;
        int mark; //buat penanda kalau ada non-alfabet
       
        do
        {
            System.out.println("\nInput word[only 1 word | must only be alphabet]: ");
            word = reader.nextLine();
            
            mark = 0;
            
            for(int a = 0; a < word.length(); a++)
            {
                if(!Character.isLetter(word.charAt(a))) 
                { 
                    mark++;
                }  
            }
               
        }while((word.contains(" ")) || (mark != 0));
        
        do
        {
            System.out.println("\nInput tenses type[Present | Past] (Case Sensitive): ");
            tense = reader.next();     
           
        }while(!"Past".equals(tense) && !"Present".equals(tense));

        int i = word.length();

        if("Present".equals(tense))
        {     
            if((word.charAt(i - 1) == 's') || ((word.charAt(i - 1) == 's') && word.charAt(i - 2) == 'e'))           
            {
                System.out.println(word + " is a plural word");
                System.out.println("It contains " + i + " character(s)");
            }

            else
            {
                System.out.println(word + " is a singular word");
                System.out.println("It contains " + i + " character(s)");
            }   
        }

        else if("Past".equals(tense))
        {
            if((word.charAt(i - 1) == 'd') || ((word.charAt(i - 1) == 'e') && word.charAt(i - 2) == 'd'))
            {
                System.out.println(word + " is regular verb");
                System.out.println("It contains " + i + " character(s)");
            }

            else
            {
                System.out.println(word + " is irregular verb");
                System.out.println("It contains " + i + " character(s)");
            }
        }            
        
    }
       
}