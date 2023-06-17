package org.example;

import java.util.Comparator;

class BirouCereriComparator implements Comparator<Cerere> {
    public int compare(Cerere c1, Cerere c2) {
        if (c1.getPrioritate() == c2.getPrioritate()) {
            // compareTo da o valoarea pozitiva daca e mai mare, asa ca trebuie sa o fac negativa
            // pentru a o adauga de la cea mai veche data la cea mai noua
            return (c1.getDataCer()).compareTo(c2.getDataCer());
        } else return c2.getPrioritate() - c1.getPrioritate(); // e o val negativa daca prioritatea e mai mica
    }
}
