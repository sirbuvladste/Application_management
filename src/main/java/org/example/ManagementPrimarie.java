package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;

public class ManagementPrimarie {
    // Realizez fiecare birou care v-a fi valabil prin management
    Birou<Angajat> bAngajat;
    Birou<Persoana> bPersoana;
    Birou<Pensionar> bPensionar;
    Birou<Elev> bElev;
    Birou<EntitateJuridica> bEntitateJuridica;

    public ManagementPrimarie() {
        bAngajat = new Birou<>();
        bPersoana = new Birou<>();
        bPensionar = new Birou<>();
        bElev = new Birou<>();
        bEntitateJuridica = new Birou<>();
    }

    public static void main(String[] args) throws IOException, ParseException {
        String numeInput;
        String numeOutput;
        BufferedReader bufferInput;

        // realizez path-ul pentru fisiere
        numeInput = "src/main/resources/input/" + args[0];
        numeOutput = "src/main/resources/output/" + args[0];

        /*
         * Realizez handlerul de comenzi si astfel se deschide bufferul de output.
         * Atunci cand apelez constructorul de ManagementComenzi atunci se apleaza si cel pentru ManagementPrimarie, astfel
         * se initializeaza fiecare birou.
         */
        ManagementComenzi management = new ManagementComenzi(numeOutput);

        // Fiecare utilizator e unic asa ca folosesc hashset
        HashSet<Utilizator> setUtilizatori = new HashSet<>();

        // citesc comenzile si le rezolv
        try {
            bufferInput = new BufferedReader(new FileReader(numeInput));

            String line = bufferInput.readLine();

            while (line != null) {
                String[] comanda;
                comanda = line.split("; ");
                switch (comanda[0]) {
                    case "adauga_utilizator":
                        setUtilizatori.add(management.adaugaUtilizator(comanda));
                        break;
                    case "cerere_noua":
                        management.creareCerereNoua(comanda, setUtilizatori);
                        break;
                    case "afiseaza_cereri_in_asteptare":
                        management.afisareCereriAsteptareUtilizator(comanda[1], setUtilizatori);
                        break;
                    case "afiseaza_cereri_finalizate":
                        management.afisareCereriFinalizateUtilizator(comanda[1], setUtilizatori);
                        break;
                    case "retrage_cerere":
                        management.retrageCerereUtilizator(comanda, setUtilizatori);
                        break;
                    case "adauga_functionar":
                        management.adaugaFunctionar(comanda[1], comanda[2]);
                        break;
                    case "afiseaza_cereri":
                        management.afisareCereriBirou(comanda[1]);
                        break;
                    case "rezolva_cerere":
                        management.rezolvaCerere(comanda[1], comanda[2]);
                        break;

                    default:
                        break;
                }
                line = bufferInput.readLine();
            }
            bufferInput.close();
            management.CloseBufferOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}