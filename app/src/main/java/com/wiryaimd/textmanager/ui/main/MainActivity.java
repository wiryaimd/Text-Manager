package com.wiryaimd.textmanager.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.wiryaimd.textmanager.BaseActivity;
import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.ui.main.posts.PostsFragment;
import com.wiryaimd.textmanager.ui.main.profile.ProfileFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.main_drawer);
        navigationView = findViewById(R.id.main_navigation);

        Toast.makeText(this, "anjai guranjai", Toast.LENGTH_SHORT).show();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new PostsFragment());
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigationmenu_posts:
                Log.d(TAG, "onNavigationItemSelected: postss");
                break;
            case R.id.navigationmenu_profile:
                Log.d(TAG, "onNavigationItemSelected: profilee");
                break;
        }
        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
