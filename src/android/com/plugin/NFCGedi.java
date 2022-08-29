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

    ICL icl = null;
    private NfcAdapter nfcAdapter;
    private TextView text;
    private int id;
    private static int Contagem = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Liga o Sensor da NFC
    }
}
