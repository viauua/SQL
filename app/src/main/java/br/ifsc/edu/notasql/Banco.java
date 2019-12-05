package br.ifsc.edu.notasql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Banco {

    private static final String NOME_BANCO = "Banco de Dados";
    private SQLiteDatabase bd;
    private Context contexto;

    public Banco(Context context) {
        this.contexto = context;
        bd = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
        criarTabela();
    }
    private void criarTabela(){
        bd.execSQL("CREATE TABLE IF NOT EXISTS textos(" + "id integer primary key," + "texto varchar);");
    }
    public void inserirAnotacao(Anotacao anotacao){
        ContentValues values = new ContentValues();
        values.put("id",anotacao.getId());
        values.put("texto",anotacao.getTexto());
        bd.insert("textos", null, values);
        Toast.makeText(contexto, "Adicionado", Toast.LENGTH_SHORT).show();
    }
    public String retornarAnotacao(){
        Cursor cursor;
        cursor = bd.rawQuery("SELECT texto FROM textos WHERE id=1;", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            String txt = cursor.getString(cursor.getColumnIndex("texto"));
            return txt;
        }else{
            return null;
        }
    }
    public void atualizarAnotacao(Anotacao anotacao){
        ContentValues values = new ContentValues();
        values.put("id",anotacao.getId());
        values.put("texto", anotacao.getTexto());
        bd.update("textos", values, null, null);
    }
    public int ID(int i){
        Cursor cursor;
        cursor = bd.rawQuery("SELECT * FROM textos WHERE id='"+i+"';", null);
        cursor.moveToFirst();

        int voltar = cursor.getCount();
        return voltar;
    }
}
