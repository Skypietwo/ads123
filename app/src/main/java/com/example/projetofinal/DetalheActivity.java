package com.example.projetofinal;




import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.MainActivity;
import com.example.projetofinal.R;

public class DetalheActivity extends AppCompatActivity {

    TextView  tcpf_cli,tcod_espec,tcod_prof,tcod_proced,tdata_proced,tdescr_proced,tlink_proced, taut_vis_cli;
    int posicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tcpf_cli = findViewById(R.id.pcpf_cli);
        tcod_espec = findViewById(R.id.pcod_espec);
        tcod_prof = findViewById(R.id.pcod_prof);
        tcod_proced = findViewById(R.id.pcod_proced);
        tdata_proced = findViewById(R.id.pdata_proced);
        tdescr_proced = findViewById(R.id.pdescr_proced);
        tlink_proced = findViewById(R.id.plink_proced);
        taut_vis_cli = findViewById(R.id.paut_vis_cli);



        Intent intent = getIntent();
        posicao = intent.getExtras().getInt("posicao");

        tcpf_cli.setText("CPF: " + MainActivity6.listaOperario.get(posicao).getCpf_cli());
        tcod_espec.setText("Codigo Especial: " + MainActivity6.listaOperario.get(posicao).getCod_espec());
        tcod_prof.setText("Codigo Prof: " + MainActivity6.listaOperario.get(posicao).getCod_prof());
        tcod_proced.setText("Codigo Proced: " + MainActivity6.listaOperario.get(posicao).getCod_proced());
        tdata_proced.setText("Data Proced: " + MainActivity6.listaOperario.get(posicao).getData_proced());
        tdescr_proced.setText("Descricao Proced: " + MainActivity6.listaOperario.get(posicao).getDescr_proced());
        tlink_proced.setText("Link Proced: " + MainActivity6.listaOperario.get(posicao).getLink_proced());
        taut_vis_cli.setText("Auto Vis: " + MainActivity6.listaOperario.get(posicao).getAut_vis_cli());






    }
}