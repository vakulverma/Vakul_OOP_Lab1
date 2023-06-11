import java.util.Random;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    public static final String COMPANY_NAME = "abc.com";
    public static final String[] DEPARTMENTS = {"Technical", "Admin", "HumanResource", "Legal"};

   public static String generatePassword() {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*";

        StringBuilder password = new StringBuilder();

        Random random = new Random();

        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        for (int i = 4; i < 8; i++) {
            String chars = lowercase + uppercase + numbers + specialChars;
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

 public static String generateEmailAddress(Employee employee, String department) {
       return employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + department + "." + COMPANY_NAME;
    }

    public static void showCredentials(Employee employee, String department) {
        String email = generateEmailAddress(employee, department);
        String password = generatePassword();

        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}

public class CredentialGeneration {
    public static void main(String[] args) {
        Employee employee = new Employee("Vakul", "verma");

        System.out.println("Please enter the department from the following:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");

        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();

        String department;
        switch (departmentChoice) {
            case 1:
                department = CredentialService.DEPARTMENTS[0];
                break;
            case 2:
                department = CredentialService.DEPARTMENTS[1];
                break;
            case 3:
                department = CredentialService.DEPARTMENTS[2];
                break;
            case 4:
                department = CredentialService.DEPARTMENTS[3];
                break;
            default:
                department = "Unknown";
                break;
        }

        CredentialService.showCredentials(employee, department);
    }
}
