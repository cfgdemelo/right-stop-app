package br.edu.unicid.paradacerta;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity {

    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        btnClick = (Button) findViewById(R.id.btnQr);
    }

    public void abrirApp(View v){
        Intent it = new Intent(Principal.this, BarCodeReader.class);
        startActivity(it);
    }

    public void sobreNos(View v){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setIcon(android.R.drawable.ic_dialog_map);
        alerta.setTitle("Sobre Nós");
        alerta.setMessage("Somos a NoFlow Corporation");
        alerta.setNegativeButton("Ok", null);
        alerta.create().show();
    }

    public void sair(View v){
        finish();
    }
}
