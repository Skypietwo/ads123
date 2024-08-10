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

public class Add_Prof_Activity extends AppCompatActivity {

    EditText txreview, txstatus, txcod_prof;
    Button bt_insert;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prof);

        txreview = findViewById(R.id.etReview);
        txstatus = findViewById(R.id.etStatus);
        txcod_prof = findViewById(R.id.etCod_prof);
        bt_insert = findViewById(R.id.btInsert);
        progressBar = findViewById(R.id.progressBar);

        bt_insert.setOnClickListener(v -> insertData());

        // Handle the back button press using the OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    private void insertData() {
        final String review = txreview.getText().toString().trim();
        final String status = txstatus.getText().toString().trim();
        final String cod_prof = txcod_prof.getText().toString().trim();


        if (review.isEmpty() || status.isEmpty() || cod_prof.isEmpty())  {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/n_insert.php",
                response -> {
                    if (response.equalsIgnoreCase("Procedimento Inserted")) {
                        Toast.makeText(Add_Prof_Activity.this, "Procedimento Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Add_Prof_Activity.this, response, Toast.LENGTH_SHORT).show();
                    }
                    progressBar.setVisibility(View.GONE);
                }, error -> {
            Toast.makeText(Add_Prof_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("review", review);
                params.put("status", status);
                params.put("cod_prof", cod_prof);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Add_Prof_Activity.this);
        requestQueue.add(request);
    }
}
