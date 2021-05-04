//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 8
package week8lab;

public class Employee {
    protected String name, role, type;
    protected int age;
    protected boolean isActive;
    
    public Employee(String name, int age, String role, String type) //Constructor
    {
        this.name = name;
        this.age = age;
        this.role = role;
        this.type = type;
        this.isActive = true;
    }
    
    public String getName()
    {
        return name;
    }

    public boolean isActive()
    {
        return isActive;
    }
    
    public void resign()
    {
        isActive = false;
    }
    
    public void view()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);        
    }
}

class PartTime extends Employee
{
    private int payPerHour, workingHour;
    
    public PartTime(String name, int age, String role, String type, int payPerHour, int workingHour)
    {
        super(name, age, role, type);
        this.payPerHour = payPerHour;
        this.workingHour = workingHour;
        this.isActive = true;
    }
    
    @Override public void view()
    {
        int salary = payPerHour * workingHour * 4;
        
        System.out.println("Part Time Employee\n==================");
        
        if(isActive == true)
        {
            System.out.println("Status: active");
        }
        
        else
        {
            System.out.println("Status: not active");
        }
        
        super.view();
        System.out.println("Pay per hour: " + payPerHour);
        System.out.println("Working hour per week: " + workingHour);
        System.out.println("Salary per month: " + salary);
    }
}

class FullTime extends Employee
{
    private int baseSalary;
    
    FullTime(String name, int age, String role, String type, int baseSalary)
    {
        super(name, age, role, type);
        this.baseSalary = baseSalary;
        this.isActive = true;
    }
    
    @Override public void view()
    {
        System.out.println("Full Time Employee\n==================");
        
        if(isActive == true)
        {
            System.out.println("Status: active");
        }
        
        else
        {
            System.out.println("Status: not active");
        }
        
        super.view();;
        System.out.println("Salary per month: " + baseSalary);
    }
}

