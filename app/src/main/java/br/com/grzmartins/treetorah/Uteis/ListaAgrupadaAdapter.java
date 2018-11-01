package br.com.grzmartins.treetorah.Uteis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.grzmartins.treetorah.ListaAgrupadaActivity;
import br.com.grzmartins.treetorah.R;
import br.com.grzmartins.treetorah.model.TreeTorahModel;
import br.com.grzmartins.treetorah.repository.TreeTorahRepository;

public class ListaAgrupadaAdapter extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;

    List<TreeTorahModel> treeTorahModel =  new ArrayList<TreeTorahModel>();

    TreeTorahRepository treeTorahRepository;

    private ListaAgrupadaActivity listaAgrupadaActivity;

    public ListaAgrupadaAdapter(ListaAgrupadaActivity listaAgrupadaActivity, List<TreeTorahModel> treeTorahModel) {

        this.treeTorahModel       =  treeTorahModel;
        this.listaAgrupadaActivity  =  listaAgrupadaActivity;
        this.layoutInflater     = (LayoutInflater) this.listaAgrupadaActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.treeTorahRepository   = new TreeTorahRepository(listaAgrupadaActivity);

    }

    @Override
    public int getCount() {
        return treeTorahModel.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_lista_agrupada,null);



        return null;
    }
}
