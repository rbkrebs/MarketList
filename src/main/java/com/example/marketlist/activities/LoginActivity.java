package com.example.marketlist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marketlist.R;
import com.example.marketlist.fragments.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);



        if(usuarioLogado()){
            openMainWindow();
        }
        else {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {
                        validateLogin(edtEmail.getText().toString(), edtSenha.getText().toString());
                    } else
                        Toast.makeText(LoginActivity.this, "Informe email e senha!", Toast.LENGTH_SHORT).show();
                }
            });

        }

        mAuth = FirebaseAuth.getInstance();

    }

    private Boolean usuarioLogado(){
        //Se o usuário já está logado não precisa fazer login novamente

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null) return false;
        return true;
    }
    private void validateLogin(String email, String senha){


        mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    openMainWindow();
                    Toast.makeText(LoginActivity.this, "sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Dados de login inválidos!", Toast.LENGTH_SHORT).show();
                    Log.d("LOGIN", "dados inválidos!");
                }

            }
        });

    }

    private void openMainWindow(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}