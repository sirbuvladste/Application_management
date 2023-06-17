package org.example;

import static org.example.Cerere.TipCerere.INLOCUIRE_BULETIN;
import static org.example.Cerere.TipCerere.INLOCUIRE_CARNET_ELEV;

public class Elev extends Utilizator {
    private final String scoala;

    public Elev(String nume, String scoala) {
        setType("elev");
        this.setNume(nume);
        this.scoala = scoala;
    }

    @Override
    String generareTextCerere(Cerere.TipCerere tipCerere) {
        if (tipCerere == INLOCUIRE_BULETIN) {
            return "Subsemnatul " + getNume() + ", elev la scoala " + scoala + ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";

        }
        if (tipCerere == INLOCUIRE_CARNET_ELEV) {
            return "Subsemnatul " + getNume() + ", elev la scoala " + scoala + ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de elev\n";
        }


        return null;
    }
}
