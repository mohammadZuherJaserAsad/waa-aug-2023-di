package Reflection;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<Class<?>, Object> dependencies;

    public Container() {
        dependencies = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz, Object dependency) {
        dependencies.put(clazz, dependency);
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
