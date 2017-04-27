package com.juandaqugo.hospitalnearby;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class PerfilDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent intent;
    TextView tnombre_perfil, tcorreo_perfil, tsangre_perfil, teps_perfil, tcedula_perfil;
    String sangre, EPS, snombre, documento, scorreo, scontrasena, alergia, enfermedad, t_acudiente;
    Spinner ListaSaludcoop;
    String[] items;
    ImageView iusuario;
//    Bitmap imageBitmap;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaSaludcoop = (Spinner) findViewById(R.id.ListaSaludcoop);
       // items = getResources().getStringArray(R.array.HospitalesSaludCoop);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ListaSaludcoop.setAdapter(adaptador);

        Bundle extras = getIntent().getExtras();

        sangre = extras.getString("sangre");
        EPS = extras.getString("eps");
        snombre = extras.getString("nombre");
        documento = extras.getString("documento");
        scorreo = extras.getString("correo");
        scontrasena = extras.getString("contrasena");
        alergia = extras.getString("alergias");
        enfermedad = extras.getString("enfermedades");
        t_acudiente = extras.getString("tacudiente");

//        imageBitmap = (Bitmap) extras.get("data");
//        iusuario = (ImageView) findViewById(R.id.fot_per);
//        iusuario.setImageBitmap(imageBitmap);

        prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        editor = prefs.edit();

        tnombre_perfil = (TextView) findViewById(R.id.tnombre_perfil);
        tsangre_perfil = (TextView) findViewById(R.id.tsangre_perfil);
        tcorreo_perfil = (TextView) findViewById(R.id.tcorreo_perfil);
        tcedula_perfil = (TextView) findViewById(R.id.tcedula_perfil);
        teps_perfil = (TextView) findViewById(R.id.tEPS_perfil);
        tnombre_perfil.setText(snombre);
        tsangre_perfil.setText(sangre);
        tcorreo_perfil.setText(scorreo);
        tcedula_perfil.setText(documento);
        teps_perfil.setText(EPS);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.perfil_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.accidente) {
            // Handle the camera action
        } else if (id == R.id.quemaduras) {
            intent = new Intent(PerfilDrawerActivity.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.infecciones) {
            intent = new Intent(PerfilDrawerActivity.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.alergias) {
            intent = new Intent(PerfilDrawerActivity.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.hemorragias) {
            intent = new Intent(PerfilDrawerActivity.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.cabeza) {
            intent = new Intent(PerfilDrawerActivity.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.cuerpo) {

        } else if (id == R.id.estomago) {

        } else if (id == R.id.oido) {

        } else if (id == R.id.vision) {

        } else if (id == R.id.piel) {

        } else if (id == R.id.cambiar_datos) {

        } else if (id == R.id.cerrar) {
            editor.putInt("login",-1);
            editor.commit();
            intent = new Intent(PerfilDrawerActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
