//Question 4
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = sc.next();
        System.out.println("Enter the second string");
        String str2 = sc.next();

        int count = 0;
        int n = str1.length(), m = str2.length();
        for (int i = 0; i < n; i++) {
            if(count == m)  {
                System.out.println(i-m);
                return;
            }
            if(str1.charAt(i) == str2.charAt(count))    {
                count++;
            }
            else count = 0;
        }

        if(count == m) System.out.println(n-m);
        else System.out.println(-1);
    }
}
