public class Oppgave115 {

    public static void main(String[] args) {
        int[] a = {3,6,7,8,4};

        int minindex = maks(a);

        System.out.println(minindex);

    }

    public static int maks(int[] a){
        int sist = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];

        for (int i = 0; ; i++){
            if(a[i] >= maksverdi){
                if(i == sist){
                    a[sist] = temp;
                    return temp >= maksverdi ? sist : m;
                }
                else{
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }
}
