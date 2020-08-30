public class UkesOppgaver3 {

    public static void main(String[] args) {

        int[] a = {2,3,6,1,4,5};

        Tabell.nestePermutasjon(a);
        System.out.println(a);

        //Avsnitt 1.3.4 Oppgave 3
        Tabell.utvalgssortering(a);
        Tabell.skriv(a);

        //Avsnitt 1.3.5 Oppgave 2
        int[] b = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};
        System.out.println(Tabell.lineærsøk(a, 2));
        System.out.println(Tabell.lineærsøk(a, 15));
        System.out.println(Tabell.lineærsøk(a, 16));
        System.out.println(Tabell.lineærsøk(a, 40));
        System.out.println(Tabell.lineærsøk(a, 41));

        //Avsnitt 1.3.6 Oppgave 3
        int[] c = {1,3,4,4,5,7,7,7,7,8,9,10,10,12,15,15,15};
        System.out.println(Tabell.binærsøk(a, 4));
        System.out.println(Tabell.binærsøk(a, 7));
        System.out.println(Tabell.binærsøk(a, 10));
        System.out.println(Tabell.binærsøk(a, 15));




    }
}
