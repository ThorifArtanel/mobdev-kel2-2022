package cs.upi.edu.mobdevkel2.dokter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cs.upi.edu.mobdevkel2.R;

public class ActivityDokter extends AppCompatActivity {
    BottomNavigationView bnv;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            myToolbar.setTitle("Beranda");
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView, FragmentDktHome.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        }

        bnv = findViewById(R.id.botNav);
        bnv.setSelectedItemId(R.id.mHome);
        bnv.setOnItemSelectedListener(
                new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.mHome:
                                fragmentManager.beginTransaction()
                                        .replace(R.id.fragmentContainerView, FragmentDktHome.class, null)
                                        .setReorderingAllowed(true)
                                        .addToBackStack(null)
                                        .commit();
                                break;
                            case R.id.mLansia:
                                fragmentManager.beginTransaction()
                                        .replace(R.id.fragmentContainerView, FragmentDktLansia.class, null)
                                        .setReorderingAllowed(true)
                                        .addToBackStack(null)
                                        .commit();
                                break;
                            case R.id.mGuide:
                                fragmentManager.beginTransaction()
                                        .replace(R.id.fragmentContainerView, FragmentDktGuide.class, null)
                                        .setReorderingAllowed(true)
                                        .addToBackStack(null)
                                        .commit();
                                break;
                            case R.id.mProfile:
                                fragmentManager.beginTransaction()
                                        .replace(R.id.fragmentContainerView, FragmentDktProfile.class, null)
                                        .setReorderingAllowed(true)
                                        .addToBackStack(null)
                                        .commit();
                                break;
                        }

                        return true;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dokter_top_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mNotification:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentDktNotification.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}