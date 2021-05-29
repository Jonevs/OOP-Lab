//JONATHAN EVAN SAMPURNA (2301876612) - OOP Lab Week 9
package week9lab;

/**
 *
 * @author jonathan
 */

public class Animal {
	private String name, gender, genus, mood;
        int roamingTime;
	
	public Animal() {}
	
	public Animal(String name, String gender, String genus) {
            super();
            this.name = name;
            this.gender = gender;                
            this.genus = genus;                
	}

        public void makeSound(int x) {
            System.out.println("animal: use growl!!");
	}
        
	public void makeSound() {
            System.out.println("animal: use growl!!");
	}
	
	public void selfComfort() {
            System.out.println("animal comforting themselves");
	}
	
	public void roam() {
            System.out.println("animal roams free");
	}
        
	public String getName() {
            return name;
	}

	public void setName(String name) {
            this.name = name;
	}        

	public String getGender() {
            return gender;
	}

	public void setGender(String gender) {
            this.gender = gender;
	}
        
        public String getGenus(){
            return genus;
        }
    
        public void setGenus(String genus){
            this.genus = genus;
        }

        public String getMood() {
            return mood;
        }

        public void setMood(String mood) {
            this.mood = mood;
        }        
        
        public void setRoamingTime(int roamingTime) {
            this.roamingTime = roamingTime;
        }
        
        public float getRoamingTime() {
            return roamingTime;
        }        
}
