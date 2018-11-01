package br.com.grzmartins.treetorah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.grzmartins.treetorah.Uteis.Uteis;
import br.com.grzmartins.treetorah.model.TreeTorahModel;
import br.com.grzmartins.treetorah.repository.TreeTorahRepository;

public class CadastroActivity extends AppCompatActivity {


    EditText editar_id;
    Spinner editar_estado;
    EditText editar_ano;
    EditText editar_arvores_cortadas;
    EditText editar_arvores_repostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.CriarComponentes();

        this.CarregarEstados();
    }


    protected void CriarComponentes() {

        editar_id = this.findViewById(R.id.editar_id);
        editar_estado = findViewById(R.id.editar_estado);
        editar_ano = this.findViewById(R.id.editar_ano);
        editar_arvores_cortadas = this.findViewById(R.id.editar_arvores_cortadas);
        editar_arvores_repostas = this.findViewById(R.id.editar_arvores_repostas);

    }

    public void CarregarEstados() {

        List<String> list = new ArrayList<String>();

        list.add("Acre");
        list.add("Alagoas");
        list.add("Amapá");
        list.add("Amazonas");
        list.add("Bahia");
        list.add("Ceará");
        list.add("Distrito Federal");
        list.add("Espírito Santo");
        list.add("Goiás");
        list.add("Maranhão");
        list.add("Mato Grosso");
        list.add("Mato Grosso do Sul");
        list.add("Minas Gerais");
        list.add("Pará");
        list.add("Paraíba");
        list.add("Paraná");
        list.add("Pernambuco");
        list.add("Piauí");
        list.add("Rio de Janeiro");
        list.add("Rio Grande do Norte");
        list.add("Rio Grande do Sul");
        list.add("Rondônia");
        list.add("Roraima");
        list.add("Santa Catarina");
        list.add("São Paulo");
        list.add("Sergipe");
        list.add("Tocantins");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        editar_estado.setAdapter(dataAdapter);

    }

    public void onclickSalvar(View view) {

        if (editar_estado.getSelectedItem().toString().trim().equals("")) {
            Uteis.Alert(this, this.getString(R.string.editar_estado_obrigatorio));
        } else if (editar_ano.getText().toString().trim().equals("")) {
            Uteis.Alert(this, this.getString(R.string.editar_ano_obrigatorio));
        }  else if (editar_arvores_cortadas.getText().toString().trim().equals("")) {
            Uteis.Alert(this, this.getString(R.string.editar_arvores_cortadas_obrigatorio));
        } else if (editar_arvores_repostas.getText().toString().trim().equals("")) {
            Uteis.Alert(this, this.getString(R.string.editar_arvores_repostas_obrigatorio));
        } else {

            TreeTorahModel treeTorahModel =  new TreeTorahModel();

            treeTorahModel.setEstado(editar_estado.getSelectedItem().toString().trim());
            treeTorahModel.setAno(Integer.parseInt(editar_ano.getText().toString().trim()));
            treeTorahModel.setArvoresCortadas(Integer.parseInt(editar_arvores_cortadas.getText().toString().trim()));
            treeTorahModel.setArvoresRepostas(Integer.parseInt(editar_arvores_repostas.getText().toString().trim()));

            new TreeTorahRepository(this).save(treeTorahModel);

            Uteis.Alert(this,this.getString(R.string.mensagem_success));

            this.onReset();

        }

    }

    protected void onReset() {

        editar_estado.setSelection(0);
        editar_ano.setText(null);
        editar_arvores_cortadas.setText(null);
        editar_arvores_repostas.setText(null);

        Intent intentRedirect = new Intent(getApplicationContext(), ListaAgrupadaActivity.class);
        startActivity(intentRedirect);
        finish();

    }



    public void onClickVoltar(View view) {

        this.onReset();

        Intent intentRedirect = new Intent(getApplicationContext(), ListaAgrupadaActivity.class);
        startActivity(intentRedirect);
        finish();
    }
}
