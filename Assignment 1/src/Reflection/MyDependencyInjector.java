package Reflection;
import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private final Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }


    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = container.getDependency(fieldType);

                if (dependency != null) {
                    field.setAccessible(true);
                    try {
                        field.set(target, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("Dependency not found for field: " + field.getName());
                }
            }
        }
    }
}
