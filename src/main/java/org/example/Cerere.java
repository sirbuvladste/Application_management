package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cerere {

    private String textCerere;
    private int prioritate;
    private Date dataCer;
    private Utilizator utilizator;

    private DateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    public Cerere(Utilizator utilizator, String data, String textCerere, int prioritate) throws ParseException {
        this.setDataCer(generareData(data));
        this.setTextCerere(textCerere);
        this.setPrioritate(prioritate);
        this.setUtilizator(utilizator);
    }

    public Date generareData(String data) throws ParseException {
        return getFormat().parse(data);
    }

    public String stringData() {
        return getFormat().format(getDataCer());
    }

    @Override
    public String toString() {
        return stringData() + " - " + getTextCerere();
    }

    public String getTextCerere() {
        return textCerere;
    }

    public void setTextCerere(String textCerere) {
        this.textCerere = textCerere;
    }

    public int getPrioritate() {
        return prioritate;
    }

    public void setPrioritate(int prioritate) {
        this.prioritate = prioritate;
    }

    public Date getDataCer() {
        return dataCer;
    }

    public void setDataCer(Date dataCer) {
        this.dataCer = dataCer;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public DateFormat getFormat() {
        return format;
    }

    public void setFormat(DateFormat format) {
        this.format = format;
    }

    public enum TipCerere {
        INLOCUIRE_BULETIN("inlocuire buletin"),
        INREGISTRARE_VENIT_SALARIAL("inregistrare venit salarial"),
        INLOCUIRE_CARNET_SOFER("inlocuire carnet de sofer"),
        INLOCUIRE_CARNET_ELEV("inlocuire carnet de elev"),
        CREARE_ACT_CONSTITUTIV("creare act constitutiv"),
        REINNOIRE_AUTORIZATIE("reinnoire autorizatie"),
        INREGISTRARE_CUPOANE_DE_PENSIE("inregistrare cupoane de pensie"),
        CERERE_GRESITA(null);

        private final String textTipCerere;
        TipCerere(String text){
            this.textTipCerere = text;
        }

        public String getTextTipCerere() {
            return textTipCerere;
        }

        public String getTipCerere() {
            return textTipCerere;
        }
    }

}

