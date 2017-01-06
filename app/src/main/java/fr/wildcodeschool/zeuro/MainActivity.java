package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.OnClick;


public class MainActivity extends HambMenu {
    private Button result;
    private  ListView mListeView;
    private ImageButton imgButtun;
    static protected String FORFAIT = "fr.wildcodeschool.zeuro.FORFAIT";
    final ArrayList<ForfaitObj> listForfait = new ArrayList<>();
    private Button test;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListeView = (ListView) findViewById(R.id.list_itemm);

        listForfait.add(new ForfaitObj(R.drawable.logo_orange,0,200,500,5,0,(float) 19.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_bouygues,3,0,0,10,24,(float) 24.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_sfr,5,1000,250,5,12,(float) 20.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_free,6,100,0,3,0,(float) 14.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_orange,1,600,100,1,24,(float) 9.99));
        result = (Button) findViewById(R.id.rechercheButton);
        imgButtun = (ImageButton) findViewById(R.id.profil);
        imgButtun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable(FORFAIT, listForfait);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
        final Custom_Adapt listAdap = new Custom_Adapt(this, listForfait);
        mListeView.setAdapter(listAdap);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listForfait, new Comparator<ForfaitObj>() {
                    @Override
                    public int compare(ForfaitObj tc1, ForfaitObj tc2) {
                        return (int) (tc1.getPrix() - tc2.getPrix());
                    }
                });
                listAdap.notifyDataSetChanged();
            }
        });
        mListeView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick (AdapterView<?> parent, View v, int posisition, long id) {
                        Intent intent = new Intent(MainActivity.this, DetalsActivity.class);
                        intent.putExtra("MainActivity", listForfait.get(posisition));
                        startActivity(intent);
                    }});


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ToggleButton hamburger =  (ToggleButton) findViewById(R.id.idHamb);

        // Find our drawer view

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        hamburger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    MainActivity.this.mDrawer.openDrawer(Gravity.LEFT);
                }
                else{
                    MainActivity.this.mDrawer.closeDrawer(Gravity.LEFT);
                }
            }
        });

           /* @Override
            public void onClick(View v) {
                MainActivity.this.mDrawer.openDrawer(Gravity.LEFT);
            }*/


    }


}
