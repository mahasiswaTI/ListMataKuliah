package com.example.matakuliah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataNama;
    private String[] dataDeskripsi;
    private TypedArray dataFoto;
    private MkAdapter adapter;
    private ArrayList<Mk> mks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MkAdapter(this);
        ListView listView = findViewById(R.id.lv_mk);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, mks.get(i).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void addItem(){
        mks = new ArrayList<>();
        for (int i = 0; i < dataNama.length; i++){
            Mk mk = new Mk();
            mk.setFoto(dataFoto.getResourceId(i, -1));
            mk.setNama(dataNama[i]);
            mk.setDeskripsi(dataDeskripsi[i]);
            mks.add(mk);
        }
        adapter.setMks(mks);
    }

    private void prepare(){
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataFoto = getResources().obtainTypedArray(R.array.data_foto);
    }

}