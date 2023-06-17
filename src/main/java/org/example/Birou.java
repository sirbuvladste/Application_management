package org.example;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Birou<E extends Utilizator> {
    private TreeSet<Cerere> setCereriBirou;
    private HashSet<FunctionarPublic> setFunctionarPublic;

    public Birou() {
        this.setSetCereriBirou(new TreeSet<>(new BirouCereriComparator()));
        this.setSetFunctionarPublic(new HashSet<>());
    }

    public HashSet<FunctionarPublic> getSetFunctionarPublic() {
        return setFunctionarPublic;
    }

    public void setSetFunctionarPublic(HashSet<FunctionarPublic> setFunctionarPublic) {
        this.setFunctionarPublic = setFunctionarPublic;
    }

    public TreeSet<Cerere> getSetCereriBirou() {
        return setCereriBirou;
    }

    public void setSetCereriBirou(TreeSet<Cerere> setCereriBirou) {
        this.setCereriBirou = setCereriBirou;
    }
}
