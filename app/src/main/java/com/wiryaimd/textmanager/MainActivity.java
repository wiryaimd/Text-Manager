package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.wiryaimd.textmanager.adapter.DocumentdataAdapter;

import java.util.List;

/**
 * boilerplate = kode yang dapat digunakan berulang-ulang tanpa perubahan
 *
 * mirip template tapi
 * boilerplate != template
 *
 * boilerplate untuk menghemat waktu early development
 *
 */

/**
 * activity, fragment dkk merupakan view dari mvvm
 */
public class MainActivity extends AppCompatActivity {

    /**
     * MVVM architecture jrod
     */

    /**
     * Don't keep a reference to a context that has a shorter lifecycle than your ViewModel!
     * Examples are:
     * - Activity
     * - Fragment
     * - View
     * Keeping a reference can cause a memory leak,
     * for example: rotate screen can leak memory & recreate activity
     */

    private DocumentdataViewModel documentdataViewModel;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi viewmodel agar singleton ... maybe
        documentdataViewModel = new ViewModelProvider(MainActivity.this).get(DocumentdataViewModel.class);

        recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);

        DocumentdataAdapter adapter = new DocumentdataAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);

        // untuk meng observe/memantau jika ada perubahan data
        // ini bisa menlindungi aplikasi dari memory leaks/bocor
        documentdataViewModel.getAllDocumentdata().observe(MainActivity.this, new Observer<List<Documentdata>>() {
            @Override
            public void onChanged(List<Documentdata> documentdata) {
                // update adapter
                // documentdata diambil dari database yang berubah
                adapter.setAllDocumentdata(documentdata);

                Toast.makeText(MainActivity.this, "changed data boss", Toast.LENGTH_SHORT).show();
            }
        });

    }

}