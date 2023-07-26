package Services;


import Reflection.Inject;
import Repositories.UserRepository;

public class UserService {
    @Inject
    private UserRepository userRepository;

    public void someUserServiceMethod() {
        // Method logic using userRepository
        System.out.println("Some UserService method executed.");
        userRepository.someUserRepositoryMethod();
    }
    public void performAction(){

    }
}

