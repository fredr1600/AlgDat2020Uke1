public class TowerOfHanoi {

    public static void main(String[] args) {
        towerOfHanoi('A','B','C',4);

    }

    /**
     * Solves tower of hanoi puzzle
     * @param A Pinnen vi starter på
     * @param B Hjelpepinne
     * @param C Pinnen vi slutter på
     */

    public static void towerOfHanoi(char A, char B, char C, int brikkenr){


        if(brikkenr == 0){
            return;
        }

        //Flytt alle untatt nederste fra A til B
        towerOfHanoi(A, C, B, brikkenr-1);


        //Flytt nederste fra A til C
        System.out.println("Flytter brikke " +brikkenr+" fra "+A+" til "+C);

        //Flytt alle fra B til C
        towerOfHanoi(B, A, C, brikkenr-1);

    }

}
