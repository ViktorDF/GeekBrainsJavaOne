package Lesson_Seven;

public class Cat {

    private final String name;
    private int appetite;
    private boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {

        if (appetite > p.getFood()) {
            p.decreaseFood(p.getFood());
            appetite = appetite - p.getFood();
            full = false;
        } else {
            p.decreaseFood(appetite);
            full = true;
        }

    }

    public boolean getFull() {
        return full;
    }

    public int getAppetite() {
        return appetite;
    }
    public String getName() {
        return name;
    }

}
