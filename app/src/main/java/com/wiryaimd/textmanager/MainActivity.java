package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi viewmodel agar singleton ... maybe
        documentdataViewModel = new ViewModelProvider(MainActivity.this).get(DocumentdataViewModel.class);

        // untuk meng observe/memantau jika ada perubahan data
        // ini bisa menlindungi aplikasi dari memory leaks/bocor
        documentdataViewModel.getAllDocumentdata().observe(MainActivity.this, new Observer<List<Documentdata>>() {
            @Override
            public void onChanged(List<Documentdata> documentdata) {
                // melakukan update

                Toast.makeText(MainActivity.this, "changed data boss", Toast.LENGTH_SHORT).show();
            }
        });

    }

}