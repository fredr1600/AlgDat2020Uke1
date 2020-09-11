public class TenaryIF {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++){
            int a = i;
            int b = myTenaryIfTest(a);
            System.out.println(b);

        }

        int a = 17;
        int b = (a < 5) ? 13 : 17;

    }

    public static int myTenaryIfTest(int value){

        /*
        if(value < 5){
            return 0;
        }
        else{
            return 98;
        } */

        return(value < 5) ? 0: 98;

    }


}
