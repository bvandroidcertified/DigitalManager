package com.bvlabs.digitalmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FicheSuiviProjet extends AppCompatActivity {

    ImageButton mShowOptionButton;
    TextView mShowMsgShowoption;
    LinearLayout mLayoutOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_suivi_projet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mShowOptionButton = (ImageButton)findViewById(R.id.btn_show_option);
        mShowMsgShowoption = (TextView)findViewById(R.id.msg_show_option);
        mLayoutOption = (LinearLayout) findViewById(R.id.option_menu);

        mShowOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutOption.getVisibility() == View.VISIBLE){
                    mShowMsgShowoption.setText("Afficher les option ");
                    mLayoutOption.setVisibility(View.GONE);
                }else{

                    mShowMsgShowoption.setText("Cacher les option");
                    mLayoutOption.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
