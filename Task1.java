import java.util.Scanner;

public class Test1{
    public static void main(String[] args)  {
        //odd -> descending even -> ascending

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++)  {
            System.out.println("Enter the value: ");
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i+=2)   {
            for(int j=i+2; j<n; j+=2)   {
                if(arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        
        for(int i=1; i<n-1; i+=2)   {
            for(int j=i+2; j<n; j+=2)   {
                if(arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println("The output array is: ");
        for(int i: arr) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}
