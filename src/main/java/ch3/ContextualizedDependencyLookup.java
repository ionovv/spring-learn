package ch3;

/**
 * Created by vionov on 19.06.2017.
 */
public class ContextualizedDependencyLookup implements ManagedComponent{
        private Dependency dependency;

        @Override
        public void performLookup(Container container) {
            this.dependency = (Dependency) container.getDependency("myDependency");
        }

        @Override
        public String toString() {
            return dependency.toString();
        }
}
