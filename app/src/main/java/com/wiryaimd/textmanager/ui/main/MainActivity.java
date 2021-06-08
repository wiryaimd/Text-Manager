package com.wiryaimd.textmanager.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.wiryaimd.textmanager.BaseActivity;
import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.ui.main.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "anjai guranjai", Toast.LENGTH_SHORT).show();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new ProfileFragment());
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainmenu_menu:
                sessionManager.logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
