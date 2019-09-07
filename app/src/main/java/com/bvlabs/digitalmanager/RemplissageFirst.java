package com.bvlabs.digitalmanager;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;

public class RemplissageFirst extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    AppCompatEditText mProjectName;
    AppCompatEditText mStartDate;
    AppCompatEditText mEndDate;
    AppCompatEditText mPercentage;
    SearchableSpinner mSearchReceipts;
    SearchableSpinner mSearchSpent;
    AppCompatEditText mBalance;
    TextView mBalanceConcusion;
    SearchableSpinner mProjectBudget;
    AppCompatEditText mMonthlyPercentage;
    SearchableSpinner mSearchLend;
    AppCompatEditText mConsumptionBudget;
    AppCompatEditText mGainCondition;
    TextView mGainConclusion;
    SearchableSpinner mSearchStatus;
    AppCompatEditText mChangeDateStatus;
    SearchableSpinner mSearchHumanRes;
    CardView mSaveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remplissage_first);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get references to items
        mProjectName = (AppCompatEditText) findViewById(R.id.et_project_name);
        mStartDate = (AppCompatEditText) findViewById(R.id.et_start_date);
        mEndDate = (AppCompatEditText) findViewById(R.id.et_end_date);
        mPercentage = (AppCompatEditText) findViewById(R.id.et_percentage);
        //mSearchReceipts = (SearchableSpinner) findViewById(R.id.Search_receipts);
        //mSearchSpent = (SearchableSpinner) findViewById(R.id.Search_spending);
        mBalance = (AppCompatEditText) findViewById(R.id.et_balance);
        mBalanceConcusion = (TextView) findViewById(R.id.tv_conclusion);
        mProjectBudget = (SearchableSpinner) findViewById(R.id.Search_project_budget);
        mMonthlyPercentage = (AppCompatEditText) findViewById(R.id.et_monthly_percentage);
        //mSearchLend = (SearchableSpinner) findViewById(R.id.Search_lend);
        mConsumptionBudget = (AppCompatEditText) findViewById(R.id.et_consumption_budget);
        mGainCondition = (AppCompatEditText) findViewById(R.id.et_gain_condition);
        mGainConclusion = (TextView) findViewById(R.id.tv_gain_conclusion);
        //mSearchStatus = (SearchableSpinner) findViewById(R.id.Search_status);
        mChangeDateStatus = (AppCompatEditText) findViewById(R.id.et_date_change_status);
        //mSearchHumanRes = (SearchableSpinner) findViewById(R.id.Search_human_res);
        mSaveButton = (CardView) findViewById(R.id.save_button);


        mStartDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (mStartDate.getText().toString().isEmpty()) {

                    DialogFragment datePicker = new DatePickerFragment();
                    datePicker.show(getSupportFragmentManager(), "date picker");
                } else {
                    //Do nothing
                }

            }
        });

        mStartDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (mStartDate.getText().toString().isEmpty()) {

                    DialogFragment datePicker = new DatePickerFragment();
                    datePicker.show(getSupportFragmentManager(), "date picker");
                } else {
                    //Do nothing
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

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

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        mStartDate.setText(currentDateString);
    }

}
