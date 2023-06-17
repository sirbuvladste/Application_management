package org.example;

import java.util.Comparator;

public class UserCereriComparator implements Comparator<Cerere> {
    public int compare(Cerere c1, Cerere c2) {
        return (c1.getDataCer()).compareTo(c2.getDataCer());
    }
}