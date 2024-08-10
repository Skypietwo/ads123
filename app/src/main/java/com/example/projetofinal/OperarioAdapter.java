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

public class OperarioAdapter extends ArrayAdapter<Operario> {

    Context mContext;
    List<Operario> listaOperarios;

    public OperarioAdapter(@NonNull Context context, ArrayList<Operario> listaOperarios) {
        super(context, R.layout.cus_list_item, listaOperarios);
        this.mContext = context;
        this.listaOperarios = listaOperarios;
    }

    private static class ViewHolder {
        TextView tvCpf_cli;
        TextView tvCod_espec;
    }

    @NonNull
    @Override
    public View getView(int posicao, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // Inflate the custom layout
            convertView = LayoutInflater.from(mContext).inflate(R.layout.cus_list_item, parent, false);
            // Initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.tvCpf_cli = convertView.findViewById(R.id.r_cpf_cli);
            viewHolder.tvCod_espec = convertView.findViewById(R.id.r_cod_espec);
            // Tag the view holder to the view
            convertView.setTag(viewHolder);
        } else {
            // Reuse the view holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the data item for this position
        Operario operario = listaOperarios.get(posicao);

        // Populate the data into the template view using the view holder
        viewHolder.tvCpf_cli.setText(operario.getCpf_cli());
        viewHolder.tvCod_espec.setText(operario.getCod_espec());

        // Return the completed view to render on screen
        return convertView;
    }
}
