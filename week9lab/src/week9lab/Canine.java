//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 9
package week9lab;

/**
 *
 * @author jonathan
 */
public class Canine extends Animal
{
    private int speed, i, max;
    
    public Canine(String name, String gender, String genus, int speed) {
        super(name, gender, genus);
        this.speed = speed;
    }        
    
    public int getSpeed(){
        return speed;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }    
    
   @Override 
    public void roam(){
        int total_range;
        total_range = (int)(super.roamingTime * speed);
        System.out.print("Roaming for total range of " + total_range + " in " + super.roamingTime + " minutes");
    }    
    
}
