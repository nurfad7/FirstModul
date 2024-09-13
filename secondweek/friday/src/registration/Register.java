package registration;

import citizen.facility.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Register implements Validation {
    protected List<User> users = new ArrayList<>();

    public abstract void addUser(User user);

    @Override
    public Map<String, User> validateUser(String userName, String password) {
        Map<String, User> validation = new HashMap<>();
        List<User> userExist = users.stream()
                .filter(person -> person.getUserName().equals(userName))
                .limit(1)
                .toList();
        if (userExist.isEmpty()) {
            validation.put("new", null);
        } else if (!userExist.getFirst().getPassword().equals(password)) {
            validation.put("wrong", null);
        } else {
            validation.put("registered", userExist.getFirst());
        }
        return validation;
    }
}
