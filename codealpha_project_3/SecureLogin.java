
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class SecureLogin {

    static byte[] salt;
    static byte[] passwordHash;

    // Generate secure password hash
    public static byte[] hashPassword(char[] password)
            throws Exception {

        PBEKeySpec spec =
                new PBEKeySpec(password, salt, 120000, 256);

        try {
            SecretKeyFactory factory =
                    SecretKeyFactory.getInstance(
                            "PBKDF2WithHmacSHA256"
                    );

            return factory.generateSecret(spec).getEncoded();

        } finally {
            spec.clearPassword();
        }
    }

    // Check password length
    public static boolean validatePassword(String password) {
        return password != null && password.length() >= 8;
    }

    // Verify entered password
    public static boolean verifyPassword(char[] password)
            throws Exception {

        byte[] enteredHash = hashPassword(password);

        return MessageDigest.isEqual(
                passwordHash, enteredHash
        );
    }

    // SQL Injection protection using PreparedStatement
    public static boolean findUser(
            Connection connection, String username)
            throws SQLException {

        String query =
                "SELECT username FROM users WHERE username = ?";

        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {

            statement.setString(1, username);

            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("===== SECURE LOGIN SYSTEM =====");

        // Registration
        System.out.print("Create Username: ");
        String username = input.nextLine();

        System.out.print("Create Password: ");
        char[] password = input.nextLine().toCharArray();

        if (!validatePassword(new String(password))) {
            System.out.println(
                    "Password must be at least 8 characters."
            );

            Arrays.fill(password, '\0');
            input.close();
            return;
        }

        // Generate random salt
        salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        // Store password hash
        passwordHash = hashPassword(password);

        Arrays.fill(password, '\0');

        System.out.println("\nRegistration Successful!");
        System.out.println("Password stored as a secure hash.");

        // Login
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter Password: ");
        char[] loginPassword = input.nextLine().toCharArray();

        if (loginUser.equals(username)
                && verifyPassword(loginPassword)) {

            System.out.println("\nLogin Successful!");

        } else {
            System.out.println("\nInvalid username or password!");
        }

        Arrays.fill(loginPassword, '\0');

        input.close();
    }
}