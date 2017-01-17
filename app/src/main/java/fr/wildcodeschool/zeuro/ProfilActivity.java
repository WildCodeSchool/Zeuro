package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;

import fr.wildcodeschool.zeuro.DBHandler.DBHandler;


public class ProfilActivity extends AppCompatActivity {

    private Button button2;
    private Button button;
    private CrystalRangeSeekbar appelSeekbar, prixSeekbar, internetSeekBar, smsSeekbar, mmsSeekbar;
    private DBHandler mDBHandler;
    private TextView timeCall, price, net, sms, mms;
    public static HashMap<String, Float> dataFilter = new HashMap<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        this.mDBHandler = new DBHandler(this);
        ArrayList<Integer[]> savelist = mDBHandler.getsavesseekbar();

        //methode pr recuperer le min de 1ere ligne (appel)
        int a = savelist.get(0)[0];

        //pr changer une valeur l'id ds seekbar
        this.mDBHandler.setValueMinEtMax(1, 1, 5);
        seekbarAppel();
        seekbarPrix();
        seekbarInternet();
        seekbarSMS();
        seekbarMMS();

        button2 = (Button)findViewById(R.id.buttonret);
        button = (Button) findViewById(R.id.buttonvalidate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
  
    }

    public void seekbarAppel() {
        appelSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekAppel);
        timeCall = (TextView) findViewById(R.id.idAppel);


        final TextView tvMin = (TextView) findViewById(R.id.Appelmin);
        final TextView tvMax = (TextView) findViewById(R.id.Appelmax);




        // set listener
        appelSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==5)tvMax.setText("illimité");
            }
        });

// set final value listener
        appelSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }


    public void seekbarPrix() {
        prixSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekPrix);
        price = (TextView) findViewById(R.id.idPrix);

        final TextView tvMin = (TextView) findViewById(R.id.Pricemin);
        final TextView tvMax = (TextView) findViewById(R.id.Pricemax);

        // set listener
        prixSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==50)tvMax.setText("50 +");
            }
        });

// set final value listener
        prixSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }



    public void seekbarInternet() {
        internetSeekBar = (CrystalRangeSeekbar) findViewById(R.id.idSeekInternet);
        net = (TextView) findViewById(R.id.idInternet);

        final TextView tvMin = (TextView) findViewById(R.id.Internetmin);
        final TextView tvMax = (TextView) findViewById(R.id.Internetmax);

        // set listener
        internetSeekBar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==50)tvMax.setText("50 +");
            }
        });

// set final value listener
        internetSeekBar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }

    public void seekbarSMS() {
        smsSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekSMS);
        sms = (TextView) findViewById(R.id.idSMS);
        final TextView tvMin = (TextView) findViewById(R.id.Smsmin);
        final TextView tvMax = (TextView) findViewById(R.id.Smsmax);

        // set listener
        smsSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==1000)tvMax.setText("illimité");
            }
        });

// set final value listener
        smsSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }

    public void seekbarMMS() {
        mmsSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekMMS);
        mms = (TextView) findViewById(R.id.idMMS);
        final TextView tvMin = (TextView) findViewById(R.id.Mmsmin);
        final TextView tvMax = (TextView) findViewById(R.id.Mmsmax);

        // set listener
        mmsSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==1000)tvMax.setText("illimité");
            }
        });

// set final value listener
        mmsSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }

    public HashMap hashMapReturn() {return dataFilter;}


}