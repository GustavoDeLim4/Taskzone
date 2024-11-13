package com.example.taskzone.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taskzone.R;
import com.example.taskzone.dao.UsuarioDAO;
import com.example.taskzone.model.Usuario;

public class RegistrarActivity extends AppCompatActivity {
    private EditText edtNome, edtSobrenome, edtEmail, edtSenha;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtNome = findViewById(R.id.edtNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        usuarioDAO = new UsuarioDAO(this);
    }

    public void registrarUsuario(View view) {
        Usuario usuario = new Usuario();
        usuario.setNome(edtNome.getText().toString());
        usuario.setSobrenome(edtSobrenome.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());

        long id = usuarioDAO.inserirUsuario(usuario);  // Corrigido aqui
        if (id > 0) {
            Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao registrar usuário.", Toast.LENGTH_SHORT).show();
        }
    }
}
