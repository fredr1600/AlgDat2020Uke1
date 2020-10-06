package Eksempelklasser;

public abstract class AbstraktBeholder<T> implements Beholder<T>
{
    public abstract boolean leggInn(T t);    // en abstrakt metode

    public boolean inneholder(T t)
    {
        return false;   // foreløpig kode
    }

    public boolean fjern(T t)
    {
        return false;   // foreløpig kode
    }

    public int antall()
    {
        return 0;   // foreløpig kode
    }

    public boolean tom()
    {
        return antall() == 0;   // ferdig kode
    }

    public void nullstill()
    {
        // foreløpig kode
    }

    //public abstract Iterator<T> iterator();    // en abstrakt metode

    public String toString()
    {
        return null;   // foreløpig kode
    }
}