import java.util.Scanner;

public class Test2 {
    public static String numberToWord(int number) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tentotwen = {"ten", "eleven", "twelve", "thirtheen", "fourtheen", "fiftheen", "Sixtheen", "seventheen", "eighteen", "ninetheen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] thousands = {"", "thousand"};

        if (number < 10)    return ones[number];
        else if (number < 20)   return tentotwen[number % 10];   
        else if (number < 100)  return tens[number / 10] + (number % 10 == 0 ? "" : " " + ones[number % 10]);
        else if (number < 1000) return ones[number / 100] + " hundred " + (number % 100 == 0 ? "" : numberToWord(number % 100));
        else {
            int i = 0;
            while (number >= 1000) {
                int thousandsPart = number / 1000;
                number %= 1000;
                if (thousandsPart > 0) {
                    return numberToWord(thousandsPart) + " thousand and" + thousands[i] + (number > 0 ? " " + numberToWord(number) : "");
                }
                i++;
            }
            return numberToWord(number);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number :");
        int number = sc.nextInt();
        System.out.println(numberToWord(number));
        sc.close();
    }
}
