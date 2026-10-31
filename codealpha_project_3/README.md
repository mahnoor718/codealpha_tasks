# SecureCode Analyzer

**CodeAlpha Cyber Security Internship – Task 3**

## About the Project
SecureCode Analyzer is a Java-based educational project that demonstrates common security vulnerabilities in login systems and shows how secure coding practices can help prevent them.

## Technologies Used
- Java
- IntelliJ IDEA
- JDK 24
- Java Security Libraries
- JDBC API

## Project Files

| File | Description |
|---|---|
| VulnerableLogin.java | Demonstrates insecure coding practices. |
| SecureLogin.java | Demonstrates improved security techniques. |

## Security Issues Demonstrated
1. Hardcoded credentials
2. Plain-text password handling
3. SQL Injection risk
4. Weak password validation

## Security Improvements
- PBKDF2 password hashing
- Random salt generation
- PreparedStatement for parameterized SQL queries
- Password length validation
- Secure password hash comparison

## How to Run
1. Open the project in IntelliJ IDEA.
2. Open `VulnerableLogin.java` or `SecureLogin.java`.
3. Run the selected Java file.
4. Follow the console instructions.

## Project Limitations
- No database is connected.
- Password hashes are stored temporarily in memory.
- PreparedStatement is demonstrated separately and is not integrated into the login flow.
- This is an educational demonstration, not a production-ready authentication system.

## Author
**Mahnoor**

Software Engineering Student

## Conclusion
This project demonstrates the importance of identifying security vulnerabilities and applying secure coding practices in Java applications.
