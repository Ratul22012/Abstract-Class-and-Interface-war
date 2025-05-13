interface Vehicle {
    void startEngine();
    void stopEngine();

    void increment();
    void decrement();
}

abstract class Transport {
    protected int engineCapacity;
    protected int wheels;

    public Transport(int engineCapacity, int wheels) {
        this.engineCapacity = engineCapacity;
        this.wheels = wheels;
    }

    public void showDetails() {
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Number of wheels: " + wheels);
    }

    public abstract void honk();
}

class Engine {
    public void start() {
        System.out.println("Engine is starting...");
    }

    public void stop() {
        System.out.println("Engine is stopping...");
    }
}

class Car extends Transport implements Vehicle {
    private Engine engine;
    private int speed;

    public Car(int engineCapacity, int wheels) {
        super(engineCapacity, wheels);
        this.engine = new Engine();
        this.speed = 0;
    }

    @Override
    public void startEngine() {
        engine.start();
        System.out.println("Car engine started.");
    }

    @Override
    public void stopEngine() {
        engine.stop();
        System.out.println("Car engine stopped.");
    }

    @Override
    public void increment() {
        speed += 10;
        System.out.println("Speed increased to: " + speed + " km/h");
    }

    @Override
    public void decrement() {
        speed -= 10;
        System.out.println("Speed decreased to: " + speed + " km/h");
    }

    @Override
    public void honk() {
        System.out.println("Car says: Beep Beep!");
    }

    public void showSpeed() {
        System.out.println("Current Speed: " + speed + " km/h");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(2000, 4);

        car1.startEngine();
        car1.showDetails();
        car1.increment();
        car1.increment();
        car1.showSpeed();
        car1.decrement();
        car1.showSpeed();
        car1.honk();
        car1.stopEngine();

        car1 = null;
        System.out.println("Requesting garbage collection...");
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main method.");
    }
}
