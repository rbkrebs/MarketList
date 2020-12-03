package com.example.marketlist.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.marketlist.R;
import com.example.marketlist.model.ItemComprado;
import com.example.marketlist.model.NotaFiscal;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCode extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    /*Nesta classe a única função 'visível' é o intent
    No Logcat é possível ver a URL do QRCode
    Ainda vou implementar a classe Crawler para copiar os dados
     */

    private ZXingScannerView scannerView;
    private static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code);

        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        scannerView.setResultHandler(QRCode.this);
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(QRCode.this, "Você deve ter aceitar essa permissão", Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                })
                .check();
    }
    @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {


        this.url = rawResult.getText();
        Content content = new Content();
        content.execute();
        Intent intent = new Intent( QRCode.this, MainActivity.class);
        startActivity(intent);

    }

    private class Content extends AsyncTask<Void, Void, Void>{

        @RequiresApi(api = Build.VERSION_CODES.O)//fui obrigado a colocar isso para usar o String.join!!!
        @Override
        protected Void doInBackground(Void... voids) {
            String url_code = QRCode.url; //"https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?p=43201094161890000167650010004159861211031084|2|1|1|AF0133FAD4FFB8F889CA96077AE870377BD0C187";
            try {
                Document doc = Jsoup.connect(url_code).get();
                Element ele = doc.getElementById("iframeConteudo");
                Log.d("teste", String.valueOf(ele.attr("src")) );
                String url_crl = String.valueOf(ele.attr("src"));
                doc = Jsoup.connect(url_crl).get();
                System.out.println(doc.select("tr:nth-child(2) > .NFCCabecalho_SubTitulo1").text());
                System.out.println(doc.select("tr:nth-child(3) > td > table > tbody > tr:nth-child(1) > .NFCCabecalho_SubTitulo").text());
                System.out.println(doc.select("tr:nth-child(4) > .NFCCabecalho_SubTitulo").text());
                /*
                * 2020-12-02 22:39:30.283 28321-28584/com.example.marketlist I/System.out: CNPJ: 94.161.890/0001-67 Inscrição Estadual: 1410057175
                    2020-12-02 22:39:30.303 28321-28584/com.example.marketlist I/System.out: NFC-e nº: 415986 Série: 1 Data de Emissão: 21/10/2020 10:31:08
                    2020-12-02 22:39:30.315 28321-28584/com.example.marketlist I/System.out: 4320 1094 1618 9000 0167 6500 1000 4159 8612 1103 1084
                *
                * */


                NotaFiscal notaFiscal = new NotaFiscal();
                ArrayList<ItemComprado> listaItensComprados = new ArrayList();


                int i = 1;

                Element element;


                do{
                    element = doc.getElementById("Item + " + i);
                    if(element != null){
                        ItemComprado itemComprado = new ItemComprado();
                        itemComprado.setCodigo(Long.parseLong(element.text().split(" ")[0]));
                        itemComprado.setDescricao(String.join(" ",(Arrays.asList(Arrays.copyOfRange(element.text().split(" "),1,element.text().split(" ").length -4)))));
                        itemComprado.setQuantidade(Float.parseFloat(element.text().split(" ")[element.text().split(" ").length -4].replace(",",".")));
                        itemComprado.setUnidade(element.text().split(" ")[element.text().split(" ").length -3]);
                        itemComprado.setValorUnitario(Float.parseFloat(element.text().split(" ")[element.text().split(" ").length -2].replace(",",".")));
                        listaItensComprados.add(itemComprado);

                    }

                    i++;

                }while(element != null);

                notaFiscal.setItensComprados(listaItensComprados);

                System.out.println(notaFiscal.getItensComprados().toString());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}