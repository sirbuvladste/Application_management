package org.example;

import static org.example.Cerere.TipCerere.*;

public class Angajat extends Utilizator {
    private final String companie;

    public Angajat(String nume, String companie) {
        setType("angajat");
        this.setNume(nume);
        this.companie = companie;
    }

    @Override
    String generareTextCerere(Cerere.TipCerere tipCerere) {
        if (tipCerere == INLOCUIRE_BULETIN) {
            return "Subsemnatul " + getNume() + ", angajat la compania " + getCompanie() + ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire buletin\n";

        }
        if (tipCerere == INLOCUIRE_CARNET_SOFER) {
            return "Subsemnatul " + getNume() + ", angajat la compania " + getCompanie() + ", va rog sa-mi aprobati urmatoarea solicitare: inlocuire carnet de sofer\n";
        }
        if (tipCerere == INREGISTRARE_VENIT_SALARIAL) {
            return "Subsemnatul " + getNume() + ", angajat la compania " + getCompanie() + ", va rog sa-mi aprobati urmatoarea solicitare: inregistrare venit salarial\n";
        }

        return null;
    }

    public String getCompanie() {
        return companie;
    }
}
