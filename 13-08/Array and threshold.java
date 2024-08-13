//Question 3
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int[] arr = {5, 8, 10, 13, 6, 2};
        int n = arr.length;
//        int[] arr = new int[n];
//
//        for(int i=0; i<n; i++)  {
//            arr[i] = sc.nextInt();
//        }
        int count = 0;
        //int threshold = sc.nextInt();
        int threshold = 3;
        for(int i: arr) {
            int temp = i;
            while(temp > 0) {
                temp -= threshold;
                count++;
            }
        }

        System.out.println(count);

    }
}
