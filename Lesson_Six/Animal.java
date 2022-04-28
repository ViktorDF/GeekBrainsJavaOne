package Lesson_Six;

public abstract class Animal {

    protected int maximumRunningDistance;
    protected int maximumJumpingDistance;
    protected int maximumSwimmingDistance;

    public Animal(int maximumRunningDistance, int maximumJumpingDistance, int maximumSwimmingDistance) {
        this.maximumRunningDistance = maximumRunningDistance;
        this.maximumJumpingDistance = maximumJumpingDistance;
        this.maximumSwimmingDistance = maximumSwimmingDistance;
    }

    protected boolean run(int distance) {
        return distance <= maximumRunningDistance;
    }

    protected boolean jump(int high) {
        return high <= maximumJumpingDistance;
    }

    protected boolean swim(int distance) {
        return distance <= maximumSwimmingDistance;
    }

}
