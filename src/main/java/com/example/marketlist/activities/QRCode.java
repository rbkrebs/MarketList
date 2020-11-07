package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.marketlist.R;
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

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCode extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    /*Nesta classe a única função 'visível' é o intent
    No Logcat é possível ver a URL do QRCode
    Ainda vou implementar a classe Crawler para copiar os dados
     */

    private ZXingScannerView scannerView;

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


        System.out.println(rawResult.getText());
        Content content = new Content();
        content.execute();
        Intent intent = new Intent( QRCode.this, MainActivity.class);
        startActivity(intent);

    }

    private class Content extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            String url_code = "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?p=43201094161890000167650010004159861211031084|2|1|1|AF0133FAD4FFB8F889CA96077AE870377BD0C187";
            try {
                Document doc = Jsoup.connect(url_code).get();
                Element ele = doc.getElementById("iframeConteudo");
                Log.d("teste", String.valueOf(ele.attr("src")) );
                String url_crl = String.valueOf(ele.attr("src"));
                doc = Jsoup.connect(url_crl).get();

                //Elements elements = doc.select("tbody tr td table tbody tr");

                int i = 1;

                Element element;


                do{
                    element = doc.getElementById("Item + " + i);
                    System.out.println(element);
                    i++;

                }while(element != null);



                //Log.d("teste", String.valueOf(elements) );
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}