import java.lang.reflect.Array;
import java.util.Arrays;

public class VisitorPatternTest {

    public static class Person {
        String first_name;
        String last_name;

        Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public String toString() {
            return first_name + " " + last_name;

        }
    }

    //Et interface - det lover at alle klasser som implementerer dette
    //har de foreskrevne funksjonene
    @FunctionalInterface
    public interface Komparator<T> {
        int compare(T a, T b);
    }

    public static class AscendingPersonComparator implements Komparator<Person> {

        public int compare(Person a, Person b) {
            int last_compare = b.last_name.compareTo(a.last_name);
            if (last_compare == 0) {
                return b.first_name.compareTo(a.first_name);
            } else {
                return last_compare;
            }
        }
    }

    public static class DescendingPersonComparator implements Komparator<Person> {

        public int compare(Person a, Person b) {
            int last_compare = a.last_name.compareTo(b.last_name);
            if (last_compare == 0) {
                return a.first_name.compareTo(b.first_name);
            } else {
                return last_compare;
            }
        }
    }

    public static class OddePartallKomparator
            implements Komparator<Integer> {
        public int compare(Integer a, Integer b) {
            //Først sammenlikn "etternavnet" => partall eller oddetall
            //Begge er partall eller begge er oddetall
            if (a % 2 == b % 2) {
                return a.compareTo(b);
            }
            //A er oddetall, b er partall
            else if (a % 2 > b % 2) {
                return 1;
            }
            //B er oddetall, a er partall
            else if (b % 2 > a % 2) {
                return -1;
            }
            //not a number, infinity etc, Burde kaste exception
            return 0;
        }
    }


    /*
    Denne funksjonen finner største verdi i values.
    Bruker sammenlikningsfunksjonen i objektet comp for sammenlikning
     */

    public static <T> int maks(T[] values, int begin, int end, Komparator<T> comp){
        T current_max = values[begin];
        int current_index = begin;

        for (int i = begin+1; i < end; i++){
            // if(values[i] > current_max){
            if (comp.compare(values[i], current_max) > 0){
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    public static <T> void sort(T[] values, Komparator<T> comp){
        //Looper over alle untatt siste element
        for(int i = 0; i< values.length-1; i++) {
            //Finn største element i intervallet[i, a.lenght)
            int max_index = maks(values, i, values.length, comp);
            //bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[max_index];
            values[max_index] = temp;

            //fortsett
        }
    }

    public static void main(String[] args) {

        Person[] persons = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen")};

        //0 Lag comparator-objektet
        //Vi kan nå kjøre comp.compare(a,b)
        AscendingPersonComparator comp_asc = new AscendingPersonComparator();
        DescendingPersonComparator comp_des = new DescendingPersonComparator();

        //1 Lag funksjonen som tar inn både person-arrayet og en sammenlikningsfunksjon
        System.out.println("Før sortering: "+Arrays.toString(persons));
        System.out.println("Sorterer");

        sort(persons, comp_asc);
        System.out.println("Etter sortering ascending : "+Arrays.toString(persons));

        sort(persons, comp_des);
        System.out.println("Etter sortering descending : "+Arrays.toString(persons));

        Integer integers[] = {9,8,7,6,5,4,3,2,1,0};
        //Vil sortere slik at vi får oddetall til venstre og oddetall til høyre
        //De skal være innbyrdes sortert
        OddePartallKomparator odd_partall = new OddePartallKomparator();
        System.out.println("Før sortering : "+Arrays.toString(integers));
        sort(integers, odd_partall);
        System.out.println("Etter sortering "+Arrays.toString(integers));

        //Hva skal noe være?
        //Partall og oddetalls-sjekk
        //Skille mellom partall og oddetall
        //Tanke: Bruke er det partall som etternavn og så størrelse på tallet som fornavn
        //Noe må være en Komparator<T>
    }
}
