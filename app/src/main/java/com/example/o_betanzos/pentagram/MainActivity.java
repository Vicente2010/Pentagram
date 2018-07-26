package com.example.o_betanzos.pentagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();
        agregarBtn();

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicador);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,planetas));

        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

        public void refrescandoContenido(){
            String[] planetas = getResources().getStringArray(R.array.planetas);
            lstMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,planetas));
            sfiMiIndicadorRefresh.setRefreshing(false);
        }

        public void agregarFAB(){
            FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabMiFAB);
            miFAB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getBaseContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_SHORT)
                            .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.i("SNACKBAR","Click en SnackBar");
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .show();
                }
            });
        }

        public void agregarBtn(){
            Button miBoton = (Button) findViewById(R.id.btnMiBoton);
            miBoton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Snackbar.make(v,getResources().getString(R.string.mensaje),Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }

