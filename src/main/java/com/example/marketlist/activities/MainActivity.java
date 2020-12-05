package com.example.marketlist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marketlist.R;
import com.example.marketlist.dao.AppDatabase;
import com.example.marketlist.dao.SobreDAO;
import com.example.marketlist.entity.Sobre;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        NavigationUI.setupWithNavController(bottomNavigationView,
                Navigation.findNavController(this, R.id.nav_host_fragment));

        new AsyncTask<Void,Integer, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                SobreDAO sobreDao = AppDatabase.getInstance(getApplicationContext()).createSobreDAO();
                Sobre sobre = new Sobre();
                sobre.setNome("Rômulo Basso Krebs");
                sobre.setDisciplina("Programação para Web III – APNP 2020");
                sobre.setMensagem("Sou um técnico de laboratório em transição de carreira.");
                sobre.setGithub("https://github.com/rbkrebs/MarketList");
                sobre.setLinkedin("https://www.linkedin.com/in/romulo-krebs/");

                if (sobreDao.getSobre() == null){

                    sobreDao.insert(sobre);
                    return sobre.getId();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Integer id) {

            }
        }.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_settings){
            Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_logout){
            FirebaseAuth.getInstance().signOut();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}