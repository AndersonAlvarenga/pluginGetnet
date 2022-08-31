package com.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.content.ServiceConnection;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import com.getnet.posdigital.PosDigital;
import com.getnet.posdigital.beeper.IBeeperService;


public class GertecPrinter {
  
    private Activity activity;
    private Context context;
    private PosDigital posDigital;
    private static ServiceConnection connection;


    /**
    * Método construtor da classe usando o GPOS 700
    * @param c = Context  atual que esta sendo inicializada a class
    **/
    public GertecPrinter(Context c) {
        this.context = c;
        PosDigital.register(this.context);
    }

    

    /**
    * Método que recebe a configuração para ser usada na impressão
    * @param config  = Classe {@link ConfigPrint} que contém toda a configuração
    *                  para a impressão
    * */
    public void setConfigImpressao(ConfigPrint config) {

      
    }

    /**
     * Método que recebe o atual texto a ser impresso
     * @param texto  = Texto que será impresso.
     *
     * @throws Exception = caso a impressora esteja com erro.
     *
     * */
    public void imprimeTexto(String texto) throws Exception {

    }

    /**
     * Método que recebe o atual texto e o tamanho da fonte que deve ser usado na impressão.
     *
     * @param texto  = Texto que será impresso.
     * @param tamanho = Tamanho da fonte que será usada
     *
     * @throws Exception = caso a impressora esteja com erro.
     *
     * @apiNote = Esse mátodo só altera o tamanho do texto na impressão que for chamado
     * a classe {@link ConfigPrint} não será alterada para continuar sendo usado na impressão da
     * proxíma linha
     *
     * */
    public void imprimeTexto(String texto, int tamanho) throws Exception {

    }

    /**
     * Método que recebe o atual texto e ser o mesmo será impresso em negrito.
     *
     * @param texto  = Texto que será impresso.
     * @param negrito = Caso o texto deva ser impresso em negrito
     *
     * @throws Exception = caso a impressora esteja com erro.
     *
     * @apiNote = Esse mátodo só altera o tamanho do texto na impressão que for chamado
     *      * a classe {@link ConfigPrint} não será alterada para continuar sendo usado na impressão da
     *      * proxíma linha
     *
     * */
    public void imprimeTexto(String texto, boolean negrito) throws Exception {

      
    }


    //----------------Fim metodos Led------------------
     /**
     * Método que retorna o atual estado da impressora
     *
     *
     * @return String = traduzStatusImpressora()
     *
     * */
    public String getStatusImpressora(){
        
        return this.posDigital.getInstance().isInitiated()==true?"Iniciado":"Nao iniciado";
    }

    //Metodos novos para GetNet

    public String beeper(){
        this.posDigital.startService(this.context);
        try{
            IBeeperService beep = this.posDigital.getInstance().getBeeper();
        }catch(Exception e){
            return e.getMessage();
        }
        return "Sucess";
    }


}
