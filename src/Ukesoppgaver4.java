import Eksempelklasser.*;

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

        //Oppgave 1.4.4 1B
        System.out.println("Oppgave 1.4.4 1B");
        int[] ø = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] å = new Heltall[ø.length];       // en Heltall-tabell

        for (int i = 0; i < å.length; i++) å[i] = new Heltall(ø[i]);
        Tabell.innsettingssortering(å);           // generisk sortering
        System.out.println(Arrays.toString(å));   // utskrift

        //Oppgave 1.4.4 1E
        System.out.println("Oppgave 1.4.4 1E");
        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        System.out.println(x.compareTo(y) + "  " + x.equals(y));

        //Oppgave 1.4.4 2B
        System.out.println("Oppgave 1.4.4 2B");
        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        int mmm = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        //Avsnitt 1.4.5

        for (Studium sss : Studium.values())
        {
            System.out.println(sss.toString() + " (" + sss.name() + ")");
        }

        //Avsnitt 1.4.6

        System.out.println("Oppgave 1.4.6 1");
        Person[] pp = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
        // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]

        System.out.println("Oppgave 1.4.6 3");

        for (Måned måned : Måned.values())
        {
            System.out.println(måned.fulltnavn() + " (" + måned.toString() + ")");
        }

        System.out.println("Oppgave 1.4.6 5");
        Student[] students = new Student[9];  // en Studenttabell

        students[0] = new Student("Kari", "Svendsen", Studium.Data);
        students[1] = new Student("Boris", "Zukanovic", Studium.IT);
        students[2] = new Student("Ali", "Kahn", Studium.Anvendt);
        students[3] = new Student("Azra", "Zukanovic", Studium.IT);
        students[4] = new Student("Kari", "Pettersen", Studium.Data);
        students[5] = new Student("Fredrik", "Thorsen", Studium.Elektro);
        students[6] = new Student("Jørgen", "Huseby", Studium.Elektro);
        students[7] = new Student("Jostein", "Hauge", Studium.Enkeltemne);
        students[8] = new Student("Felix", "Emhjellen", Studium.Enkeltemne);

        Tabell.innsettingssortering(students);                     // Programkode 1.4.2 e)
        for (Student t : students) System.out.println(t);

        System.out.println("Oppgave 1.4.7 2");

        Double[] digits = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        //Komparator<Double>
    }
}
