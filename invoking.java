interface Animal {
    void makeSound();
}

abstract class Dog {
    abstract void eat();
}

class Cow extends Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cow says Moo!");
    }

    @Override
    public void eat() {
        System.out.println("Cow is eating grass!");
    }
}

public class invoking {
    public static void main(String[] args) {

        Animal animal = new Cow();
        long startTime1 = System.nanoTime();
        animal.makeSound();
        long endTime1 = System.nanoTime();
        System.out.println("Interface call time: " + (endTime1 - startTime1) + " ns");

        Dog dog = new Cow();
        long startTime2 = System.nanoTime();
        dog.eat();
        long endTime2 = System.nanoTime();
        System.out.println("Abstract class call time: " + (endTime2 - startTime2) + " ns");
    }
}
