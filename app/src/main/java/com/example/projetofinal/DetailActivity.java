package com.example.projetofinal;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.R;

public class DetailActivity extends AppCompatActivity {

    TextView tvid, tvcpf_cli,tvnome_cli,tvcod_cli,tvtel_cli,tvcep_cli,tvlogra_cli,tvnum_logra_cli,tvcompl_cli,tvbairro_cli, tvcidade_cli, tvuf_cli, tvrg_cli, tvest_rg_cli,tvnome_mae_cli,tvdata_nasc_cli;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail );

        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvcpf_cli = findViewById(R.id.txtcpf_cli);
        tvnome_cli = findViewById(R.id.txtnome_cli);
        tvcod_cli = findViewById(R.id.txtcod_cli);
        tvtel_cli = findViewById(R.id.txttel_cli);
        tvcep_cli = findViewById(R.id.txtcep_cli);
        tvlogra_cli = findViewById(R.id.txtlogra_cli);
        tvnum_logra_cli = findViewById(R.id.txtnum_logra_cli);
        tvcompl_cli = findViewById(R.id.txtcompl_cli);
        tvbairro_cli = findViewById(R.id.txtbairro_cli);
        tvcidade_cli = findViewById(R.id.txtcidade_cli);
        tvuf_cli = findViewById(R.id.txtuf_cli);
        tvrg_cli = findViewById(R.id.txtrg_cli);
        tvest_rg_cli = findViewById(R.id.txtest_rg_cli);
        tvnome_mae_cli = findViewById(R.id.txtnome_mae_cli);
        tvdata_nasc_cli = findViewById(R.id.txtdata_nasc_cli);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvcpf_cli .setText("CPF: " + MainActivity3.employeeArrayList.get(position).getCpf_cli());
        tvnome_cli.setText("Nome: " + MainActivity3.employeeArrayList.get(position).getNome_cli());
        tvcod_cli.setText("Codigo: " + MainActivity3.employeeArrayList.get(position).getCod_cli());
        tvtel_cli.setText("Telefone: " + MainActivity3.employeeArrayList.get(position).getTel_cli());
        tvcep_cli.setText("CEP: " + MainActivity3.employeeArrayList.get(position).getCep_cli());
        tvlogra_cli.setText("Logradouro: " + MainActivity3.employeeArrayList.get(position).getLogra_cli());
        tvnum_logra_cli.setText("Número do Logradouro: " + MainActivity3.employeeArrayList.get(position).getNum_logra_cli());  // Assumindo que há um campo para o número do logradouro
        tvcompl_cli.setText("Complemento: " + MainActivity3.employeeArrayList.get(position).getCompl_cli());
        tvbairro_cli.setText("Bairro: " + MainActivity3.employeeArrayList.get(position).getBairro_cli());
        tvcidade_cli.setText("Cidade: " + MainActivity3.employeeArrayList.get(position).getCidade_cli());
        tvuf_cli.setText("Estado: " + MainActivity3.employeeArrayList.get(position).getUf_cli());
        tvrg_cli.setText("RG: " + MainActivity3.employeeArrayList.get(position).getRg_cli());
        tvest_rg_cli.setText("Estado Emissão RG: " + MainActivity3.employeeArrayList.get(position).getEst_rg_cli());
        tvnome_mae_cli.setText("Nome Mãe: " + MainActivity3.employeeArrayList.get(position).getNome_mae_cli());
        tvdata_nasc_cli.setText("Data de Nascimento: " + MainActivity3.employeeArrayList.get(position).getData_nasc_cli());

    }
}
