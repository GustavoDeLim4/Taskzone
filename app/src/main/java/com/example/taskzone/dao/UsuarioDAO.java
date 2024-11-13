package com.example.taskzone.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.taskzone.helper.BancoDeDadosHelper;
import com.example.taskzone.model.Usuario;

public class UsuarioDAO {
    private SQLiteDatabase db;

    public UsuarioDAO(Context context) {
        BancoDeDadosHelper dbHelper = new BancoDeDadosHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long inserirUsuario(@NonNull Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("sobrenome", usuario.getSobrenome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        return db.insert("usuarios", null, values);
    }

    public boolean validarLogin(String email, String senha) {
        String query = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, senha});
        boolean loginValido = cursor.getCount() > 0;
        cursor.close();
        return loginValido;
    }
}
