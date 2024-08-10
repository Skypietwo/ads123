package com.example.projetofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity7 extends AppCompatActivity {

    ListView listVieweee;
    ProtegeAdapter adapter;  // Assuming you create a ProtegeAdapter similar to OperarioAdapter
    public static ArrayList<Protege> listaProtege = new ArrayList<>();
    String url = "http://192.168.251.35/treze/n_retrieve.php";

    Protege Protege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        listVieweee = findViewById(R.id.myListViewe);
        adapter = new ProtegeAdapter(this, listaProtege);  // Use ProtegeAdapter
        listVieweee.setAdapter(adapter);

        listVieweee.setOnItemClickListener((parent, view, posicao, id) -> showOptionsDialog(view, posicao));

        retrieveData();
    }

    private void showOptionsDialog(View view, final int posicao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        CharSequence[] dialogItem = {"View Data", "Delete Data"};
        builder.setTitle(listaProtege.get(posicao).getStatus());
        builder.setItems(dialogItem, (dialog, i) -> {
            switch (i) {
                case 0:
                    startActivity(new Intent(getApplicationContext(), DetalhadoActivity.class)
                            .putExtra("posicao", posicao));
                    break;
                case 1:
                    deleteData(listaProtege.get(posicao).getId());
                    break;
            }
        });
        builder.create().show();
    }

    private void deleteData(final String id) {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/n_delete.php",
                response -> {
                    if (response.equalsIgnoreCase("Data Deleted")) {
                        Toast.makeText(MainActivity7.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        retrieveData(); // Refresh data after deletion
                    } else {
                        Toast.makeText(MainActivity7.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }, error -> Toast.makeText(MainActivity7.this, error.getMessage(), Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                response -> {
                    listaProtege.clear();
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("protege");

                        if (success.equals("1")) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String id = object.getString("id");
                                String review = object.getString("review");
                                String status = object.getString("status");
                                String cod_prof = object.getString("cod_prof");

                                Protege = new Protege(id, review, status, cod_prof);
                                listaProtege.add(Protege);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    } catch (JSONException e) {
                        Log.e("MainActivity7", "JSON Parsing error: " + e.getMessage());
                    }
                }, error -> Toast.makeText(MainActivity7.this, error.getMessage(), Toast.LENGTH_SHORT).show());

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


}
