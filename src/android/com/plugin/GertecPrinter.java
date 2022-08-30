package com.plugin;

import android.app.Activity;
import android.content.Context;
import com.getnet.posdigital.PosDigital;


public class GertecPrinter {
  // Definições
    private final String IMPRESSORA_ERRO = "Impressora com erro.";

    // Statics
    private static boolean isPrintInit = false;

    // Vaviáveis iniciais
    private Activity activity;
    private Context context;
    private PosDigital posDigital;

    /**
    * Método construtor da classe usando o GPOS 700
    * @param c = Context  atual que esta sendo inicializada a class
    **/
    public GertecPrinter(Context c) {
        this.context = c;
    }
    public String teste(){    
      return this.posDigital.isInitiated()==true?"True":"False";
    }


}
