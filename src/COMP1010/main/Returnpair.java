package COMP1010.main;
public class Returnpair {
    public String name;
    public int num;
    public StatMod stat1;

    public Returnpair(String name, int num) {
        this.name = name;
        this.num = num;
    }
    public Returnpair(String name, StatMod stat1) {
        this.name = name;
        this.stat1 = stat1;
    }
}
