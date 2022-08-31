package com.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class NFCGedi extends Activity {
    private static final String TAG = NFCGedi.class.getSimpleName();
    private NfcAdapter nfcAdapter;
    private TextView text;
    private int id;
    private static int Contagem = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("nfcgedi", "layout", package_name));
        id = getResources().getIdentifier("textIdCartao","id",package_name);
        text = (TextView)findViewById(id);
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Liga o Sensor da NFC
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public String LerCard(){
        return "Led Card";
    }

    public String LerDados(byte[] dados) {
        
        return "Ler Dados";
    }

    private static String bytesToHex(byte[] hashInBytes) {

       
        return "bytesToHex";
    }
}
