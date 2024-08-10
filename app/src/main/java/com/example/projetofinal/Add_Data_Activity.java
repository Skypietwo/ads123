package com.example.projetofinal;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Add_Data_Activity extends AppCompatActivity {

    EditText txtcpf_cli, txtnome_cli, txtcod_cli, txttel_cli, txtcep_cli, txtlogra_cli, txtnum_logra_cli, txtcompl_cli, txtbairro_cli, txtcidade_cli, txtuf_cli, txtrg_cli, txtest_rg_cli, txtnome_mae_cli, txtdata_nasc_cli;

    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        txtcpf_cli = findViewById(R.id.edtCpf_cli);
        txtnome_cli = findViewById(R.id.edtNome_cli);
        txtcod_cli = findViewById(R.id.edtCod_cli);
        txttel_cli = findViewById(R.id.edtTel_cli);
        txtcep_cli = findViewById(R.id.edtCep_cli);
        txtlogra_cli = findViewById(R.id.edtLogra_cli);
        txtnum_logra_cli = findViewById(R.id.edtNum_logra_cli);
        txtcompl_cli = findViewById(R.id.edtCompl_cli);
        txtbairro_cli = findViewById(R.id.edtBairro_cli);
        txtcidade_cli = findViewById(R.id.edtCidade_cli);
        txtuf_cli = findViewById(R.id.edtUf_cli);
        txtrg_cli = findViewById(R.id.edtRg_cli);
        txtest_rg_cli = findViewById(R.id.edtEst_rg_cli);
        txtnome_mae_cli = findViewById(R.id.edtNome_mae_cli);
        txtdata_nasc_cli = findViewById(R.id.edtData_nasc_cli);
        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {
        final String cpf_cli = txtcpf_cli.getText().toString().trim();
        final String nome_cli = txtnome_cli.getText().toString().trim();
        final String cod_cli = txtcod_cli.getText().toString().trim();
        final String tel_cli = txttel_cli.getText().toString().trim();
        final String cep_cli = txtcep_cli.getText().toString().trim();
        final String logra_cli = txtlogra_cli.getText().toString().trim();
        final String num_logra_cli = txtnum_logra_cli.getText().toString().trim();  // Assumindo que há um campo para o número do logradouro
        final String compl_cli = txtcompl_cli.getText().toString().trim();
        final String bairro_cli = txtbairro_cli.getText().toString().trim();
        final String cidade_cli =  txtcidade_cli.getText().toString().trim();
        final String uf_cli = txtuf_cli .getText().toString().trim();  // Assumindo que "estado" é o mesmo que "uf"
        final String rg_cli = txtrg_cli.getText().toString().trim();
        final String est_rg_cli = txtest_rg_cli.getText().toString().trim();
        final String nome_mae_cli = txtnome_mae_cli.getText().toString().trim();
        final String data_nasc_cli = txtdata_nasc_cli.getText().toString().trim();


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        if (cpf_cli.isEmpty()) {
            Toast.makeText(this, "Enter CPF", Toast.LENGTH_SHORT).show();
        } else if (nome_cli.isEmpty()) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
        } else if (cod_cli.isEmpty()) {
            Toast.makeText(this, "Enter Codigo", Toast.LENGTH_SHORT).show();
        } else if (tel_cli.isEmpty()) {
            Toast.makeText(this, "Enter Telefone", Toast.LENGTH_SHORT).show();
        } else if (cep_cli.isEmpty()) {
            Toast.makeText(this, "Enter CEP", Toast.LENGTH_SHORT).show();
        } else if (logra_cli.isEmpty()) {
            Toast.makeText(this, "Enter Logradouro", Toast.LENGTH_SHORT).show();
        } else if (num_logra_cli.isEmpty()) {  // Assumindo que há uma variável para o número do logradouro
            Toast.makeText(this, "Enter Número do Logradouro", Toast.LENGTH_SHORT).show();
        } else if (compl_cli.isEmpty()) {
            Toast.makeText(this, "Enter Complemento", Toast.LENGTH_SHORT).show();
        } else if (bairro_cli.isEmpty()) {
            Toast.makeText(this, "Enter Bairro", Toast.LENGTH_SHORT).show();
        } else if (cidade_cli.isEmpty()) {
            Toast.makeText(this, "Enter Cidade", Toast.LENGTH_SHORT).show();
        } else if (uf_cli.isEmpty()) {  // Assumindo que "estado" é o mesmo que "uf"
            Toast.makeText(this, "Enter Estado", Toast.LENGTH_SHORT).show();
        } else if (rg_cli.isEmpty()) {
            Toast.makeText(this, "Enter RG", Toast.LENGTH_SHORT).show();
        } else if (est_rg_cli.isEmpty()) {
            Toast.makeText(this, "Enter Estado do RG", Toast.LENGTH_SHORT).show();
        } else if (nome_mae_cli.isEmpty()) {
            Toast.makeText(this, "Enter Nome da Mãe", Toast.LENGTH_SHORT).show();
        } else if (data_nasc_cli.isEmpty()) {
            Toast.makeText(this, "Enter Data de Nascimento", Toast.LENGTH_SHORT).show();
        } else {
            // Código para continuar o processamento


            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/insert.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("Paciente Inserted")) {
                                Toast.makeText(Add_Data_Activity.this, "Paciente Inserted", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Add_Data_Activity.this, response, Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_Data_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("cpf_cli", cpf_cli);
                    params.put("nome_cli", nome_cli);
                    params.put("cod_cli", cod_cli);
                    params.put("tel_cli", tel_cli);
                    params.put("cep_cli", cep_cli);
                    params.put("logra_cli", logra_cli);
                    params.put("num_logra_cli", num_logra_cli);
                    params.put("compl_cli", compl_cli);
                    params.put("bairro_cli", bairro_cli);
                    params.put("cidade_cli", cidade_cli);
                    params.put("uf_cli", uf_cli);
                    params.put("rg_cli", rg_cli);
                    params.put("est_rg_cli", est_rg_cli);
                    params.put("nome_mae_cli", nome_mae_cli);
                    params.put("data_nasc_cli", data_nasc_cli);
                    return params;
                }


            };
            RequestQueue requestQueue = Volley.newRequestQueue(Add_Data_Activity.this);
            requestQueue.add(request);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}