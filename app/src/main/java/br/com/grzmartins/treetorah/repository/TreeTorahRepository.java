package br.com.grzmartins.treetorah.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.grzmartins.treetorah.Uteis.DatabaseUtil;
import br.com.grzmartins.treetorah.model.TreeTorahModel;


public class TreeTorahRepository {

    int fatorVolume = 6;
    double fatorValor = .75;

    DatabaseUtil databaseUtil;

    public TreeTorahRepository(Context context) {

        databaseUtil = new DatabaseUtil(context);

    }

    public void save(TreeTorahModel treeTorahModel) {

        ContentValues contentValues = new ContentValues();

        int volume = Math.round(treeTorahModel.getArvoresCortadas() / fatorVolume);

        double valor = ((treeTorahModel.getArvoresCortadas() - treeTorahModel.getArvoresRepostas()) * fatorValor);

        DecimalFormat f = new DecimalFormat("##.00");

        contentValues.put("ano", treeTorahModel.getAno());
        contentValues.put("estado", treeTorahModel.getEstado());
        contentValues.put("arvores_cortadas", treeTorahModel.getArvoresCortadas());
        contentValues.put("arvores_repostas", treeTorahModel.getArvoresRepostas());
        contentValues.put("volume", volume);
        contentValues.put("valor", f.format(valor));

        if (treeTorahModel.getId() > 0) {
            databaseUtil.getConnectionDataBase().update("treetorah", contentValues, "id = ?", new String[]{Integer.toString(treeTorahModel.getId())});
        } else {
            databaseUtil.getConnectionDataBase().insert("treetorah", null, contentValues);
        }

    }

    public Integer delete(int id) {
        return databaseUtil.getConnectionDataBase().delete("treetorah", "id = ?", new String[]{Integer.toString(id)});
    }

    public TreeTorahModel getDataEdit(int id) {

        Cursor cursor = databaseUtil.getConnectionDataBase().rawQuery("SELECT * FROM treetorah WHERE id= " + id, null);

        cursor.moveToFirst();

        TreeTorahModel treeTorahModel =  new TreeTorahModel();

        treeTorahModel.setId(cursor.getInt(cursor.getColumnIndex("id")));
        treeTorahModel.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
        treeTorahModel.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
        treeTorahModel.setArvoresCortadas(cursor.getInt(cursor.getColumnIndex("arvores_cortadas")));
        treeTorahModel.setArvoresRepostas(cursor.getInt(cursor.getColumnIndex("arvores_repostas")));
        treeTorahModel.setVolume(cursor.getInt(cursor.getColumnIndex("volume")));
        treeTorahModel.setValor(cursor.getInt(cursor.getColumnIndex("valor")));

        return treeTorahModel;

    }

    public List<TreeTorahModel> getDataGroup() {

        List<TreeTorahModel> dataSource = new ArrayList<TreeTorahModel>();

        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id, ano, estado, ");
        stringBuilderQuery.append(" SUM(arvores_cortadas) AS arvores_cortadas, ");
        stringBuilderQuery.append(" SUM(arvores_repostas) AS arvores_repostas, ");
        stringBuilderQuery.append(" SUM(volume) AS volume, ");
        stringBuilderQuery.append(" SUM(valor) AS valor ");
        stringBuilderQuery.append(" FROM  treetorah ");
        stringBuilderQuery.append(" GROUP BY estado ");
        stringBuilderQuery.append(" ORDER BY estado ");

        Cursor cursor = databaseUtil.getConnectionDataBase().rawQuery(stringBuilderQuery.toString(), null);

        cursor.moveToFirst();

        TreeTorahModel treeTorahModel;

        while (!cursor.isAfterLast()) {

            treeTorahModel =  new TreeTorahModel();

            treeTorahModel.setId(cursor.getInt(cursor.getColumnIndex("id")));
            treeTorahModel.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
            treeTorahModel.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            treeTorahModel.setArvoresCortadas(cursor.getInt(cursor.getColumnIndex("arvores_cortadas")));
            treeTorahModel.setArvoresRepostas(cursor.getInt(cursor.getColumnIndex("arvores_repostas")));
            treeTorahModel.setVolume(cursor.getInt(cursor.getColumnIndex("volume")));
            treeTorahModel.setValor(cursor.getInt(cursor.getColumnIndex("valor")));

            dataSource.add(treeTorahModel);

            cursor.moveToNext();

        }

        return dataSource;

    }

    public List<TreeTorahModel> getDataState(String state) {

        List<TreeTorahModel> dataSource = new ArrayList<TreeTorahModel>();

        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id, ano, estado, ");
        stringBuilderQuery.append(" arvores_cortadas,  arvores_repostas, ");
        stringBuilderQuery.append(" volume, valor ");
        stringBuilderQuery.append(" FROM treetorah ");
        stringBuilderQuery.append(" WHERE estado = '" + state + "'");
        stringBuilderQuery.append(" ORDER BY estado ");

        Cursor cursor = databaseUtil.getConnectionDataBase().rawQuery(stringBuilderQuery.toString(), null);

        cursor.moveToFirst();

        TreeTorahModel treeTorahModel;

        while (!cursor.isAfterLast()) {

            treeTorahModel =  new TreeTorahModel();

            treeTorahModel.setId(cursor.getInt(cursor.getColumnIndex("id")));
            treeTorahModel.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
            treeTorahModel.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            treeTorahModel.setArvoresCortadas(cursor.getInt(cursor.getColumnIndex("arvores_cortadas")));
            treeTorahModel.setArvoresRepostas(cursor.getInt(cursor.getColumnIndex("arvores_repostas")));
            treeTorahModel.setVolume(cursor.getInt(cursor.getColumnIndex("volume")));
            treeTorahModel.setValor(cursor.getInt(cursor.getColumnIndex("valor")));

            dataSource.add(treeTorahModel);

            cursor.moveToNext();

        }

        return dataSource;

    }

}
