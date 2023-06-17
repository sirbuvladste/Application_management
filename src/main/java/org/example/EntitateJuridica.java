package org.example;

import static org.example.Cerere.TipCerere.CREARE_ACT_CONSTITUTIV;
import static org.example.Cerere.TipCerere.REINNOIRE_AUTORIZATIE;

public class EntitateJuridica extends Utilizator {
    private final String reprezentant;

    public EntitateJuridica(String nume, String reprezentant) {
        setType("entitate juridica");
        this.setNume(nume);
        this.reprezentant = reprezentant;
    }

    @Override
    String generareTextCerere(Cerere.TipCerere tipCerere) {
        if (tipCerere == CREARE_ACT_CONSTITUTIV) {
            return "Subsemnatul " + getReprezentant() + ", reprezentant legal al companiei " + getNume() + ", va rog sa-mi aprobati urmatoarea solicitare: creare act constitutiv\n";

        }
        if (tipCerere == REINNOIRE_AUTORIZATIE) {
            return "Subsemnatul " + getReprezentant() + ", reprezentant legal al companiei " + getNume() + ", va rog sa-mi aprobati urmatoarea solicitare: reinnoire autorizatie\n";
        }

        return null;
    }

    public String getReprezentant() {
        return reprezentant;
    }
}
