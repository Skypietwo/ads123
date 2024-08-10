package com.example.projetofinal;




import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Edit_Activity extends AppCompatActivity {

    EditText edId,edCpf_cli, edNome_cli, edCod_cli, edTel_cli, edCep_cli, edLogra_cli, edNum_logra_cli, edCompl_cli, edBairro_cli, edCidade_cli, edUf_cli, edRg_cli, edEst_rg_cli, edNome_mae_cli, edData_nasc_cli;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edId = findViewById(R.id.e_Id);
        edCpf_cli = findViewById(R.id.e_Cpf_cli);
        edNome_cli = findViewById(R.id.e_Nome_cli);
        edCod_cli = findViewById(R.id.e_Cod_cli);
        edTel_cli = findViewById(R.id.e_Tel_cli);
        edCep_cli = findViewById(R.id.e_Cep_cli);
        edLogra_cli = findViewById(R.id.e_Logra_cli);
        edNum_logra_cli = findViewById(R.id.e_Num_logra_cli);
        edCompl_cli = findViewById(R.id.e_Compl_cli);
        edBairro_cli = findViewById(R.id.e_Bairro_cli);
        edCidade_cli = findViewById(R.id.e_Cidade_cli);
        edUf_cli = findViewById(R.id.e_Uf_cli);
        edRg_cli = findViewById(R.id.e_Rg_cli);
        edEst_rg_cli = findViewById(R.id.e_Est_rg_cli);
        edNome_mae_cli = findViewById(R.id.e_Nome_mae_cli);
        edData_nasc_cli = findViewById(R.id.e_Data_nasc_cli);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        edId.setText(MainActivity3.employeeArrayList.get(position).getId());
        edCpf_cli.setText(MainActivity3.employeeArrayList.get(position).getCpf_cli());
        edNome_cli.setText(MainActivity3.employeeArrayList.get(position).getNome_cli());
        edCod_cli.setText(MainActivity3.employeeArrayList.get(position).getCod_cli());
        edTel_cli.setText(MainActivity3.employeeArrayList.get(position).getTel_cli());
        edCep_cli.setText(MainActivity3.employeeArrayList.get(position).getCep_cli());
        edLogra_cli.setText(MainActivity3.employeeArrayList.get(position).getLogra_cli());
        edNum_logra_cli.setText(MainActivity3.employeeArrayList.get(position).getNum_logra_cli());  // Ajuste se necessário, assumindo que há um campo para número de logradouro
        edCompl_cli.setText(MainActivity3.employeeArrayList.get(position).getCompl_cli());
        edBairro_cli.setText(MainActivity3.employeeArrayList.get(position).getBairro_cli());
        edCidade_cli.setText(MainActivity3.employeeArrayList.get(position).getCidade_cli());
        edUf_cli.setText(MainActivity3.employeeArrayList.get(position).getUf_cli());
        edRg_cli.setText(MainActivity3.employeeArrayList.get(position).getRg_cli());
        edEst_rg_cli.setText(MainActivity3.employeeArrayList.get(position).getEst_rg_cli());
        edNome_mae_cli.setText(MainActivity3.employeeArrayList.get(position).getNome_mae_cli());
        edData_nasc_cli.setText(MainActivity3.employeeArrayList.get(position).getData_nasc_cli());


    }

    public void btn_updateData(View view) {
        final String cpf_cli = edCpf_cli.getText().toString().trim();
        final String nome_cli = edNome_cli.getText().toString().trim();
        final String cod_cli = edCod_cli.getText().toString().trim();
        final String tel_cli = edTel_cli.getText().toString().trim();
        final String cep_cli = edCep_cli.getText().toString().trim();
        final String logra_cli = edLogra_cli.getText().toString().trim();
        final String num_logra_cli =   edNum_logra_cli.getText().toString().trim();  // Assumindo que há um campo para o número do logradouro
        final String compl_cli = edCompl_cli.getText().toString().trim();
        final String bairro_cli = edBairro_cli.getText().toString().trim();
        final String cidade_cli = edCidade_cli.getText().toString().trim();
        final String uf_cli = edUf_cli.getText().toString().trim();  // Assumindo que "estado" é o mesmo que "uf"
        final String rg_cli = edRg_cli.getText().toString().trim();
        final String est_rg_cli = edEst_rg_cli.getText().toString().trim();
        final String nome_mae_cli =  edNome_mae_cli.getText().toString().trim();
        final String data_nasc_cli = edData_nasc_cli.getText().toString().trim();
        final String id = edId.getText().toString().trim();




        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/update.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Edit_Activity.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Edit_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("id", id);
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

        RequestQueue requestQueue = Volley.newRequestQueue(Edit_Activity.this);
        requestQueue.add(request);
    }
}
