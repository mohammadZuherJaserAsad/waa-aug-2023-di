import Reflection.Container;
import Reflection.MyDependencyInjector;
import Repositories.UserRepository;
import Services.UserService;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        UserService userService = new UserService();
        MyDependencyInjector dependencyInjector = new MyDependencyInjector(container);
        dependencyInjector.injectDependencies(userService);

        // Verify that the UserRepository dependency is properly injected
        userService.someUserServiceMethod();
    }
}
