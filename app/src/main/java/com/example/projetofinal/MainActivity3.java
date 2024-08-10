package com.example.projetofinal;




import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class MainActivity3 extends AppCompatActivity {

    ListView listView;
    MyAdapter adapter;
    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();
    String url = "http://192.168.251.35/treze/retrieve.php";

    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView = findViewById(R.id.myListView);
        adapter = new MyAdapter(this, employeeArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                showOptionsDialog(view, position);
            }
        });

        retrieveData();
    }

    private void showOptionsDialog(View view, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        CharSequence[] dialogItem = {"View Data", "Edit Data", "Delete Data"};
        builder.setTitle(employeeArrayList.get(position).getNome_cli());
        builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), DetailActivity.class)
                                .putExtra("position", position));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Edit_Activity.class)
                                .putExtra("position", position));
                        break;
                    case 2:
                        deleteData(employeeArrayList.get(position).getId());
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void deleteData(final String id) {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/delete.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Data Deleted")) {
                            Toast.makeText(MainActivity3.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity3.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity3.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.251.35/treze/retrieve.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        employeeArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("cliente");

                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    String cpf_cli = object.getString("cpf_cli");
                                    String nome_cli = object.getString("nome_cli");
                                    String cod_cli = object.getString("cod_cli");
                                    String tel_cli = object.getString("tel_cli");
                                    String cep_cli = object.getString("cep_cli");
                                    String logra_cli = object.getString("logra_cli");
                                    String num_logra_cli = object.getString("num_logra_cli");
                                    String compl_cli = object.getString("compl_cli");
                                    String bairro_cli = object.getString("bairro_cli");
                                    String cidade_cli = object.getString("cidade_cli");
                                    String uf_cli = object.getString("uf_cli");
                                    String rg_cli = object.getString("rg_cli");
                                    String est_rg_cli = object.getString("est_rg_cli");
                                    String nome_mae_cli = object.getString("nome_mae_cli");
                                    String data_nasc_cli = object.getString("data_nasc_cli");


                                    employee = new Employee(id, cpf_cli, nome_cli, cod_cli, tel_cli, cep_cli, logra_cli, num_logra_cli, compl_cli, bairro_cli, cidade_cli, uf_cli, rg_cli, est_rg_cli, nome_mae_cli, data_nasc_cli);

                                    employeeArrayList.add(employee);
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
                Toast.makeText(MainActivity3.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void btn_add_activity(View view) {
        startActivity(new Intent(getApplicationContext(), Add_Data_Activity.class));
    }
}
