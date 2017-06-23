package ch3;

/**
 * Created by vionov on 19.06.2017.
 */
public class Setterinjection {
    private Dependency dependency;

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
