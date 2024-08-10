package com.example.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();

        // Verifica se há fragmentos presentes na pilha de fragmentos
        if (fragmentManager.getBackStackEntryCount() == 0) {
            // Se não houver fragmentos, adiciona o HomeFragment
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;

                // Se já está no HomeFragment, não faz nada
                if (item.getItemId() == R.id.home) {
                    return true;
                } else if (item.getItemId() == R.id.cliente) {
                    intent = new Intent(MainActivity2.this, MainActivity3.class);
                } else if (item.getItemId() == R.id.processo) {
                    intent = new Intent(MainActivity2.this, MainActivity4.class);
                } else if (item.getItemId() == R.id.agenda) {
                    intent = new Intent(MainActivity2.this, MainActivity7.class);
                }

                if (intent != null) {
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}
