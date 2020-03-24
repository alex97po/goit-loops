import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = validator(scanner);
//        String input = "1 2 3 4 5";
//        String[] arr = input.split(" ");
//        Integer res = Integer.parseInt(arr[0]);
    }

    private static int validator(Scanner scanner) {
        String res = scanner.nextLine();
        while (!res.matches("^[0-9]*$")) {
            System.out.println("WRONG!");
            System.out.println("Type: ");
            res = scanner.nextLine();
        }
        return Integer.parseInt(res);
    }

    private int oddOne(int[] input) {
        int result = 0;
        // O(n) * O(n) = O(n2)
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    result = input[i];
                    break;
                }
            }
        }

        //O(n)
        //O(1) - input[i]
        int expectedSum = 0;
        int actualSum = 0;
        for (int i = 0; i < input.length; i++) {
            actualSum += input[i];
            expectedSum += i;
        }
        return actualSum - expectedSum;
    }

    private static boolean pallindrom(Integer input) {
        //12321 - true % 10
        //123321 - true
        //12331 - false
        String inputStr = input.toString();
        char[] inputChars = inputStr.toCharArray();
        int cursor = inputChars.length-1;
        for (int i = 0; i < inputChars.length / 2; i++) {
            if (inputChars[i] != inputChars[cursor]) {
                return false;
            }
            cursor--;
        }
        return true;
    }

    private static int fibonacci(int number) {
        // 1, 1, 2, 3, 5, 8, 13
//        int currentElement = 1;
//        int fibo1 = 1;
//        int fibo2 = 1;
//        if (number == 1) {
//            return fibo1;
//        } else if (number == 2) {
//            return fibo2;
//        } else {
//            for (int i = 3; i <= number; i++) {
//                currentElement = fibo1 + fibo2;
//                fibo1 = fibo2;
//                fibo2 = currentElement;
//            }
//        }
//        return currentElement;
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number-2);
    }

    private static int[] lightConfiguration(int[] input, int days) {
        //   0, 1, 0, 1, 0, 1\
        //0, 1, 0, 1, 0, 0, 1, 0

        int[] result = new int[input.length];
        int[] inputCopy = Arrays.copyOf(input, input.length);
        for (int j = 1; j <= days; j++) {
            result[0] = inputCopy[1] == 1 ? 0 : 1; // first output element
            //loop for second till last-1 element
            for (int i = 1; i < inputCopy.length - 1; i++) {
                result[i] = inputCopy[i-1] == inputCopy[i+1] ? 1 : 0;
            }
            result[input.length-1] = inputCopy[input.length-2] == 1 ? 0 : 1; // last output element
            inputCopy = Arrays.copyOf(result, result.length);
        }
        return result;
    }
}
