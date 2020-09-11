import java.util.Arrays;
import java.util.Random;

public class Tabell {


    public static int min(int[] a, int fra, int til){
        int m = fra;
        int min_value = a[fra];

        for (int i = fra +1; til < til; i++){
            if(a[i] < min_value){
                m = i;
                min_value = a[m];
            }
        }
        return m;
    }

    public static int min(int[] a){
        return min(a,0,a.length);
    }

    public static void bytt(int [] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n){
        Random r = new Random();  //Random-generator
        int[] a = new int[n];     // en tabell med plass til n tall

        Arrays.setAll(a, i->i+1);  //Legger inn tall

        for (int k = n-1;k>0;k--){ //Løkke som går n-1 ganger
            int i = r.nextInt(k+1);  //tilfeldig tall fra 0 til k
            bytt(a, k, i);    //bytter om
        }
        return a;
    }

    public static void randPerm(int [] a){
        Random r = new Random();

        for(int k = a.length -1; k>0;k--){
            int i = r.nextInt(k+1);
            bytt(a, k, i);
        }
    }

    public static int maks(int [] a, int fra, int til){

        //fratilKontroll();

        int m = fra;
        int maks_verdi = a[fra];

        for(int i = fra +1; i<til; i++){
            if (a[i] > maks_verdi){
                m = i;
                maks_verdi = a[m];
            }

        }

        return m;

    }

    public static int maks(int[] a){
        return maks(a, 0, a.length);
    }

    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

    public static void skriv(int[] a, int fra, int til){
        for (int i = fra; i < til; i++){
            System.out.print(i + " ");
        }
    }

    public static int skriv(int[] a){
        for (int k : a){
            System.out.print(k + " ");
        }

        return 0;
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static void utvalgssortering(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length));  // to hjelpemetoder
    }

    public static void utvalgssortering2(int[] a){

    }

    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk(a,0,a.length,verdi);  // bruker metoden over
    }

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }
    /*
    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } */

    static int maks(Character[] values){
        char current_max = values[0];
        int current_index = 0;

        for (int i = 0; i < values.length; i++){
            if(values[i] > current_max){
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    static int maks(Integer[] values){
        int current_max = values[0];
        int current_index = 0;

        for (int i = 0; i < values.length; i++){
            if(values[i] > current_max){
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static void skriv(Object[] a, int fra, int til) {
        for (int i = fra; i < til; i++) {
            System.out.print(i + " ");

        }
    }

    public static int skriv(Object[] a){
        for (Object k : a){
            System.out.print(k + " ");
        }

        return 0;
    }

    public static void bytt(Object [] a, int i, int j){
        Object temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

}

