/**
 * @author hudson
 *
 */
public class Console {
    public static String readLine() {
        return System.console().readLine();
    }

    public static String readLine(String prompt) {
        Console.printPrompt(prompt);

        return Console.readLine();
    }

    public static int readInt(String prompt) {
        return Integer.parseInt(prompt);
    }

    public static long readLong(String prompt) {
        return Long.parseLong(prompt);
    }

    public static double readDouble(String prompt) {
        return Double.parseDouble(prompt);
    }

    public static String readString(String prompt) {
        return prompt;
    }

    public static void printPrompt(String prompt) {
        System.out.println(prompt);
    }
}
