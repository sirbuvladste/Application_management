package org.example;

import java.util.Comparator;
import java.util.TreeSet;

public abstract class Utilizator {

    private String type;
    private String nume;
    private TreeSet<Cerere> cereriAsteptare;
    private TreeSet<Cerere> cereriFinalizate;

    public Utilizator() {
        setCereriAsteptare(new TreeSet<Cerere>(new UserCereriComparator()));
        setCereriFinalizate(new TreeSet<Cerere>(new UserCereriComparator()));
    }

    abstract String generareTextCerere(Cerere.TipCerere tipCerere);

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public TreeSet<Cerere> getCereriAsteptare() {
        return cereriAsteptare;
    }

    public void setCereriAsteptare(TreeSet<Cerere> cereriAsteptare) {
        this.cereriAsteptare = cereriAsteptare;
    }

    public TreeSet<Cerere> getCereriFinalizate() {
        return cereriFinalizate;
    }

    public void setCereriFinalizate(TreeSet<Cerere> cereriFinalizate) {
        this.cereriFinalizate = cereriFinalizate;
    }
}

