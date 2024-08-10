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

public class ProtegeAdapter extends ArrayAdapter<Protege> {

    Context mContext;
    List<Protege> listaProtege;

    public ProtegeAdapter(@NonNull Context context, ArrayList<Protege> listaProtege) {
        super(context, R.layout.cust_list_item, listaProtege);
        this.mContext = context;
        this.listaProtege = listaProtege;
    }

    private static class ViewHolder {
        TextView tvID;
        TextView tvStatus;
    }

    @NonNull
    @Override
    public View getView(int posicao, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // Inflate the custom layout
            convertView = LayoutInflater.from(mContext).inflate(R.layout.cust_list_item, parent, false);
            // Initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.tvID  = convertView.findViewById(R.id.n_id);
            viewHolder.tvStatus = convertView.findViewById(R.id.n_status);
            // Tag the view holder to the view
            convertView.setTag(viewHolder);
        } else {
            // Reuse the view holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the data item for this position
        Protege protege = listaProtege.get(posicao);

        // Populate the data into the template view using the view holder
        viewHolder.tvID.setText(protege.getId());
        viewHolder.tvStatus.setText(protege.getStatus());

        // Return the completed view to render on screen
        return convertView;
    }
}
