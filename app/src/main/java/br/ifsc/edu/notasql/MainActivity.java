package br.ifsc.edu.notasql;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller(MainActivity.this);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.equals("")){
                    Anotacao anotacao = new Anotacao(1,editText.getText().toString());
                    if (controller.IDExiste(1));
                    controller.updateAnotacao(anotacao);
                    textView.setText(controller.recuperarAnotacao());
                }else{
                    Toast.makeText(getApplicationContext(), "Não é possivel criar a anotação", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.setText(controller.recuperarAnotacao());
    }

    @Override
    protected void onPause() {
        super.onPause();

        Anotacao anotacao = new Anotacao(1,editText.getText().toString());

        if (controller.IDExiste(1)){
            controller.updateAnotacao(anotacao);
        }else{
            controller.salvarAnotacao(anotacao);
        }
    }
}
