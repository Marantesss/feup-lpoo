import java.util.ArrayList;
import java.util.List;

public class Bar {

    protected boolean happyHour;
    List<BarObserver> observers;

    Bar() {
        this.happyHour = false;
        this.observers = new ArrayList<>();
    }

    void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour())
                observer.happyHourStarted(this);
            else
                observer.happyHourEnded(this);
    }

    // ---- getters
    public boolean isHappyHour() {
        return happyHour;
    }

    // ---- setters
    public void startHappyHour() {
        this.happyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        this.happyHour = false;
        notifyObservers();
    }

    public void order(StringRecipe recipe) {
        recipe.mix();
    }
}
