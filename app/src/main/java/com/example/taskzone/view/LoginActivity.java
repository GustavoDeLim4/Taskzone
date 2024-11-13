package com.example.taskzone.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taskzone.R;
import com.example.taskzone.dao.UsuarioDAO;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtSenha;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        usuarioDAO = new UsuarioDAO(this);
    }

    public void fazerLogin(View view) {
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        if (usuarioDAO.validarLogin(email, senha)) {
            startActivity(new Intent(this, DashboardActivity.class));
        } else {
            Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirRegistrar(View view) {
        startActivity(new Intent(this, RegistrarActivity.class));
    }

    public void abrirEsqueciSenha(View view) {
        startActivity(new Intent(this, EsqueciSenhaActivity.class));
    }
}

