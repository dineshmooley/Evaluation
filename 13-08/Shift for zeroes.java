//Question 6
import java.util.Arrays;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 0};
        int n = args.length;
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        for(int i=0; i<n; i++)  {
            if(i < n-1 && arr[i] == 0) {
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
