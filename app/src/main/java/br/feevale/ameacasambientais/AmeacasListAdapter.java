package br.feevale.ameacasambientais;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AmeacasListAdapter extends BaseAdapter{
    Context ctx;
    AmeacaDB db;
    List<Ameaca> ameacas;
    LayoutInflater inflater;

    public AmeacasListAdapter(Context ctx, AmeacaDB db){
        this.ctx=ctx;
        this.db=db;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        ameacas = db.recuperarAmeacas();
        return ameacas.size();
    }

    @Override
    public Object getItem(int position) {
        ameacas = db.recuperarAmeacas();
        return ameacas.get(position);
    }

    @Override
    public long getItemId(int position) {
        ameacas = db.recuperarAmeacas();
        if(ameacas.size() == 0){
            return 0;
        }
        return ameacas.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ameacas = db.recuperarAmeacas();
        View row = inflater.inflate(R.layout.activity_main, parent, false);

        TextView txtNome = (TextView)row.findViewById(R.id.nomeAmeaca);
        TextView txtEnd = (TextView)row.findViewById(R.id.endAmeaca);
        TextView txtBairro = (TextView)row.findViewById(R.id.bairroAmeaca);
        TextView numImp = (TextView)row.findViewById(R.id.impAmeaca);

        txtNome.setText(ameacas.get(position).getNome());
        txtEnd.setText(ameacas.get(position).getEndereco());
        txtBairro.setText(ameacas.get(position).getBairro());
        numImp.setText(ameacas.get(position).getImpacto());

        return row;
    }

}
