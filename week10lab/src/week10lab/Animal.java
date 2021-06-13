//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 10
package week10lab;

/**
 *
 * @author jonathan
 */
public abstract class Animal {
    private int total, speed;
    private String name, type;
    abstract int move();
    abstract int getDistance();
    abstract void setDistance();
    abstract void setDistanceZero();
    
    public Animal(String name, String type, int speed) {
        this.name = name;
        this.type = type;
        this.speed = speed;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }       
    
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public String getType() {
        return type;
    }
        
}
