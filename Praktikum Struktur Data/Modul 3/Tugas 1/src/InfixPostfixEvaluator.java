
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class InfixPostfixEvaluator {

    // Kelas untuk menyimpan riwayat konversi
    static class ConversionHistory {

        String infix;
        String postfix;
        double result;

        public ConversionHistory(String infix, String postfix, double result) {
            this.infix = infix;
            this.postfix = postfix;
            this.result = result;
        }

        @Override
        public String toString() {
            return "Infix: " + infix + "\nPostfix: " + postfix + "\nHasil: " + result + "\n";
        }
    }

    // List untuk menyimpan riwayat
    private static List<ConversionHistory> history = new ArrayList<>();

    // Fungsi untuk menentukan prioritas operator
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Konversi infix ke postfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c).append(' ');
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    // Evaluasi ekspresi postfix
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "^":
                        result = Math.pow(operand1, operand2);
                        break;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    // Membersihkan input dari spasi berlebihan
    private static String cleanInput(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n=== MENU KONVERSI INFIX-POSTFIX ===");
            System.out.println("1. Konversi Infix ke Postfix");
            System.out.println("2. Evaluasi Ekspresi Postfix");
            System.out.println("3. Lihat Riwayat Konversi");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());S
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka antara 1-4!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("\nMasukkan ekspresi infix (contoh: 3 + 4 * 2 / (1 - 5)): ");
                    String infix = cleanInput(scanner.nextLine());

                    try {
                        String postfix = infixToPostfix(infix);
                        double result = evaluatePostfix(postfix);

                        history.add(new ConversionHistory(infix, postfix, result));

                        System.out.println("\nHasil Konversi:");
                        System.out.println("Infix: " + infix);
                        System.out.println("Postfix: " + postfix);
                        System.out.println("Hasil Evaluasi: " + result);
                    } catch (Exception e) {
                        System.out.println("Error: Ekspresi tidak valid!");
                    }
                    break;

                case 2:
                    System.out.print("\nMasukkan ekspresi postfix (contoh: 3 4 2 * 1 5 - / +): ");
                    String postfixInput = cleanInput(scanner.nextLine());

                    try {
                        double result = evaluatePostfix(postfixInput);
                        System.out.println("Hasil Evaluasi: " + result);
                    } catch (Exception e) {
                        System.out.println("Error: Ekspresi tidak valid!");
                    }
                    break;

                case 3:
                    System.out.println("\n=== RIWAYAT KONVERSI ===");
                    if (history.isEmpty()) {
                        System.out.println("Belum ada riwayat konversi.");
                    } else {
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println("[" + (i + 1) + "]");
                            System.out.println(history.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
