package registration;

import citizen.facility.User;
import java.util.Map;

public interface Validation {
    Map<String, User> validateUser(String userName, String password);
}