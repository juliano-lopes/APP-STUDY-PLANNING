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
import android.view.LayoutInflater;
import android.support.design.widget.TabLayout; 
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
//import android.support.annotations;
import android.widget.Toast;
public class PrincipalFragment extends Fragment {
private OnItemSelectedListener listener;
public static PrincipalFragment newInstance() {
return new PrincipalFragment();
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {
return inflater.inflate(R.layout.fragment_principal, container, false);
}
@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
super.onViewCreated(view, savedInstanceState);
Bundle bundle = getArguments();
int navegation= bundle.getInt("navegation");

TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_principal_tab_layout);
tabLayout = getTab(tabLayout, navegation);
tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
@Override
public void onTabSelected(TabLayout.Tab tab) {
// TODO: criar e exibir o fragmento selecionado
comunication(tab.getPosition());
}
@Override
public void onTabUnselected(TabLayout.Tab tab) { }
@Override
public void onTabReselected(TabLayout.Tab tab) { }
});
}
public TabLayout getTab(TabLayout tabLayout, int navegation){
switch(navegation){
case R.id.nav_cadastrar:
tabLayout.addTab(tabLayout.newTab().setText(R.string.btn_login));
tabLayout.addTab(tabLayout.newTab().setText(R.string.btn_cadastro_novo));


break;
case R.id.nav_prova:
tabLayout.addTab(tabLayout.newTab().setText(R.string.btn_ver_prova));
tabLayout.addTab(tabLayout.newTab().setText(R.string.btn_registrar_prova));

break;
case R.id.nav_materia:
tabLayout.addTab(tabLayout.newTab().setText(R.string.btn_ver_materia));
tabLayout.addTab(tabLayout.newTab().setText(R.string.btn_inserir_materia));

break;


default:

break;
}
return tabLayout;

}
public interface OnItemSelectedListener {
public void onItemSelected(int position);
}
@Override
public void onAttach(Context context) {
super.onAttach(context);
if (context instanceof OnItemSelectedListener) {
listener = (OnItemSelectedListener) context;
}
//else {
//throw new ClassCastException();
//}
}
public void comunication(int position){
listener.onItemSelected(position);
}
}