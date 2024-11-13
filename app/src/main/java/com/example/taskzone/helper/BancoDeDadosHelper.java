package com.example.taskzone.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDadosHelper extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "taskzone.db";
    private static final int VERSAO_BANCO = 1;

    public BancoDeDadosHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da tabela de usuários
        String criarTabelaUsuario = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, sobrenome TEXT, email TEXT, senha TEXT)";
        db.execSQL(criarTabelaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualização do banco de dados
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
