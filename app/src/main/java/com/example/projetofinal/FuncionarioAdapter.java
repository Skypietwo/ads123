package com.example.projetofinal;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioAdapter extends ArrayAdapter<Funcionario> {

    Context mContext;
    List<Funcionario> listaFuncionarios;

    public FuncionarioAdapter(@NonNull Context context, ArrayList<Funcionario> listaFuncionarios) {
        super(context, R.layout.custo_list_item, listaFuncionarios);
        this.mContext = context;
        this.listaFuncionarios = listaFuncionarios;
    }

    private static class ViewHolder {
        TextView tvID;
        TextView tvCodespec;
    }

    @NonNull
    @Override
    public View getView(int posicao, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // Inflate the custom layout
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custo_list_item, parent, false);
            // Initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.tvID = convertView.findViewById(R.id.t_id);
            viewHolder.tvCodespec = convertView.findViewById(R.id.t_cod_espec);
            // Tag the view holder to the view
            convertView.setTag(viewHolder);
        } else {
            // Reuse the view holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the data item for this position
        Funcionario funcionario = listaFuncionarios.get(posicao);

        // Populate the data into the template view using the view holder
        viewHolder.tvID.setText(funcionario.getId());
        viewHolder.tvCodespec.setText(funcionario.getCod_espec());

        // Return the completed view to render on screen
        return convertView;
    }
}
