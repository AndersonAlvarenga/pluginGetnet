package com.plugin;

import android.app.Activity;
import android.content.Context;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.getnet.posdigital.IMainService;
import com.getnet.posdigital.beeper.IBeeperService;
import com.getnet.posdigital.camera.ICameraService;
import com.getnet.posdigital.card.ICardService;
import com.getnet.posdigital.info.IInfoService;
import com.getnet.posdigital.led.ILedService;
import com.getnet.posdigital.mifare.IMifareService;
import com.getnet.posdigital.printer.IPrinterService;
import com.getnet.posdigital.stat.IStatService;
import com.getnet.posdigital.PosDigital;
import com.getnet.posdigital.PosDigital.BindCallback;
import android.content.ServiceConnection;



public class GertecPrinter {
  
    private Activity activity;
    private Context context;
    private static final String TAG = "PosDigital";
    private static PosDigital posDigital;
    /* access modifiers changed from: private */
    public ServiceConnection connection;
    private String initializeIntent = "com.getnet.posdigital.service.INITIALIZE";
    private String initializedIntent = "com.getnet.posdigital.service.INITIALIZED";
    /* access modifiers changed from: private */
    public IMainService mainService;
    private String notInitializedIntent = "com.getnet.posdigital.service.NOT_INITIALIZED";
    /* access modifiers changed from: private */
    public String servicePackage = "com.getnet.posdigital.service";
    public BindCallback bindCallback;



    /**
    * Método construtor da classe usando o GPOS 700
    * @param c = Context  atual que esta sendo inicializada a class
    **/
    public GertecPrinter(Context c) {
        this.context = c;
        //GertecPrinter.posDigital.register(this.context,this.bindCallback);
    }
    public PosDigital getInstance(){
        return PosDigital.getInstance();
    }
     /**
     * Método que retorna o atual estado da impressora
     *
     *
     * @return String = traduzStatusImpressora()
     *
     * */
    public String getStatusImpressora(){
        
        return GertecPrinter.this.getInstance().isInitiated()==true?"Iniciado":"Nao iniciado";
    }
  

    //Metodos novos para GetNet

    public String beeper(){
        //GertecPrinter.this.getInstance().register(this.context, this.bindCallback);
        try{
            PosDigital.register(context, this.bindCallback);
        }catch(Exception e){
            return e.getMessage();
        }
        
        try{
            IBeeperService beep = GertecPrinter.posDigital.getBeeper();
            beep.success();
        }catch(Exception e){
            return e.getMessage();
        }

        return "Sucess";
    }





}