package Eksempelklasser;

public enum Måned {
    Jan("Januar", 1),
    Feb("Februar", 2),
    Mar("Mars", 3),
    Apr("April", 4),
    Mai("Mai", 5),
    Jun("Juni", 6),
    Jul("Juli", 7),
    Aug("August", 8),
    Sep("September", 9),
    Okt("Oktober", 10),
    Nov("November", 11),
    Des("Desember", 12);



    private final String fulltnavn;
    private final int mndnr;

    private Måned(String fulltnavn, int mndr) {
        this.fulltnavn = fulltnavn;
        this.mndnr = mndr;
    }

    public String fulltnavn(){
        return fulltnavn;
    }

    public static int toString(int mndnr) {
       return mndnr;
    }

    public static Måned[] vår(){
        Måned[] vår = {Apr, Mai};
        return vår;
    }

    public static Måned[] sommer(){
        Måned[] sommer = {Jun, Jul, Aug};
        return sommer;
    }

    public static Måned[] høst(){
        Måned[] høst = {Sep, Okt};
        return høst;
    }

    public static Måned[] vinter(){
        Måned[] vinter = {Nov, Des, Jan, Feb, Mar};
        return vinter;
    }


}

