//Question 1
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 31, 11, 14, 5, 22, 3, 6};
        int n = arr.length;
        int k = 3;
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for(int i=0; i<n; i++)  {
//            arr[i] = sc.nextInt();
//        }
//
//        int k = sc.nextInt();

        for(int i=0; i<n-k+1; i++)    {
            int max = arr[i];
            for(int j = 0; j<k; j++)    {
                if(arr[i+j] > max)  max = arr[i+j];
            }
            System.out.print(max + " ");
        }

    }
}
