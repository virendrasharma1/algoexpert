package recursion;

public class nthFibonacci {

    public static int getNthFibIterative(int n) {
        // Write your code here.
        int firstNumber = 0;
        int secondNumber = 1;

        if (n == 1) return 0;
        int latestNumber = secondNumber;
        int loop = 2;
        while (loop < n) {
            latestNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = latestNumber;
            loop++;
        }

        return latestNumber;
    }

    public static int getNthRecursive(int n) {
        if (n==2) {
            return 1;
        } else if (n==1) {
            return 0;
        } else {
            return getNthFibIterative(n-1) + getNthFibIterative(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNthRecursive(6));
    }
}
