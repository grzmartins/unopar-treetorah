package br.com.grzmartins.treetorah.Uteis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUtil extends SQLiteOpenHelper {

    private static final String DB_NAME = "treetorah.db";

    private static final int DB_VENSION = 1;

    public DatabaseUtil(Context context) {

        super(context, DB_NAME, null, DB_VENSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder stringBuilderCreateTable = new StringBuilder();
        stringBuilderCreateTable.append(" CREATE TABLE IF NOT EXISTS treetorah (");
        stringBuilderCreateTable.append(" id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append(" ano integer NOT NULL, ");
        stringBuilderCreateTable.append(" estado TEXT NOT NULL, ");
        stringBuilderCreateTable.append(" arvores_cortadas integer NOT NULL, ");
        stringBuilderCreateTable.append(" arvores_repostas integer NOT NULL, ");
        stringBuilderCreateTable.append(" volume integer NOT NULL, ");
        stringBuilderCreateTable.append(" valor REAL NOT NULL ) ");

        db.execSQL(stringBuilderCreateTable.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS treetorah");
        onCreate(db);

    }

    public SQLiteDatabase getConnectionDataBase() {

        return this.getWritableDatabase();
    }

}
