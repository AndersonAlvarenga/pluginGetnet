package com.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import static android.app.Activity.RESULT_OK;
import static android.app.Activity.RESULT_CANCELED;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


import static android.hardware.Camera.Parameters.FLASH_MODE_ON;

public class MainActivity extends CordovaPlugin {

    public static final String G700 = "GPOS700";
    public static final String G800 = "Smart G800";
    private static final String version = "RC03";
    public static String Model = Build.MODEL;
    private String resultado_Leitor;
    private IntentIntegrator qrScan;
    private IntentIntegrator qrScanv2;
    private String titulo;
    private String tipo;
    private String status;
    private String mensagem;
    private ArrayList<String> arrayListTipo;
    private CallbackContext callbackContext;
    private CallbackContext scancallbackContext;
    private GertecPrinter gertecPrinter;
    private CordovaWebView webView;
    private ConfigPrint configPrint = new ConfigPrint();
    private Intent intent;
    private int pulaLinha;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.webView = webView;
        gertecPrinter = new GertecPrinter(cordova.getActivity().getApplicationContext());

    }

    public MainActivity() {
        super();


    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();
        this.callbackContext = callbackContext;
        intent = null;

        if (action.equals("checarImpressora")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    try {
                       status = gertecPrinter.isInitiated();
                        Toast.makeText(cordova.getActivity(), status, Toast.LENGTH_LONG).show();
                        callbackContext.success(status);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callbackContext.error("Erro " + e.getMessage());
                    }
                }
            });
            return true;
        }
        if (action.equals("imprimir")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    try {
                       status = gertecPrinter.print();
                        Toast.makeText(cordova.getActivity(), status, Toast.LENGTH_LONG).show();
                        callbackContext.success(status);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callbackContext.error("Erro " + e.getMessage());
                    }
                }
            });
            return true;
        }
        return true;
    }
}
