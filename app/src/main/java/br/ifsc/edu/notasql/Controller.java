package br.ifsc.edu.notasql;

import android.content.Context;

public class Controller {

    Banco banco;
    Context context;

    public Controller(Context context1){
        this.context=context1;
        banco = new Banco(context);
    }
    public void salvarAnotacao(Anotacao anotacao){banco.inserirAnotacao(anotacao);}
    public String recuperarAnotacao(){return banco.retornarAnotacao();}
    public boolean IDExiste(int i){
        if (banco.ID(i)>0){
            return true;
        }else {
            return false;
        }
    }
    public void updateAnotacao(Anotacao anotacao){
        banco.atualizarAnotacao(anotacao);
    }
}
