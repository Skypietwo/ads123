package com.example.projetofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Add_Pro_Activity extends AppCompatActivity {
    EditText txcpf_cli, txcod_espec, txcod_prof, txcod_proced,  txdescr_proced, txlink_proced, txaut_vis_cli;
    Button bt_insert;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pro);

        txcpf_cli = findViewById(R.id.etCpf_cli);
        txcod_espec = findViewById(R.id.etCod_espec);
        txcod_prof = findViewById(R.id.etCod_prof);
        txcod_proced = findViewById(R.id.etCod_proced);
        txdescr_proced = findViewById(R.id.etDescr_proced);
        txlink_proced = findViewById(R.id.etLink_proced);
        txaut_vis_cli = findViewById(R.id.etAut_vis_cli);
        bt_insert = findViewById(R.id.btInsert);
        progressBar = findViewById(R.id.progressBar);

        bt_insert.setOnClickListener(v -> insertData());

        // Manipule o pressionamento do botão Voltar usando o OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    private boolean isValidCPF(String cpf) {
        // Implemente sua lógica de validação de CPF aqui
        // Exemplo: Verificando se o CPF tem 11 dígitos e é um formato válido
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        // Adicione sua lógica de validação de CPF aqui
        // Exemplo: Verificando o formato de CPF usando expressões regulares ou somas de verificação
        return true;
    }

    private void insertData() {
        final String cpf_cli = txcpf_cli.getText().toString().trim(); // CPF desmascarado
        final String cod_espec = txcod_espec.getText().toString().trim();
        final String cod_prof = txcod_prof.getText().toString().trim();
        final String cod_proced = txcod_proced.getText().toString().trim();
        final String descr_proced = txdescr_proced.getText().toString().trim();
        final String link_proced = txlink_proced.getText().toString().trim();
        final String aut_vis_cli = txaut_vis_cli.getText().toString().trim();

        if (!isValidCPF(cpf_cli)) {
            Toast.makeText(this, "CPF inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cpf_cli.isEmpty() || cod_espec.isEmpty() || cod_prof.isEmpty() || cod_proced.isEmpty() || descr_proced.isEmpty() || link_proced.isEmpty() || aut_vis_cli.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Exemplo de verificação adicional antes de enviar a requisição
        // Neste exemplo, verifica se o CPF é "12345678900"
        if (cpf_cli.equals("12345678900")) {
            Toast.makeText(this, "CPF bloqueado para inserção", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/pro_insert.php",
                response -> {
                    if (response.equalsIgnoreCase("Procedimento Inserido")) {
                        Toast.makeText(Add_Pro_Activity.this, "Procedimento Inserido", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Add_Pro_Activity.this, response, Toast.LENGTH_SHORT).show();
                    }
                    progressBar.setVisibility(View.GONE);
                },
                error -> {
                    Toast.makeText(Add_Pro_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cpf_cli", cpf_cli);
                params.put("cod_espec", cod_espec);
                params.put("cod_prof", cod_prof);
                params.put("cod_proced", cod_proced);
                params.put("descr_proced", descr_proced);
                params.put("link_proced", link_proced);
                params.put("aut_vis_cli", aut_vis_cli);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Add_Pro_Activity.this);
        requestQueue.add(request);
    }
}
