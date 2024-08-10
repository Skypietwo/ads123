package com.example.projetofinal;




import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.MainActivity;
import com.example.projetofinal.R;

public class DetalhadoActivity extends AppCompatActivity {

    TextView  tzid,tzreview,tzstatus,tzcod_prof;
    int posicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhado);

        tzid = findViewById(R.id.pcdid);
        tzreview = findViewById(R.id.pcdreview);
        tzstatus = findViewById(R.id.pcdstatus);
        tzcod_prof = findViewById(R.id.pcdcod_prof);




        Intent intent = getIntent();
        posicao = intent.getExtras().getInt("posicao");

        tzid.setText("ID: " + MainActivity7.listaProtege.get(posicao).getId());
        tzreview.setText("Review: " + MainActivity7.listaProtege.get(posicao).getReview());
        tzstatus.setText("Status: " + MainActivity7.listaProtege.get(posicao).getStatus());
        tzcod_prof.setText("Codigo Profissional: " + MainActivity7.listaProtege.get(posicao).getCod_prof());






    }
}