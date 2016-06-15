package br.edu.unicid.paradacerta;

import android.content.ComponentName;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BarCodeReader extends AppCompatActivity implements OnClickListener {
    private Button scanBtn;
    private TextView txt1, txt2, txt3, txt4;
    private LatLng origem, destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_code_reader);
        scanBtn = (Button) findViewById(R.id.btnScan);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        scanBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnScan) {
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            txt1.setText("Parada UNICID");
            txt2.setText("Linha 584 - Metrô Carrão");
            txt3.setText("Linha 584 - Metrô Tatuapé");
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Não foi possível escanear!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    private void callExternalMap(LatLng origem, LatLng destino) {
        try {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?saddr=" + origem.latitude + "," + origem.longitude + "&daddr=" + destino.latitude + "," + destino.longitude));

        /*
        * Se você quiser que o usuário vá direto para o aplicativo do Google Maps, use a linha abaixo.
        * Caso não queira (de opções para o usuário abrir em outros aplicativos de mapas no celular), apenas apague a linha abaixo.
        */
            intent.setComponent(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));

            startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(this, "Verifique se o Google Maps está instalado em seu dispositivo", Toast.LENGTH_SHORT).show();
        }
    }
    public void abrirUnicid(View v){

        origem = new LatLng(-23.5362409,-46.5602022);
        destino = new LatLng(-23.5362409,-46.5602022);
        callExternalMap(origem,destino);
        finish();
    }
    public void abrirCarrao(View v){

        origem = new LatLng(-23.5362409,-46.5602022);
        destino = new LatLng(-23.5378589,-46.5645125);
        callExternalMap(origem,destino);
        finish();
    }
    public void abrirTatuape(View v){

        origem = new LatLng(-23.5362409,-46.5602022);
        destino = new LatLng(-23.540064, -46.577904);
        callExternalMap(origem,destino);
        finish();
    }
    public void abrirBelem(View v){

        origem = new LatLng(-23.5362409,-46.5602022);
        destino = new LatLng(-23.5416079,-46.5893101);
        callExternalMap(origem,destino);
        finish();
    }

    public void teste(View v){
        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(37.35, -122.0))
                .add(new LatLng(37.45, -122.0))  // North of the previous point, but at the same longitude
                .add(new LatLng(37.45, -122.2))  // Same latitude, and 30km to the west
                .add(new LatLng(37.35, -122.2))  // Same longitude, and 16km to the south
                .add(new LatLng(37.35, -122.0)); // Closes the polyline.

// Get back the mutable Polyline
      //  Polyline polyline = myMap.addPolyline(rectOptions);
    }

}