package br.ifsc.edu.notasql;

public class Anotacao {

    String texto;
    int id;

    public Anotacao(int i, String texto){
        this.texto = texto;
        this.id = i;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
