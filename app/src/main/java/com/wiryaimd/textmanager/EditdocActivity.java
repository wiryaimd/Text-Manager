package com.wiryaimd.textmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditdocActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "editdoc_id";

    private EditText title, text;
    private Button crot;
    private int id = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdoc);

        title = findViewById(R.id.editdoc_title);
        text = findViewById(R.id.editdoc_text);

        if (getIntent() != null){
            id = getIntent().getIntExtra(EXTRA_ID, -1);
            String stitle = getIntent().getStringExtra(AdddocActivity.EXTRA_TITLE);
            String stext = getIntent().getStringExtra(AdddocActivity.EXTRA_TEXT);
            title.setText(stitle);
            text.setText(stext);
        }

    }

    private void saveDoc() {
        String stitle = title.getText().toString();
        String stext = text.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(AdddocActivity.EXTRA_TITLE, stitle);
        intent.putExtra(AdddocActivity.EXTRA_TEXT, stext);
        intent.putExtra(EXTRA_ID, id);

        setResult(RESULT_OK, intent);
        finish();
    }

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
