public class Program {

    public static void main(String[] args) {

        //Avsnitt 1.2.4 Oppgave 1
        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaks(a);

        int m = b[0], nm = b[1];

        Tabell.skriv(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

    }


}
