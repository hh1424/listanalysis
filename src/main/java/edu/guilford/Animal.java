package edu.guilford;

public class Animal implements Comparable<Animal>{
    
    //attributes
    private String type;
    private String color;
    private int legs;
    private double size;
    private String sound;
    private boolean vegitarian;

    enum SortOrder{FORWARD, REVERSE}
    public static SortOrder sortOrder = SortOrder.FORWARD;

    //Constructor with parameters
    public Animal(String type, String color, int legs, double size, String sound, boolean vegitarian) {
        super();
        this.type = type;
        this.color = color;
        this.legs = legs;
        this.size = size;
        this.sound = sound;
        this.vegitarian = vegitarian;
    }

    //empty constructor
    public Animal() {
        //Choose a random animal from a list of 10 posibilities
        String[] types = {"cheeta", "horse", "snake", "crab",
        "dog", "cat", "cow", "pig", "duck", "chicken"};
        int randomIndex = (int)(Math.random() * types.length);
        this.type = types[randomIndex];
        //Choose a random color from a list of 10 posibilities
        String[] colors = {"red", "blue", "green", "yellow", 
        "orange", "purple", "pink", "black", "white", "brown"};
        randomIndex = (int)(Math.random() * colors.length);
        this.color = colors[randomIndex];
        //Choose a random leg count from 0 to 10
        this.legs = (int)(Math.random() * 11);
        //Choose a random size from 0 to 300
        this.size = Math.random() * 301;
        //Choose a random sound from a list of 10 positibilites
        String[] sounds = {"meow", "woof", "moo", "oink", "quack", 
        "neigh", "baa", "hee-haw", "cluck", "roar"};
        randomIndex = (int)(Math.random() * sounds.length);
        this.sound = sounds[randomIndex];
        //Choose two random values for vegitarian
        boolean[] vegitarian = {true, false};
        randomIndex = (int)(Math.random() * vegitarian.length);
        this.vegitarian = vegitarian[randomIndex];
    }

    //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null) {
            this.type = type;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        if (legs > 0) {
            this.legs = legs;
        }
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        if (size > 0) {
            this.size = size;
        }
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        if (sound != null) {
            this.sound = sound;
        }
    }

    public boolean isVegitarian() {
        return vegitarian;
    }

    public void setVegitarian(boolean vegitarian) {
        this.vegitarian = vegitarian;
    }

    //toString 
    @Override
    public String toString() {
        return "Animal [type: " + type + ", color: " + color + ", legs: " + legs + 
        ", size: " + size + ", sound: " + sound + ", vegitarian: " + vegitarian + "]";
    }
    
    //Create a static selectionSort method that sorts an array of animals
    //based on the color of the animal
    public static void selectionSort(Animal[] animals){
        for(int i = 0; i < animals.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < animals.length; j++){
                if(animals[j].compareTo(animals[minIndex]) < 0){
                    minIndex = j;
                }
            }
            Animal temp = animals[i];
            animals[i] = animals[minIndex];
            animals[minIndex] = temp;
        }
    }

    //Implement compareTo method that compares the sound of two animlas
    @Override
    public int compareTo(Animal other) {
        int result = sound.compareTo(other.getSound());
        if(result == 0){
            //if the sounds are the same, compare the colors
            result = color.compareTo(other.getColor());
        }
        if(sortOrder == SortOrder.REVERSE){
            result = -result;
        }
        return result;
    }

}
