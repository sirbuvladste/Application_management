package org.example;

import static org.example.Cerere.TipCerere.*;

public class Pensionar extends Utilizator {

    public Pensionar(String nume) {
        setType("pensionar");
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
        if (tipCerere == INREGISTRARE_CUPOANE_DE_PENSIE) {
            return "Subsemnatul " + getNume() + ", va rog sa-mi aprobati urmatoarea solicitare: inregistrare cupoane de pensie\n";
        }

        return null;
    }
}
