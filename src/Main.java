public class Main {
    public static void main(String[] args) {
        String login = "SkyPro_Student";
        String password = "StrongPassword";
        String confirmPassword = "StrongPassword";

        try {
            accountChecker(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(ANSI_RED + e + " - Wrong login information");
        } catch (WrongPasswordException e) {
            System.out.println(ANSI_RED + e + " - Wrong password information");
        } finally {
            System.out.println(ANSI_YELLOW + "Your inputs" + "\n" +
                    "Login: " + login + "\n" +
                    "Password: " + password + "\n" +
                    "Confirm Password: " + confirmPassword);
        }
    }

    public static void accountChecker(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("\\w+") || login.length() > 20) {
            throw new WrongLoginException();
        }

        if (!password.equals(confirmPassword) || !password.matches("\\w+") || password.length() > 20) {
            throw new WrongPasswordException();
        }

    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
}