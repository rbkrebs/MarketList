package com.example.marketlist.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SobreApp extends Application {

    private static SobreApp sobreApp;
    private static SobreApp getInstance() { return sobreApp;};

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("sobre.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
    @Override
    public void onTerminate() {
        //finaliza o Realm quando encerra a execução do app
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}
