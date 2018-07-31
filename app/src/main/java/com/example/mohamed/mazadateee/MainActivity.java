package com.example.mohamed.mazadateee;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.mohamed.mazadateee.Common.Common;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout الفواتير;
    LinearLayout كراساتالشروط;
    LinearLayout العقد;
    LinearLayout الشروط;
    LinearLayout الاسئله;
    LinearLayout المزادات;
    LinearLayout المحفظه;
    LinearLayout دخول;
    LinearLayout خروج;
    NavigationView navigationView;

    int timeSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Thread thread = new Thread() {
            @Override
            public void run() {
                timeSec = 1000*60;
                try {
                    sleep(timeSec);


                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {


                    Common.currentUser.setFlag(false);


                }
            }
        };

        thread.start();




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Home()).commit();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.inflateHeaderView(R.layout.nav_header_main);

        الفواتير = (LinearLayout) header.findViewById(R.id.الفواتير);
        كراساتالشروط = (LinearLayout) header.findViewById(R.id.كراساتالشروط);
        العقد = (LinearLayout) header.findViewById(R.id.العقد);
        الشروط = (LinearLayout) header.findViewById(R.id.الشروط);
        الاسئله = (LinearLayout) header.findViewById(R.id.الاسئله);
        المزادات = (LinearLayout) header.findViewById(R.id.المزادات);
        المحفظه = (LinearLayout) header.findViewById(R.id.المحفظه);
        دخول = (LinearLayout) header.findViewById(R.id.دخول);
        خروج = (LinearLayout) header.findViewById(R.id.خروج);



        دخول.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignIn.class));
            }
        });

        خروج.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new Home();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new Profile();
                    break;
                case R.id.navigation_notification:
                    selectedFragment = new Notification();
                    break;
                case R.id.navigation_myAuction:
                    selectedFragment = new MyAuction();
                    break;
                case R.id.navigation_Auction:
                    selectedFragment = new Auction();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();

            return true;
        }

    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.call) {
            call();
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
//
//        if (id == R.id.الفواتير) {
//        } else if (id == R.id.كراساتالشروط) {
//
//        } else if (id == R.id.العقد) {
//
//        } else if (id == R.id.الشروط) {
//
//        } else if (id == R.id.الاسئله) {
//
//        } else if (id == R.id.المزادات) {
//
//        } else if (id == R.id.المحفظه) {
//
//        }else if (id == R.id.دخول) {
//            startActivity(new Intent(MainActivity.this,SignIn.class));
//
//        }else if (id == R.id.خروج) {
//
//            logout();
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
      //  builder.setMessage(" Are you sure");
        builder.setTitle(" Are you sure");


        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();

    }

    private void call() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" call us in 01142007993");


        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01142007993"));
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();

    }

}
