package com.gyan.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyan.calculator.dotmenu.AboutActivity;
import com.gyan.calculator.dotmenu.HistoryActivity;
import com.gyan.calculator.dotmenu.PrivacyPolicyActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    AppCompatButton btndotmenu,btnlessmore;
    PopupMenu dropDownMenu;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //toolbar set
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // making notification bar transparent
        changeStatusBarColor();

        btnlessmore=findViewById(R.id.less_more);
        viewPager=findViewById(R.id.viewpager);
        bottomNavigationView=findViewById(R.id.top_nav);

        //BottomNavigationBar, I am arrange in Top in between menu & Less_more and there include three fragment
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.equalto:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.more:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.home:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
        setUpViewPager();

        btndotmenu=findViewById(R.id.dotMenu);
        //DropDownMenu, This menu I am set First Fragment
        dropDownMenu=new PopupMenu(getApplicationContext(),btndotmenu);
        menu=dropDownMenu.getMenu();
        dropDownMenu.getMenuInflater().inflate(R.menu.equalto_frag_menu,menu);
        dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        Toast.makeText(MainActivity.this, "History Clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

        //Click menu
        btndotmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()==0){
                    dropDownMenu.show();
                }else if (viewPager.getCurrentItem()==1){
                    startActivity(new Intent(getApplicationContext(), PrivacyPolicyActivity.class));
                }else if (viewPager.getCurrentItem()==2){
                    startActivity(new Intent(getApplicationContext(),PrivacyPolicyActivity.class));
                }
            }
        });

    }

    // Making notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    //Scrolling View between Fragment, there are three fragment when include BottomNavigationBar
    private void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.equalto).setChecked(true);
                        btnlessmore.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.more).setChecked(true);
                        btnlessmore.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        btnlessmore.setVisibility(View.INVISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}