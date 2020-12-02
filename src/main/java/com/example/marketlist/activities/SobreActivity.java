package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marketlist.R;
import com.example.marketlist.dao.AppDatabase;
import com.example.marketlist.dao.SobreDAO;
import com.example.marketlist.entity.Sobre;

public class SobreActivity extends AppCompatActivity {

    private TextView autor;
    private TextView disciplina;
    private TextView mensagem;
    private ImageView btnLinkedin;
    private ImageView btnGitHub;
    private String urlLinkedin;
    private String urlGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);


        autor = findViewById(R.id.textAutor);
        disciplina = findViewById(R.id.textDisciplina);
        mensagem = findViewById(R.id.textMessagem);
        btnLinkedin = findViewById(R.id.linkedin);
        btnGitHub = findViewById(R.id.github);
        btnGitHub.setClickable(true);
        btnLinkedin.setClickable(true);

        btnGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlGithub));
                startActivity(intent);
            }
        });
        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlLinkedin));
                startActivity(intent);
            }
        });


        new AsyncTask<Void,Sobre, Sobre>() {
            @Override
            protected Sobre doInBackground(Void... voids) {
                SobreDAO sobreDao = AppDatabase.getInstance(getApplicationContext()).createSobreDAO();


                return sobreDao.getSobre();
            }

            @Override
            protected void onPostExecute(Sobre sobre) {
                super.onPostExecute(sobre);
                infosSobre(sobre);


            }
        }.execute();
    }

    private void infosSobre(Sobre sobre){

        autor.setText(sobre.getNome());
        disciplina.setText(sobre.getDisciplina());
        mensagem.setText(sobre.getMensagem());
        urlGithub = sobre.getGithub();
        urlLinkedin = sobre.getLinkedin();

    }
}