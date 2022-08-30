package com.plugin;

import android.app.Activity;
import android.content.Context;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

//Import LIB
import com.getnet.posdigital.IMainService.Stub;
import com.getnet.posdigital.beeper.IBeeperService;
import com.getnet.posdigital.camera.ICameraService;
import com.getnet.posdigital.card.ICardService;
import com.getnet.posdigital.info.IInfoService;
import com.getnet.posdigital.led.ILedService;
import com.getnet.posdigital.mifare.IMifareService;
import com.getnet.posdigital.printer.IPrinterService;
import com.getnet.posdigital.printer.IPrinterCallback;
import com.getnet.posdigital.stat.IStatService;
import com.getnet.posdigital.PosDigital;


import java.util.Iterator;


public class GertecPrinter {
  
  private Context context;
  private PosDigital posDigital;
  private static final String TAG = "PosDigital";
  private static String servicePackage = "com.getnet.posdigital.service";
  private static String initializeIntent = "com.getnet.posdigital.service.INITIALIZE";
  private static String initializedIntent = "com.getnet.posdigital.service.INITIALIZED";
  private static String notInitializedIntent = "com.getnet.posdigital.service.NOT_INITIALIZED";
  private static IMainService mainService;
  private static ServiceConnection connection;
  private static Context mParentContext;
  private static BroadcastReceiver initializedBroadcast;
  private static BroadcastReceiver notItializedBroadcast;
  private static PosDigital posDigital;




  /**
  * Método construtor da classe usando o GPOS 700
  * @param c = Context  atual que esta sendo inicializada a class
  **/
  public GertecPrinter(Context c) {
      this.context = c;
  }

  public String isInitiated(){    
    return this.posDigital.isInitiated()?"True":"False";
  }

  public IPrinterService getPrinter(){
    return this.posDigital.getPrinter();
  }

  public IcardService getCard(){
    return this.posDigital.getCard();
  }

  public IMifareService getMifare(){
    return this.posDigital.getMifare();
  }

  public ILedService getLed() {
    return this.posDigital.getLed();
  }

  public ICameraService getCamera(){
    return this.posDigital.getCamera();
  }

  public IBeeperService getBeeper(){
    return this.posDigital.getBeeper();
  }

  public IInfoService getInfo() {
    return this.posDigital.getInfo();
  }

  public IStatService getStatistic() {
    return this.posDigital.getStatistic();
  }
  
  public String print(){
    if(this.posDigital.getInstance().isInitiated){
      try{
        this.posDigital.getInstance().printer.init();
        this.posDigital.getInstance().printer.setGray(5);
        this.posDigital.getInstance().printer.defineFontFormat(FontFormat.MEDIUM);
        this.posDigital.getInstance().printer.addText(AlignMode.LEFT, "Barcode: 20");
        this.posDigital.getInstance().printer.addText(AlignMode.LEFT, " ");
        this.posDigital.getInstance().printer.print(getPrinterCallback());
      }catch (Exception e){
        return "Erro ao imprimir: "+e.getMessage();
      }
    
    }else{
      return "Instance não foi inicializada";
    }
    return "Ok";

  } 

 
  private void getPrinterCallback(){
    return IPrinterCallback.Stub();
  }
   



}
