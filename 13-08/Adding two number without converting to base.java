//Question 2
import java.util.Scanner;

public class Assignment {

    static int pow(int n, int x)   {
        int ans = 1;
        for(int i=0; i<x; i++)  {
            ans *= n;
        }
        return ans;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int n1 = sc.nextInt();
        System.out.println("Enter the second number");
        int n2 = sc.nextInt();
        System.out.println("Enter the base number");
        int base = sc.nextInt();

        int result = 0;
        int sum = n1 + n2;
        int carry = 0;
        int count = 0;

        while(sum > 0)  {
            int total = sum % 10 + carry;
            result = (total % base) * pow(10, count) + result;
            if(total >= base)    carry = 1;
            else carry = 0;
            sum /= 10;
            count+=1;
        }
        if(carry == 1) result = pow(10, count) + result;

        System.out.println(result);
    }
}
