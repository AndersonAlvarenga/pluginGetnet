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

    public interface BindCallback {
        void onConnected();

        void onDisconnected();

        void onError(Exception exc);
    }


    /**
    * Método construtor da classe usando o GPOS 700
    * @param c = Context  atual que esta sendo inicializada a class
    **/
    public GertecPrinter(Context c) {
        this.context = c;
        register(this.context,this.BindCallback);
    }

    
    
    /* access modifiers changed from: private */
    public void _register(final Context context, final BindCallback bindCallback) {
        context.sendBroadcast(new Intent(this.initializeIntent));
        context.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                ServiceConnection unused = PosDigital.this.connection = PosDigital.this.getServiceConnection(context, bindCallback);
                Intent intent2 = new Intent(PosDigital.this.servicePackage);
                intent2.setPackage(PosDigital.this.servicePackage);
                context.startService(intent2);
                context.bindService(intent2, PosDigital.this.connection, 1);
                context.unregisterReceiver(this);
            }
        }, new IntentFilter(this.initializedIntent));
        context.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                context.unregisterReceiver(this);
                bindCallback.onError(new RuntimeException("Occurred error when tried to connect at Hardware service"));
            }
        }, new IntentFilter(this.notInitializedIntent));
    }

    private void _unregister(Context context) {
        this.mainService = null;
        if (this.connection != null) {
            context.unbindService(this.connection);
            this.connection.onServiceDisconnected((ComponentName) null);
        }
    }

    public boolean isInitiated() {
        return this.mainService != null;
    }

    public IPrinterService getPrinter() {
        try {
            if (this.mainService != null) {
                return this.mainService.getPrinter();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public ICardService getCard() {
        try {
            if (this.mainService != null) {
                return this.mainService.getCard();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public IMifareService getMifare() {
        try {
            if (this.mainService != null) {
                return this.mainService.getMifare();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public ILedService getLed() {
        try {
            if (this.mainService != null) {
                return this.mainService.getLed();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public ICameraService getCamera() {
        try {
            if (this.mainService != null) {
                return this.mainService.getCamera();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public IBeeperService getBeeper() {
        try {
            if (this.mainService != null) {
                return this.mainService.getBeeper();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public IInfoService getInfo() {
        try {
            if (this.mainService != null) {
                return this.mainService.getInfo();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    public IStatService getStatistic() {
        try {
            if (this.mainService != null) {
                return this.mainService.getStatistic();
            }
            throw new RuntimeException("Service isn't initialized");
        } catch (RemoteException unused) {
            throw new RuntimeException("Service isn't initialized");
        }
    }

    /* access modifiers changed from: private */
    public ServiceConnection getServiceConnection(final Context context, final BindCallback bindCallback) {
        return new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    IMainService unused = PosDigital.this.mainService = IMainService.Stub.asInterface(iBinder);
                    bindCallback.onConnected();
                } catch (Exception e) {
                    bindCallback.onError(e);
                }
                try {
                    iBinder.linkToDeath(new PosDigital$3$$Lambda$0(this, context, bindCallback), 1);
                } catch (RemoteException e2) {
                    throw new RuntimeException("MainService link to death error.", e2);
                }
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ void lambda$onServiceConnected$0$PosDigital$3(Context context, BindCallback bindCallback) {
                PosDigital.this._register(context, bindCallback);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                bindCallback.onDisconnected();
            }
        };
    }

    public static PosDigital getInstance() {
        if (posDigital != null) {
            return posDigital;
        }
        throw new RuntimeException("Service isn't initialized");
    }

    public static void register(Context context, BindCallback bindCallback) {
        Log.e(TAG, "start register: ");
        posDigital = new PosDigital();
        startService(context);
        posDigital._register(context, bindCallback);
        Log.e(TAG, "finish register: ");
    }

    private static boolean isServiceRunning(String str, Context context) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (str.equals(runningServiceInfo.service.getPackageName())) {
                Log.e(TAG, "isServiceRunning: true");
                return true;
            }
        }
        Log.e(TAG, "isServiceRunning: false");
        return false;
    }

    private static void startService(Context context) {
        if (!isServiceRunning("com.getnet.posdigital.service", context)) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.getnet.posdigital.service", "com.getnet.posdigital.service.MainService"));
                ComponentName startService = context.startService(intent);
                if (startService != null) {
                    Log.e(TAG, "startService 1: " + startService.getPackageName());
                    while (!isServiceRunning("com.getnet.posdigital.service", context)) {
                    }
                    Log.e(TAG, "startService 2: " + startService.getPackageName());
                    return;
                }
                Log.e(TAG, "startService: service does not exist");
            } catch (Exception e) {
                Log.e(TAG, "startService: Failed " + e.toString());
                e.printStackTrace();
            }
        }
    }

    public static void unregister(Context context) {
        posDigital._unregister(context);
    }



    
     /**
     * Método que retorna o atual estado da impressora
     *
     *
     * @return String = traduzStatusImpressora()
     *
     * */
    public String getStatusImpressora(){
        
        return getInstance().isInitiated()==true?"Iniciado":"Nao iniciado";
    }

    //Metodos novos para GetNet

    public String beeper(){
        startService(this.context);
        try{
            IBeeperService beep = this.posDigital.getInstance().getBeeper();
        }catch(Exception e){
            return e.getMessage();
        }
        return "Sucess";
    }


}
