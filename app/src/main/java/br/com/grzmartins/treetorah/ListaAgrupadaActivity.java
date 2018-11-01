package br.com.grzmartins.treetorah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListaAgrupadaActivity extends AppCompatActivity {

    ListView listaAgrupada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agrupada);

        this.CriarComponentes();

        this.CarregadoLista();

        Button button_novo = findViewById(R.id.button_novo);
        button_novo.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intentRedirect = new Intent(getApplicationContext(), CadastroActivity.class);
                        startActivity(intentRedirect);
                        finish();
                    }
                }
        );
    }

    protected void CriarComponentes() {
        listaAgrupada = (ListView) this.findViewById(R.id.listaAgrupada);
    }

    protected void CarregadoLista() {

        String[] itens = new String[2];

        itens[0] = "Cadastrar";
        itens[1] = "Consultar";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);


        listaAgrupada.setAdapter(arrayItens);

    }
}
