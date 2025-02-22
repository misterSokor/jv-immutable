package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels.size());
        this.engine = engine != null ? engine.clone() : null;
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, (newEngine != null) ? newEngine.clone() : null);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), (engine != null)
                ? engine.clone() : null);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = getWheels();
        wheelsCopy.add(newWheel.clone());
        return new Car(year, color, wheelsCopy, (engine != null) ? engine.clone() : null);
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color
                + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}
