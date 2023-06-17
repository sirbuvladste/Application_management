package org.example;

import static org.example.Cerere.TipCerere.INLOCUIRE_BULETIN;
import static org.example.Cerere.TipCerere.INLOCUIRE_CARNET_SOFER;

public class Persoana extends Utilizator {
    public Persoana(String nume) {
        setType("persoana");
        this.setNume(nume);
    }

    @Override
    String generareTextCerere(Cerere.TipCerere tipCerere) {
        if (tipCerere == INLOCUIRE_BULETIN) {
            return "Subsemnatul " + getNume() + ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";

        }
        if (tipCerere == INLOCUIRE_CARNET_SOFER) {
            return "Subsemnatul " + getNume() + ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de sofer\n";
        }
        return null;
    }
}
