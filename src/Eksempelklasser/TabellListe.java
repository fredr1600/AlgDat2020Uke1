package Eksempelklasser;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class TabellListe<T> implements Liste<T>
{
    private T[] a;
    private int antall;

    // konstruktører og metoder kommer her

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse)       // konstruktør
    {
        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe()                    // standardkonstruktør
    {
        this(10);                             // startstørrelse på 10
    }

    public int antall()
    {
        return antall;          // returnerer antallet
    }

    public boolean tom()
    {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }

    public int indeksTil(T verdi)
    {
        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }

    // Skal ligge som en indre klasse i class TabellListe
    private class TabellListeIterator implements Iterator<T>
    {
        private int denne = 0;       // instansvariabel

        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        public T next()              // returnerer aktuell verdi
        {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
            return a[denne++]; // a[denne] returneres før denne++
        }
    }  // TabellListeIterator

    public Iterator<T> iterator()
    {
        return new TabellListeIterator();
    }


}
