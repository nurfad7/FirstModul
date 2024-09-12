package registration;

import entity.User;
import java.util.Map;

public interface Validation {
    Map<String, User> validateUser(String userName, String password);
}
