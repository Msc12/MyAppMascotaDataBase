package com.mascware.app.myappmascotadatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mascware.app.myappmascotadatabase.adapters.PageAdapter;
import com.mascware.app.myappmascotadatabase.vista.fragment.PerfilFragment;
import com.mascware.app.myappmascotadatabase.vista.fragment.RecyclerViewFragmentView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        if(toolbar!=null){
        setSupportActionBar(toolbar);
        }
        this.setUPViewPager();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent=new Intent(this,Top5Activity.class);
                startActivity(intent);

                return true;
            case R.id.mAbout:
                Intent intent2=new Intent(this,AcercaActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mContact:
                Intent intent3=new Intent(this,ContactoActivity.class);
                startActivity(intent3);

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewFragmentView());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUPViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }

}
