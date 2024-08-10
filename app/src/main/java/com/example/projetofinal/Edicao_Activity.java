package com.example.projetofinal;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Edicao_Activity extends AppCompatActivity {

    EditText eCpf_cli, eCod_espec, eCod_prof, eCod_proced, eData_proced, eDescr_proced, eLink_proced, eAut_vis_cli;
    private int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        eCpf_cli = findViewById(R.id.ed_Cpf_cli);
        eCod_espec = findViewById(R.id.ed_Cod_espec);
        eCod_prof = findViewById(R.id.ed_Cod_prof);
        eCod_proced = findViewById(R.id.ed_Cod_proced);
        eData_proced = findViewById(R.id.ed_Data_proced);
        eDescr_proced = findViewById(R.id.ed_Descr_proced);
        eLink_proced = findViewById(R.id.ed_Link_proced);
        eAut_vis_cli = findViewById(R.id.ed_Aut_vis_cli);

        Intent intent = getIntent();
        posicao = intent.getExtras().getInt("posicao");

        eCpf_cli.setText(MainActivity6.listaOperario.get(posicao).getCpf_cli());
        eCod_espec.setText(MainActivity6.listaOperario.get(posicao).getCod_espec());
        eCod_prof.setText(MainActivity6.listaOperario.get(posicao).getCod_prof());
        eCod_proced.setText(MainActivity6.listaOperario.get(posicao).getCod_proced());
        eData_proced.setText(MainActivity6.listaOperario.get(posicao).getData_proced());
        eDescr_proced.setText(MainActivity6.listaOperario.get(posicao).getDescr_proced());
        eLink_proced.setText(MainActivity6.listaOperario.get(posicao).getLink_proced());
        eAut_vis_cli.setText(MainActivity6.listaOperario.get(posicao).getAut_vis_cli());
    }

    public void btn_updateData(View view) {
        final String cod_espec = eCod_espec.getText().toString();
        final String cod_prof = eCod_prof.getText().toString();
        final String cod_proced = eCod_proced.getText().toString();
        final String data_proced = eData_proced.getText().toString();
        final String descr_proced = eDescr_proced.getText().toString();
        final String link_proced = eLink_proced.getText().toString();
        final String aut_vis_cli = eAut_vis_cli.getText().toString();
        final String cpf_cli = eCpf_cli.getText().toString();



        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/t_insert.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Edicao_Activity.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity6.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Edicao_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("cpf_cli", cpf_cli);
                params.put("cod_espec", cod_espec);
                params.put("cod_prof", cod_prof);
                params.put("cod_proced", cod_proced);
                params.put("data_proced", data_proced);
                params.put("descr_proced", descr_proced);
                params.put("link_proced", link_proced);
                params.put("aut_vis_cli", aut_vis_cli);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Edicao_Activity.this);
        requestQueue.add(request);
    }
}
