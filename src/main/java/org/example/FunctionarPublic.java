package org.example;


class FunctionarPublic {
    private String nume;
    private String tipBirou;
    // private TreeSet<Cerere> setCereriRezolvate;

    public FunctionarPublic(String nume, String tipBirou) {
        // this.setSetCereriRezolvate(new TreeSet<>(new BirouCereriComparator()));
        this.setNume(nume);
        this.setTipBirou(tipBirou);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTipBirou() {
        return tipBirou;
    }

    public void setTipBirou(String tipBirou) {
        this.tipBirou = tipBirou;
    }

//    public TreeSet<Cerere> getSetCereriRezolvate() {
//        return setCereriRezolvate;
//    }
//
//    public void setSetCereriRezolvate(TreeSet<Cerere> setCereriRezolvate) {
//        this.setCereriRezolvate = setCereriRezolvate;
//    }
}