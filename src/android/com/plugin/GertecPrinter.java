package com.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GertecPrinter {
  
    /**
    * Método construtor da classe usando o GPOS 700
    * @param c = Context  atual que esta sendo inicializada a class
    **/
    public GertecPrinter(Context c) {
        this.context = c;
        startIGEDI();
    }

    /**
    * Método que instância a classe GEDI da lib deve ser usado apenas para o GPOS 700
    *
    * @apiNote = Este mátodo faz a instância da classe GEDI através de uma Thread.
    *            Será sempre chamado na construção da classe.
    *            Não alterar...
    **/
    private void startIGEDI() {
        
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

    /**
     * Método que recebe o atual texto e ser o mesmo será impresso em negrito e/ou itálico.
     *
     * @param texto  = Texto que será impresso.
     * @param negrito = Caso o texto deva ser impresso em negrito
     * @param italico  = Caso o texto deva ser impresso em itálico
     *
     * @throws Exception = caso a impressora esteja com erro.
     *
     * @apiNote = Esse mátodo só altera o tamanho do texto na impressão que for chamado
     *      * a classe {@link ConfigPrint} não será alterada para continuar sendo usado na impressão da
     *      * proxíma linha
     *
     * */
    public void imprimeTexto(String texto, boolean negrito, boolean italico) throws Exception {

    }
    /**
     * Método que recebe o atual texto e ser o mesmo será impresso em negrito, itálico e/ou  sublinhado.
     *
     * @param texto  = Texto que será impresso.
     * @param negrito = Caso o texto deva ser impresso em negrito
     * @param italico  = Caso o texto deva ser impresso em itálico
     * @param sublinhado   = Caso o texto deva ser impresso em itálico.
     *
     * @throws Exception = caso a impressora esteja com erro.
     *
     * @apiNote = Esse mátodo só altera o tamanho do texto na impressão que for chamado
     *      * a classe {@link ConfigPrint} não será alterada para continuar sendo usado na impressão da
     *      * proxíma linha
     *
     * */
    public void imprimeTexto(String texto, boolean negrito, boolean italico, boolean sublinhado) throws Exception {

    }

    /**
     * Método que faz a impressão de imagens
     *
     * @param imagem = Nome da imagem que deve estar na pasta drawable
     *
     * @throws IllegalArgumentException = Argumento passado ilegal
     * @throws GediException = retorna o código do erro.
     *
     * */
    public boolean imprimeImagem( String imagem ) throws GediException {
        return true;
    }

    /**
     * Método que faz a impressão de código de barras
     *
     * @param texto = Texto que será usado para a impressão do código de barras
     * @param height  = Tamanho
     * @param width  = Tamanho
     * @param barCodeType  = Tipo do código que será impresso
     *
     * @throws IllegalArgumentException = Argumento passado ilegal
     * @throws GediException = retorna o código do erro.
     *
     * */
    public boolean imprimeBarCode( String texto, int height, int width,  String barCodeType ) throws GediException {
        return true;
    }

    /**
     * Método que faz a impressão de código de barras
     *
     * @param texto = Texto que será usado para a impressão do código de barras
     * @param height  = Tamanho
     * @param width  = Tamanho
     * @param barCodeType  = Tipo do código que será impresso
     *
     * @throws IllegalArgumentException = Argumento passado ilegal

     *
     * */
    public boolean imprimeBarCodeIMG( String texto, int height, int width,  String barCodeType ) throws WriterException {

        return true;

    }

    
    /**
     * Método que faz a inicialização da impressao
     *
     * @throws Exception = retorno o código do erro.
     *
     * */
    public void ImpressoraInit() throws Exception {
        
    }

    /**
     * Método que faz a finalizacao do objeto iPrint
     *
     * @throws GediException = retorno o código do erro.
     *
     * */
    public void ImpressoraOutput() throws GediException {
        
    }

    //MetodosTesting
    public String checkISmart(){
       
        return "CheckIsmart";
    }

    //Metodo Testados e funcionando corretamente

    //-------------------Metodos Led------------------
     /**
     * Método Acender o led
     *
     *
     * @return String
     *
     * */
    public String led() {

        return "led";
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
        
        return "getStatusImpressora";
    }



}
