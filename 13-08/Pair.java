//Question 5
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for(int i=0; i<n; i++)  {
//            arr[i] = sc.nextInt();
//        }

        int xor = 0;
        for(int i: arr) {
            xor ^= i;
        }

        System.out.println(xor == 0);
    }
}
