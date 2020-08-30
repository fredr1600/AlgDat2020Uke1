public class Ukesoppgaver1 {

    public static void main(String[] args) {

        int[] a = {8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};

        int min_index = min(a);

        System.out.println(min_index);
        System.out.println(a[min_index]);
    }

        // Avsnitt 1.1.2 Oppgave 2
        static int min(int[] a){
        // Initialiserer med første element
            int min_value = a[0];
            int min_index = 0;

        // Looper over alle resterende elementene og sjekker om vi finner et mindre tall
            for(int i = 1; i<a.length; i++){
                int value = a[i];
                int index = i;
        //sjekker om verdien er mindre enn det vi har sett tidligere
                if(value < min_value){
                    min_value = value;
                    min_index = index;
                }
            }
            //returnerer index til minste verdi
            return min_index;
        }

        //Avsnitt 1.1.3 Oppgave 5
        public static int[] minMaks(int[] a)
        {
            int mi = 0, min_verdi = a[0];
            int ma = 0, maks_verdi = a[0];

            int verdi = 0;

            for (int i = 1; i<a.length; i++){
                verdi = a[i];

                if(verdi > maks_verdi){
                    maks_verdi = verdi; ma = i;
                } else if (verdi < min_verdi){
                    min_verdi = verdi; mi = i;
                }
            }
            return new int[]{mi, ma};
        }
    }

