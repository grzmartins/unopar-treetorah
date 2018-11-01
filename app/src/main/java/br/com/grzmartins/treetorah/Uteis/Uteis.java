package br.com.grzmartins.treetorah.Uteis;

import br.com.grzmartins.treetorah.R;
import android.app.AlertDialog;
import android.content.Context;

public class Uteis {

    public static void Alert(Context context, String mensagem){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(mensagem);
        alertDialog.setPositiveButton("OK", null);
        alertDialog.show();

    }
}
