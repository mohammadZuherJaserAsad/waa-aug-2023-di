
import Reflection.*;
import Repositories.*;
import Services.*;

public class WaaAssignment1Application {

    public static void main(String[] args) {

        Container container = new Container();

        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        // injecting the dependencies into UserService::
        UserService userService = new UserService();
        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        // Verifying the injection by using the UserService:
        userService.performAction();

    }

}
