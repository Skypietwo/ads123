package com.example.projetofinal;





import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

public class MainActivity4 extends AppCompatActivity {

    ListView listViewe;
    FuncionarioAdapter adapter;
    public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    String url = "http://192.168.251.35/treze/pro_retrieve.php";

    Funcionario funcionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listViewe = findViewById(R.id.myListViewe);
        adapter = new FuncionarioAdapter(this, listaFuncionarios);
        listViewe.setAdapter(adapter);

        listViewe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int posicao, long id) {
                showOptionsDialog(view, posicao);
            }
        });

        retrieveData();
    }

    private void showOptionsDialog(View view, final int posicao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        CharSequence[] dialogItem = {"View Data", "Edit Data", "Delete Data"};
        builder.setTitle(listaFuncionarios.get(posicao).getCod_espec());
        builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), DetailsActivity.class)
                                .putExtra("posicao", posicao));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Edite_Activity.class)
                                .putExtra("posicao", posicao));
                        break;
                    case 2:
                        deleteData(listaFuncionarios.get(posicao).getId());
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void deleteData(final String id) {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/pro_delete.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Data Deleted")) {
                            Toast.makeText(MainActivity4.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                            retrieveData(); // Refresh data after deletion
                        } else {
                            Toast.makeText(MainActivity4.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity4.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/pro_retrieve.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listaFuncionarios.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("processo");

                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String id = object.getString("id");
                                    String cpf_cli = object.getString("cpf_cli");
                                    String cod_espec = object.getString("cod_espec");
                                    String cod_prof = object.getString("cod_prof");
                                    String cod_proced = object.getString("cod_proced");
                                    String data_proced = object.getString("data_proced");
                                    String descr_proced = object.getString("descr_proced");
                                    String link_proced = object.getString("link_proced");
                                    String aut_vis_cli = object.getString("aut_vis_cli");

                                    funcionario = new Funcionario(id, cpf_cli,  cod_espec, cod_prof, cod_proced, data_proced, descr_proced, link_proced, aut_vis_cli);
                                    listaFuncionarios.add(funcionario);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity4.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void bt_add_activity(View view) {
        startActivity(new Intent(getApplicationContext(), Add_Pro_Activity.class));
    }
}
