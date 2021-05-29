package javaapplication22;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.*;

public class JavaApplication22 {
//    public static void main(String[] args){
//        DecimalFormat df = new DecimalFormat("###.###");
//        BMI bmi1 = new BMI("Kim", 18, 70.0, 1.65); 
//        System.out.println("The BMI is  " + bmi1.getBMI() + " Status = " + bmi1.getStatus());
//        System.out.println("Nama = " + bmi1.getName());
//        System.out.println("Umur = " + bmi1.getAge());
//        bmi1.SetBMI("Captain America", 30, 90, 1.9);
//        System.out.println("\nThe BMI is  " + df.format(bmi1.getBMI()) + " Status = " + bmi1.getStatus());
//        System.out.println("Berat = " + bmi1.getWeight());
//    }
//    
//    public static class BMI{
//        
//        private String name; 
//        private int age; 
//        private double weight; 
//        private double height; 
//        private double bmi; 
//        
//        BMI(String name, int age, double weight, double height){
//            this.name = name; 
//            this.age = age;
//            this.weight = weight; 
//            this.height = height; 
//        }
//        public void SetBMI(String name,int age, double weight, double height){
//            this.name = name; 
//            this.age = age;
//            this.weight = weight; 
//            this.height = height; 
//        }
//        
//        public double getBMI(){
//            bmi = weight / (height*height);
//            return bmi; 
//        }
//        
//        public String getStatus(){
//            if (bmi < 18.5)
//                return("underweight"); 
//            else if (bmi >= 18.5 && bmi<24.9)
//                return ("normal"); 
//            else if (bmi >=24.9 && bmi <30.0)
//                return ("overweight"); 
//            else if (bmi >=30.0 && bmi <40)
//                return ("Obese"); 
//            else return ("Morbidly Obese");             
//            
//        }
//        
//        public String getName(){
//            return name; 
//        }
//        
//        public int getAge(){
//            return age; 
//        }
//        
//        public double getWeight(){
//            return weight; 
//        }
//        public double getHeight(){
//            return height; 
//        }
//    }
//    

//    public static void main(String[] args) {
//        Scanner read = new Scanner(System.in);
//        
//        Course course1 = new Course("Object Oriented Programming");
//        Course course2 = new Course("Structures Data"); 
//        Course course3 = new Course("Algorithm Design");
//        
//        course1.addStudent("Princess Bella");
//        course1.addStudent("Princess Cinderella");
//        course1.addStudent("Princes Ariel");
//        
//        course2.addStudent("Prince Arthur");
//        course2.addStudent("Prince Wiliam");
//        
//        
//        
//        System.out.println("Number of Student in Course 1 :" + course1.getNumberOfStudents());
//        String[] students = course1.getStudents(); 
//        for (int i=0; i<course1.getNumberOfStudents(); i++)
//            System.out.print(students[i]+ " ,");
//        
//        System.out.println("\n\nNama Mahasiswa: ");
//        String nama = read.nextLine();
//        
//        course3.addStudent(nama);
//        System.out.println("Nama Mahasiswa " + course3.getCourseName() + ": "+ course3.getStudents()[0]);
//        
//    }
    
public static void main(String[] args) {
            State state = new State();
            state.setStateName("California");
             
             
           CityClass city = new CityClass();
            city.setCityName("Los Angeles");
            CityClass city2 = new CityClass();
            city2.setCityName("San Diago");
             
            List<CityClass> empList = new ArrayList<CityClass>();
            empList.add(city);
            empList.add(city2);
             
             
            state.setState(empList);
             
             
            System.out.println(state.getCities()+" are cities in the state "+
                    state.getStateName());
        }
}
