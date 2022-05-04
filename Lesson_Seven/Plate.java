package Lesson_Seven;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
        if (food <= 0) food = 0;
    }

    public void addFood (int food) {
        this.food += food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood(){
        return food;
    }
}
