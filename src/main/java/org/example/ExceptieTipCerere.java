package org.example;

class ExceptieTipCerere extends Exception {
    String textExceptie;

    public ExceptieTipCerere(String type, String cerereStr) {
        textExceptie = "Utilizatorul de tip " + type + " nu poate inainta o cerere de tip " + cerereStr + "\n";
        System.out.println(textExceptie);
    }
}
