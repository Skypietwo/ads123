package com.example.projetofinal;








import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.MainActivity;
import com.example.projetofinal.R;

public class DetailsActivity extends AppCompatActivity {

    TextView tid,tcpf,tcodespec,tcodprof,tcodproced,tdataproced,tdescrproced,tlinkproced, tautvis;
    int posicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        tid = findViewById(R.id.pcid);
        tcpf = findViewById(R.id.pcpf_cli);
        tcodespec = findViewById(R.id.pcod_espec);
        tcodprof = findViewById(R.id.pcod_prof);
        tcodproced = findViewById(R.id.pcod_proced);
        tdataproced = findViewById(R.id.pdata_proced);
        tdescrproced = findViewById(R.id.pdescr_proced);
        tlinkproced = findViewById(R.id.plink_proced);
        tautvis = findViewById(R.id.paut_vis_cli);



        Intent intent = getIntent();
        posicao = intent.getExtras().getInt("posicao");

        tid.setText("ID: "+MainActivity4.listaFuncionarios.get(posicao).getId());
        tcpf.setText("CPF: " + MainActivity4.listaFuncionarios.get(posicao).getCpf_cli());
        tcodespec.setText("Codigo Especial: " + MainActivity4.listaFuncionarios.get(posicao).getCod_espec());
        tcodprof.setText("Codigo Prof: " + MainActivity4.listaFuncionarios.get(posicao).getCod_prof());
        tcodproced.setText("Codigo Proced: " + MainActivity4.listaFuncionarios.get(posicao).getCod_proced());
        tdataproced.setText("Data Proced: " + MainActivity4.listaFuncionarios.get(posicao).getData_proced());
        tdescrproced.setText("Descricao Proced: " + MainActivity4.listaFuncionarios.get(posicao).getDescr_proced());
        tlinkproced.setText("Link Proced: " + MainActivity4.listaFuncionarios.get(posicao).getLink_proced());
        tautvis.setText("Auto Vis: " + MainActivity4.listaFuncionarios.get(posicao).getAut_vis_cli());






    }
}