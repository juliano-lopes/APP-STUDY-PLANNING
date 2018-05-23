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

import android.view.View.OnClickListener;

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






import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import br.com.julopes.tadsprointer.DownloadData;
import br.com.julopes.tadsprointer.User;
import br.com.julopes.tadsprointer.SolicitationType;
import android.widget.EditText;
import java.lang.*;
public class FragmentNewRegister extends Fragment {
private User user;
private EditText name;
private EditText email;
private EditText senha;
private Button btnSalvar;
private String url = "http://www.julianolopes.com.br/api_android/android_request.php?id=br.com.julopes.tadsprointer";

public static FragmentNewRegister newInstance(){
return new FragmentNewRegister();
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {
return inflater.inflate(R.layout.fragment_new_register, container, false);
}
@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
super.onViewCreated(view, savedInstanceState);
name = (EditText) view.findViewById(R.id.user_name);
email = (EditText) view.findViewById(R.id.user_email);
senha= (EditText) view.findViewById(R.id.user_senha);
btnSalvar = (Button) view.findViewById(R.id.btn_salvar);
btnSalvar.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v) {
url+="&name="+name.getText().toString()+"&email="+email.getText().toString()+"&senha="+senha.getText().toString()+"&action=register";
DownloadData dd = new DownloadData(getActivity(), new User(name.getText().toString(), email.getText().toString(), senha.getText().toString()), url, SolicitationType.REGISTER);
dd.execute();

//Toast.makeText(context, "meu nome", Toast.LENGTH_SHORT).show();
   }

});

}
@Override
public void onActivityCreated(Bundle savedInstanceState) {
super.onActivityCreated(savedInstanceState);



}
}