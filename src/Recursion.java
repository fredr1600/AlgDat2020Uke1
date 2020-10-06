public class Recursion {

    public static void main(String[] args) {
        int value = 15;
        int return_value = recursiveFunction(value);
        System.out.println("Main: "+return_value);

        //5! = 5*4*3*2*1
        int five_factorial = factorial(5);
        System.out.println("5! = " + five_factorial);
        System.out.println("8! = "+factorial(8));
    }

    //This function calculates n! using a recursive function call
    static int factorial(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }

    static int recursiveFunction(int value){
        System.out.println("Recursive function: "+value);

        if(value <= 5){
            return -9;
        }
        else{
            return recursiveFunction(value-1);

        }
    }
}
