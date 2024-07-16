import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        String[][] fatherChild = {{"Karikalan", "Sendhan"}, {"Paari", "Karikalan"}, {"Udhiran", "Sendhan"}, {"Sendhan", "Arulmozhi"}};
        System.out.println("Enter the name: ");
        Scanner sc = new Scanner(System.in);
        
        int n = fatherChild.length;
        String greatFather = sc.nextLine();
        String father = "";
        String[] grandSons = {"", ""};
        int grandSonCount = 0;
        
        for(int i=0; i<n; i++)   {
            if(fatherChild[i][1].equals(greatFather))   {
                father = fatherChild[i][0];
                break;
            }
        }
        sc.close();

        if(father.equals(""))   {
            System.out.println("There is no son of " + greatFather);
            return;
        }
        for(int i=0; i<n; i++)   {
            if(fatherChild[i][1].equals(father))   {
                grandSons[grandSonCount++] = fatherChild[i][0];
            }
        }

        if(grandSonCount == 0)  {
            System.out.println("There is no grandsons for " + greatFather);
            return;
        }
        else   {
            for(String i:grandSons)    {
                if(!i.equals(""))   {
                    System.out.println(i);
                }
            }
        }
        
    } 
}
