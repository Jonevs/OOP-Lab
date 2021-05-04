//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 8
package week8lab;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Week8lab {
    static Scanner read = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();
    
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
        System.out.println("\nABC EMPLOYEE DATA\n=================");
        System.out.println("1.Add employee\n2.View employee\n3.Resign\n4.Exit");
    }
    
    public static void menu1() {
        String name, role, type;
        int age, payPerHour, workingHour, baseSalary;
        
        do
        {
            System.out.print("\nInput employee name[must be more than 3 characters]: ");
            name = read.nextLine();            
        }while(name.length() < 3);
        
        do
        {
            System.out.print("Input employee age[>=17]: ");
            age = read.nextInt();  
            read.nextLine(); //after nextInt, read nextLine
        }while(age < 17);

        do
        {
            System.out.print("Input employee role[Assistant | Programmer](Case Sensitive): ");
            role = read.nextLine();            
        }while(!"Assistant".equals(role) && !"Programmer".equals(role));

        do
        {
            System.out.print("Input employee type[PartTime | FullTime](Case Sensitive): ");
            type = read.nextLine();            
        }while(!"PartTime".equals(type) && !"FullTime".equals(type));
        
        if("PartTime".equals(type))
        {
            do
            {
                System.out.print("Input pay per hour[>=10000]: ");
                payPerHour = read.nextInt();
                read.nextLine();                
            }while(payPerHour < 10000);
            
            do
            {
                System.out.print("Input working hour per week[>0]: ");
                workingHour = read.nextInt();
                read.nextLine();                
            }while(workingHour <= 0);

            PartTime newEmp = new PartTime(name, age, role, type, payPerHour, workingHour);
            employees.add(newEmp);
        }
        
        else
        {
            do
            {
                System.out.print("Input base salary[>=10000]: ");
                baseSalary = read.nextInt();
                read.nextLine();                
            }while(baseSalary <= 0);
            
            FullTime newEmp = new FullTime(name, age, role, type, baseSalary);
            employees.add(newEmp);
        }
        
        System.out.println("Success insert employee data");
    }
    
    public static void menu2() {
        if(employees.isEmpty())
        {
            System.out.println("There is no employee data in the list");
        }
        
        else
        {
            for(int i = 0; i < employees.size(); i++)
            {
                System.out.println("\nEmployee no." + (i+1));
                employees.get(i).view();
            }
        }
    }
    
    public static void menu3() {
        if(employees.isEmpty())
        {
            System.out.println("There is no employee data in the list");
        }
        
        else
        {
            for(int i = 0; i < employees.size(); i++)
            {
                System.out.println("\nEmployee no." + (i+1));
                employees.get(i).view();
            }

            int input;
            do
            {
                System.out.print("Input employee number that want to resign[1.." + employees.size() + "]: ");
                input = read.nextInt();                
            }while(input < 1 || input > employees.size());
            
            if(employees.get(input - 1).isActive == false)
            {
                System.out.println("Employee has already resigned!");
            }
            
            else
            {
                employees.get(input - 1).resign();
                System.out.println(employees.get(input - 1).getName() + " is resigning...");
            }
        }
    }
    
    public static void main(String[] args) {
        int choice;
        
        try
        {
            do
            {
                menu();
                System.out.print("\nChoice: ");
                choice = read.nextInt();
                read.nextLine(); //after nextInt, read nextLine

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
            System.out.println("ERROR! Wrong input type");
        }
    }
}