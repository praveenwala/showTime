package com.rajesh.showtime;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.rajesh.showtime.fragment.DashboardFragment;
import com.rajesh.showtime.fragment.DoorListFragment;
import com.rajesh.showtime.fragment.ScanFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomTabActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private List<Fragment> list = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    loadFragment(list.get(0));
                    return true;
                case R.id.navigation_scan:
                    mTextMessage.setText(R.string.title_scan);
                    loadFragment(list.get(1));
                    return true;
                case R.id.navigation_doorlist:
                    mTextMessage.setText(R.string.title_doorlist);
                    loadFragment(list.get(2));
                    return true;
            }
            return false;
        }


    };

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment instanceof ScanFragment) {

            // TODO: 12/12/18 Add any params for Scanning 
        } else if (fragment instanceof DashboardFragment) {
            // TODO: 12/12/18 Add any params for Dash board 
        } else if (fragment instanceof DoorListFragment) {
            // TODO: 12/12/18 Add an
        }

        fragmentManager.beginTransaction().replace(R.id.frame_for_fragment, fragment).commit();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);
        setupFragments();
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(list.get(0));
    }

    private void setupFragments() {
        if (list.isEmpty()) {
            list.add(new DashboardFragment());
            list.add(new ScanFragment());
            list.add(new DoorListFragment());
        }

    }


}
