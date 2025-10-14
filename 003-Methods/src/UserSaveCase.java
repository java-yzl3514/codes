import java.time.LocalDate;

/**
 * @author Onder Sahin
 */

class User{
    String firstName;
    String middleName;
    String lastName;
    String phone;
    String email;
    LocalDate birthDate;
    String address;

}

public class UserSaveCase {

    public static void main(String[] args) {

        User user = new User();
        user.firstName = "John";
        user.middleName = "M.";
        user.lastName = "Doe";
        user.phone = "00000000";
        user.email = "john.doe@example.com";
        user.birthDate = LocalDate.of(1987, 1, 1);
        user.address = "Istanbul";

        save(user);
        save("John", "M.", "Doe", "john.doe@example.com", "000000", LocalDate.of(1987,1,1),"Istanbul");

    }

    public static void save(String firstName, String middleName, String lastName, String email, String phone, LocalDate birthDate, String address) {
        // ....
    }


    public static void save(User user) {
        // TODO : save user code
    }


}
