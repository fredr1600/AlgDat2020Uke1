import java.util.Arrays;

public class Ukesoppgaver4 {

    public static void main(String[] args) {
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s

        System.out.println(a[k] + "  " + d[l] + "  " + s[m]);

        //Oppgave 1.4.1 2
        Character [] b = {'B', 'C', 'Å'};

        int u = Tabell.maks(b);
        System.out.println(b[u]);

        //Oppgave 1.4.1 2
        Integer[] o = {5,2,7,3,9,1,8,4,6};
        int h = Tabell.maks(o);
        System.out.println(o[h]);

        //Oppgave 1.4.1 4
        Integer w = 1;
        Integer q = 4;

        System.out.println(w.compareTo(q)); //Returnerer 1 om w er større enn q, 0 om like store og -1 om w er mindre enn q

        //Oppgave 1.4.2 1
        String[] aa = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int kk = Tabell.maks(aa);        // hvilken maks-metode?
        System.out.println(aa[kk]);      // Utskrift:  Thanh

        //Oppgave 1.4.2 2
        String[] ss = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(ss);
        System.out.println(Arrays.toString(ss));  // [Ali, Anne, Eva, Kari, Ole, Per]

        //Oppgave 1.4.3 6
        Integer[] aaa = Tabell.randPermInteger(10);
        System.out.println(Arrays.toString(aaa));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabell.innsettingssortering(aaa);
        System.out.println(Arrays.toString(aaa));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
