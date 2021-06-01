package com.wiryaimd.textmanager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
    private FloatingActionButton fab;

    /**
     * membuat startActivityForResult versi baru bos
     * tinggal launchResult.launch(intent_crot);
     */
    private ActivityResultLauncher<Intent> launchResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                String title = result.getData().getStringExtra(AdddocActivity.EXTRA_TITLE);
                String text = result.getData().getStringExtra(AdddocActivity.EXTRA_TEXT);

                documentdataViewModel.insert(new Documentdata(title, text, ""));
                Toast.makeText(MainActivity.this, "Anjas guranjas", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "Jiahh tahii", Toast.LENGTH_SHORT).show();
            }
        }
    });

    private ActivityResultLauncher<Intent> launchEdit = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                String title = result.getData().getStringExtra(AdddocActivity.EXTRA_TITLE);
                String text = result.getData().getStringExtra(AdddocActivity.EXTRA_TEXT);
                int id = result.getData().getIntExtra(EditdocActivity.EXTRA_ID, -1);

                if (id == -1){
                    Toast.makeText(MainActivity.this, "Ngacengan asu", Toast.LENGTH_SHORT).show();
                    return;
                }

                Documentdata documentdata = new Documentdata(title, text, "");
                documentdata.setId(id);

                documentdataViewModel.update(documentdata);
                Toast.makeText(MainActivity.this, "edit cuyy ahhay", Toast.LENGTH_SHORT).show();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi viewmodel agar singleton ... maybe
        documentdataViewModel = new ViewModelProvider(MainActivity.this).get(DocumentdataViewModel.class);

        fab = findViewById(R.id.main_fab);

        recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);

        DocumentdataAdapter adapter = new DocumentdataAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);

        // untuk meng observe/memantau jika ada perubahan data
        // ini bisa menlindungi aplikasi dari memory leaks/bocor
        // documentdata diambil dari database
        documentdataViewModel.getAllDocumentdata().observe(MainActivity.this, new Observer<List<Documentdata>>() {
            @Override
            public void onChanged(List<Documentdata> documentdata) {
                // update adapter
                adapter.setAllDocumentdata(documentdata);

                Toast.makeText(MainActivity.this, "changed data boss", Toast.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchResult.launch(new Intent(MainActivity.this, AdddocActivity.class));
            }
        });


        /**
         * membuat touch agar saat di swipe data tersebut di delete
         */
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                documentdataViewModel.delete(adapter.getDocumnetdataAt(viewHolder.getBindingAdapterPosition()));
                Toast.makeText(MainActivity.this, "Doc delete jrodd aowkaowk", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnDocClick(new DocumentdataAdapter.onDocClick() {
            @Override
            public void itemClick(Documentdata documentdata) {
                Intent intent = new Intent(MainActivity.this, EditdocActivity.class);
                intent.putExtra(AdddocActivity.EXTRA_TITLE, documentdata.getTitle());
                intent.putExtra(AdddocActivity.EXTRA_TEXT, documentdata.getText());
                intent.putExtra(EditdocActivity.EXTRA_ID, documentdata.getId());

                launchEdit.launch(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu_clear:
                documentdataViewModel.deleteAll();
                Toast.makeText(this, "All doc deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}