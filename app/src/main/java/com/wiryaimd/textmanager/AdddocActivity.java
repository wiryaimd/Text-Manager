package com.wiryaimd.textmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AdddocActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "adddoc_title";
    public static final String EXTRA_TEXT = "adddoc_text";

    private EditText title, text;
    private Button crot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddoc);

        title = findViewById(R.id.adddoc_title);
        text = findViewById(R.id.adddoc_text);
        crot = findViewById(R.id.adddoc_crotboss);

        crot.setOnClickListener(v -> Toast.makeText(AdddocActivity.this, "Kyaaa echiiii", Toast.LENGTH_SHORT).show());
    }

    private void saveDoc() {
        String stitle = title.getText().toString();
        String stext = text.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TITLE, stitle);
        intent.putExtra(EXTRA_TEXT, stext);

        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * membuat options menu
     * tombol save pada toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.adddoc_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.adddoc_menu_save:
                saveDoc();
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
