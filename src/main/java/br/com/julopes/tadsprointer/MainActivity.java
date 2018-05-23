package br.com.julopes.tadsprointer;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.com.julopes.tadsprointer.R;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Handler;

//import com.bumptech.glide.*;
import android.support.v7.*;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener, PrincipalFragment.OnItemSelectedListener {
private int currentItem;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
navigationView.setNavigationItemSelectedListener(this);
Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navegation_drawer_open, R.string.navegation_drawer_close);
drawer.setDrawerListener(toggle);
toggle.syncState();
if (savedInstanceState == null) {

navigationView.setCheckedItem(R.id.nav_cadastrar);
exibirFragmentPrincipal(R.id.nav_cadastrar);
exibirFragmentLogin();
currentItem = R.id.nav_cadastrar;
}
}
@Override
public boolean onNavigationItemSelected(MenuItem item) {
// Trate os eventos de navegacao aqui
currentItem = item.getItemId();
exibirFragmentPrincipal(item.getItemId());
switch (item.getItemId()) {
case R.id.nav_cadastrar:
exibirFragmentLogin();
break;

case R.id.nav_sair:
finish();
break;
}
DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
drawer.closeDrawer(GravityCompat.START);
return true;
}
@Override
public void onItemSelected(int position){
switch(currentItem){
case R.id.nav_cadastrar:
if(position==1){
exibirFragmentNewRegister();
}
if(position==0){
exibirFragmentLogin();
}
break;
}
}
private void exibirFragmentLogin() {
Fragment novoFragment = FragmentLogin.newInstance();
getSupportFragmentManager().beginTransaction().replace(R.id.fragment_principal_content, novoFragment).commit();
}

private void exibirFragmentNewRegister() {
Fragment novoFragment = FragmentNewRegister.newInstance();
getSupportFragmentManager().beginTransaction().replace(R.id.fragment_principal_content, novoFragment).commit();
}

private void exibirFragmentPrincipal(int navegation) {
Fragment novoFragment = PrincipalFragment.newInstance();
Bundle bundle = new Bundle();
bundle.putInt("navegation",navegation);
novoFragment.setArguments(bundle);
getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_conteudo, novoFragment)
.commit();
}

}