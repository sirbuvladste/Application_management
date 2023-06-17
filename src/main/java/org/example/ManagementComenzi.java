package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;

import static org.example.Cerere.TipCerere.*;

public class ManagementComenzi extends ManagementPrimarie {
    private BufferedWriter bufferOuput;

    public ManagementComenzi(String numeOutput) throws IOException {
        setBufferOuput(new BufferedWriter(new FileWriter(numeOutput)));
    }

    public void CloseBufferOutput() throws IOException {
        getBufferOuput().close();
    }

    public Utilizator adaugaUtilizator(String[] param) {
        if ("persoana".equals(param[1]))
            return new Persoana(param[2]);

        if ("angajat".equals(param[1]))
            return new Angajat(param[2], param[3]);

        if ("pensionar".equals(param[1]))
            return new Pensionar(param[2]);

        if ("elev".equals(param[1]))
            return new Elev(param[2], param[3]);

        if ("entitate juridica".equals(param[1]))
            return new EntitateJuridica(param[2], param[3]);

        return null;
    }

    public void creareCerereNoua(String[] param, HashSet<Utilizator> setUtilizatori) {
        String numeUtilizator = param[1];

        for (Utilizator util : setUtilizatori) {
            if (util.getNume().equals(numeUtilizator)) {
                String cerereStr = param[2];
                try {
                    Cerere.TipCerere tipCerere = verificareCerere(util, cerereStr);
                    if (tipCerere != CERERE_GRESITA) {
                        String textCerere = util.generareTextCerere(tipCerere);
                        Cerere cerereNoua = new Cerere(util, param[3], textCerere, Integer.parseInt(param[4]));

                        util.getCereriAsteptare().add(cerereNoua); // adaug cererea la utilizator

                        switch (util.getType()) {
                            case "persoana":
                                bPersoana.getSetCereriBirou().add(cerereNoua);
                                break;
                            case "angajat":
                                bAngajat.getSetCereriBirou().add(cerereNoua);
                                break;
                            case "pensionar":
                                bPensionar.getSetCereriBirou().add(cerereNoua);
                                break;
                            case "elev":
                                bElev.getSetCereriBirou().add(cerereNoua);
                                break;
                            case "entitate juridica":
                                bEntitateJuridica.getSetCereriBirou().add(cerereNoua);
                                break;
                            default:
                                break;
                        }

                    } else {
                        throw new ExceptieTipCerere(util.getType(), cerereStr);
                    }
                } catch (ExceptieTipCerere e) {
                    try {
                        getBufferOuput().write(e.textExceptie);
                    } catch (IOException e2) {
                        throw new RuntimeException(e);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public Cerere.TipCerere verificareCerere(Utilizator utilizator, String cerere) {
        switch (utilizator.getType()) {
            case "persoana":
                switch (cerere) {
                    case "inlocuire buletin":
                        return INLOCUIRE_BULETIN;
                    case "inlocuire carnet de sofer":
                        return INLOCUIRE_CARNET_SOFER;
                    default:
                        return CERERE_GRESITA;
                }
            case "angajat":
                switch (cerere) {
                    case "inlocuire buletin":
                        return INLOCUIRE_BULETIN;
                    case "inlocuire carnet de sofer":
                        return INLOCUIRE_CARNET_SOFER;
                    case "inregistrare venit salarial":
                        return INREGISTRARE_VENIT_SALARIAL;
                    default:
                        return CERERE_GRESITA;
                }
            case "pensionar":
                switch (cerere) {
                    case "inlocuire buletin":
                        return INLOCUIRE_BULETIN;
                    case "inlocuire carnet de sofer":
                        return INLOCUIRE_CARNET_SOFER;
                    case "inregistrare cupoane de pensie":
                        return INREGISTRARE_CUPOANE_DE_PENSIE;
                    default:
                        return CERERE_GRESITA;
                }
            case "entitate juridica":
                switch (cerere) {
                    case "creare act constitutiv":
                        return CREARE_ACT_CONSTITUTIV;
                    case "reinnoire autorizatie":
                        return REINNOIRE_AUTORIZATIE;
                    default:
                        return CERERE_GRESITA;
                }
            case "elev":
                switch (cerere) {
                    case "inlocuire buletin":
                        return INLOCUIRE_BULETIN;
                    case "inlocuire carnet de elev":
                        return INLOCUIRE_CARNET_ELEV;
                    default:
                        return CERERE_GRESITA;
                }
            default:
                return CERERE_GRESITA;
        }

    }

    public void afisareCereriAsteptareUtilizator(String numeUtilizator, HashSet<Utilizator> setUtilizatori) {
        for (Utilizator util : setUtilizatori) {
            if (util.getNume().equals(numeUtilizator)) {
                try {
                    getBufferOuput().write(util.getNume() + " - cereri in asteptare:\n");
                    for (Cerere cerere : util.getCereriAsteptare()) {
                        getBufferOuput().write(cerere.toString());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void afisareCereriFinalizateUtilizator(String numeUtilizator, HashSet<Utilizator> setUtilizatori) {
        for (Utilizator util : setUtilizatori) {
            if (util.getNume().equals(numeUtilizator)) {
                try {
                    getBufferOuput().write(util.getNume() + " - cereri in finalizate:\n");
                    for (Cerere cerere : util.getCereriFinalizate()) {
                        getBufferOuput().write(cerere.toString());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void afisareCereriBirou(String tipBirou) throws IOException {
        getBufferOuput().write(tipBirou + " - cereri in birou:\n");
        switch (tipBirou) {
            case "persoana":
                for (Cerere cerere : bPersoana.getSetCereriBirou()) {
                    getBufferOuput().write(cerere.getPrioritate() + " - " + cerere);
                }
                break;
            case "angajat":
                for (Cerere cerere : bAngajat.getSetCereriBirou()) {
                    getBufferOuput().write(cerere.getPrioritate() + " - " + cerere);
                }
                break;
            case "pensionar":
                for (Cerere cerere : bPensionar.getSetCereriBirou()) {
                    getBufferOuput().write(cerere.getPrioritate() + " - " + cerere);
                }
                break;
            case "elev":
                for (Cerere cerere : bElev.getSetCereriBirou()) {
                    getBufferOuput().write(cerere.getPrioritate() + " - " + cerere);
                }
                break;
            case "entitate juridica":
                for (Cerere cerere : bEntitateJuridica.getSetCereriBirou()) {
                    getBufferOuput().write(cerere.getPrioritate() + " - " + cerere);
                }
                break;
            default:
                break;
        }

    }

    /**
     * Metoda care pentru rezolvarea unei cereri. Sterge cererea din setul de asteptare a utilizatorului si
     * din cererile biroului. Adauga cererea in setul de finalizate ale utilizatorului si in setul functionarului
     * care a rezolvat-o, care dupa se afiseaa in fisierul respectiv.
     *
     * @param tipBirou       - tipul de birou din care se rezolva cererea
     * @param numeFunctionar - numele functionarului care rezolva cererea
     */
    public void rezolvaCerere(String tipBirou, String numeFunctionar) {
        FunctionarPublic functionarPublic = null;
        Birou<?> birou = null;
        Cerere cerereRezolvata;
        Utilizator utilizator;

        switch (tipBirou) {
            case "persoana":
                birou = bPersoana;
                break;
            case "angajat":
                birou = bAngajat;
                break;
            case "pensionar":
                birou = bPensionar;
                break;
            case "elev":
                birou = bElev;
                break;
            case "entitate juridica":
                birou = bEntitateJuridica;
                break;
            default:
                break;
        }

        // iau functionarul din birou
        try {
            assert birou != null;
            for (FunctionarPublic fP : birou.getSetFunctionarPublic()) {
                if (fP.getNume().equals(numeFunctionar)) {
                    functionarPublic = fP;
                    break;
                }
            }
            if (functionarPublic == null)
                throw new ExceptieFunctionarNuExista();
        } catch (ExceptieFunctionarNuExista e) {
            return;
        }

        cerereRezolvata = birou.getSetCereriBirou().first();

        utilizator = cerereRezolvata.getUtilizator();

        utilizator.getCereriAsteptare().remove(cerereRezolvata);
        utilizator.getCereriFinalizate().add(cerereRezolvata);

//        assert functionarPublic != null;
//        functionarPublic.getSetCereriRezolvate().add(cerereRezolvata);

        // scriu cererea in fisier
        outputCerereFunctionar(cerereRezolvata, functionarPublic);

        birou.getSetCereriBirou().remove(cerereRezolvata);

    }

    /**
     * Functia de scriere a unei cereri in fisierul functionarului care a rezolvat cererea.
     *
     * @param cerere           - obiectul Cerere care a fost rezolvat
     * @param functionarPublic - obiectul FunctionarPublic care a rezolvat cererea
     */
    public void outputCerereFunctionar(Cerere cerere, FunctionarPublic functionarPublic) {
        try {
            FileWriter fwFunctionar = new FileWriter("src/main/resources/output/functionar_" + functionarPublic.getNume() + ".txt", true);
            BufferedWriter bwFunctioar = new BufferedWriter(fwFunctionar);
            String output = cerere.stringData() + " - " + cerere.getUtilizator().getNume() + "\n";
            bwFunctioar.append(output);

            bwFunctioar.close();
            fwFunctionar.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Metoda de retragere a unei cereri, se sterge cererea din TreeSetul utilizatorului
     * si din biroul de care apartine.
     *
     * @param param          - parametrii primiti in pe o linie
     * @param setUtilizatori - setul cu toti utilizatorii
     * @throws ParseException
     */
    public void retrageCerereUtilizator(String[] param, HashSet<Utilizator> setUtilizatori) throws ParseException {
        for (Utilizator util : setUtilizatori) {
            if (util.getNume().equals(param[1])) {
                Cerere cerereStergere = new Cerere(util, param[2], null, 0);
                for (Cerere cerereUtilizator : util.getCereriAsteptare()) {
                    if (cerereUtilizator.getDataCer().equals(cerereStergere.getDataCer())) {
                        util.getCereriAsteptare().remove(cerereUtilizator);
                        switch (util.getType()) {
                            case "persoana":
                                for (Cerere cerereBirou : bPersoana.getSetCereriBirou()) {
                                    if (cerereBirou.equals(cerereUtilizator)) {
                                        bPersoana.getSetCereriBirou().remove(cerereBirou);
                                        return;
                                    }
                                }
                                break;
                            case "angajat":
                                for (Cerere cerereBirou : bAngajat.getSetCereriBirou()) {
                                    if (cerereBirou.equals(cerereUtilizator)) {
                                        bAngajat.getSetCereriBirou().remove(cerereBirou);
                                        return;
                                    }
                                }
                                break;
                            case "pensionar":
                                for (Cerere cerereBirou : bPensionar.getSetCereriBirou()) {
                                    if (cerereBirou.equals(cerereUtilizator)) {
                                        bPensionar.getSetCereriBirou().remove(cerereBirou);
                                        return;
                                    }
                                }
                                break;
                            case "elev":
                                for (Cerere cerereBirou : bElev.getSetCereriBirou()) {
                                    if (cerereBirou.equals(cerereUtilizator)) {
                                        bElev.getSetCereriBirou().remove(cerereBirou);
                                        return;
                                    }
                                }
                                break;
                            case "entitate juridica":
                                for (Cerere cerereBirou : bEntitateJuridica.getSetCereriBirou()) {
                                    if (cerereBirou.equals(cerereUtilizator)) {
                                        bEntitateJuridica.getSetCereriBirou().remove(cerereBirou);
                                        return;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }

    // metode Birou
    public void adaugaFunctionar(String tipBirou, String nume) {
        FunctionarPublic nouFunctionarPublic = new FunctionarPublic(nume, tipBirou);
        switch (tipBirou) {
            case "persoana":
                bPersoana.getSetFunctionarPublic().add(nouFunctionarPublic);
                break;
            case "angajat":
                bAngajat.getSetFunctionarPublic().add(nouFunctionarPublic);
                break;
            case "pensionar":
                bPensionar.getSetFunctionarPublic().add(nouFunctionarPublic);
                break;
            case "elev":
                bElev.getSetFunctionarPublic().add(nouFunctionarPublic);
                break;
            case "entitate juridica":
                bEntitateJuridica.getSetFunctionarPublic().add(nouFunctionarPublic);
                break;
            default:
                break;
        }

    }

    public BufferedWriter getBufferOuput() {
        return bufferOuput;
    }

    public void setBufferOuput(BufferedWriter bufferOuput) {
        this.bufferOuput = bufferOuput;
    }
}
