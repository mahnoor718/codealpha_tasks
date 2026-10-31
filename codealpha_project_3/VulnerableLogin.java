import java.util.Scanner;

public class VulnerableLogin {

    // Insecure: Hardcoded credentials
    static String username = "admin";
    static String password = "12345";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== VULNERABLE LOGIN SYSTEM =====");

        System.out.print("Enter Username: ");
        String user = input.nextLine();

        System.out.print("Enter Password: ");
        String pass = input.nextLine();

        // Insecure: SQL query using string concatenation
        String query = "SELECT * FROM users WHERE username = '"
                + user + "' AND password = '" + pass + "'";

        System.out.println("\nGenerated SQL Query:");
        System.out.println(query);

        // Insecure: Weak password validation
        if (pass.length() < 4) {
            System.out.println("Password is too short!");
        }

        // Insecure: Plain-text password comparison
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("\nLogin Successful!");
        } else {
            System.out.println("\nInvalid username or password!");
        }

        input.close();
    }
}