package org.example;

class ExceptieFunctionarNuExista extends Exception {
    public ExceptieFunctionarNuExista() {
        System.out.println("Functionarul cerut din biroul specificat nu exista!\n");
    }
}