package com.bvlabs.digitalmanager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.IStatusListener;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener;

public class NouveauFormulaire extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    ImageButton mJoinFileButton;
    ImageButton mDefineFieldButton;
    ImageButton mResponsibleButton;
    ImageButton mSpeakerButton;
    ImageButton mActorButton;
    ImageButton mAttachFileButton;
    ImageButton mEvaluationButton;
    ImageButton mLastStatusButton;
    ImageButton mDirectoryButton;
    CheckBox mMiniFormCheck;
    CardView mSaveButton;
    AppCompatEditText mDateEditText;
    TextInputLayout mTimeLimitLayout;
    SearchableSpinner mSearchDirectory;
    CardView mDsaveButtonDialog;

    private android.app.AlertDialog.Builder dialogBuilder;
    private android.app.AlertDialog dialogA;

    private SimpleListAdapter mSimpleListAdapterThree;
    private SimpleArrayListAdapter mSimpleArrayListAdapterThree;
    private final ArrayList<String> mStringsThree = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_formulaire);

        mJoinFileButton = (ImageButton) findViewById(R.id.btn_join_file);
        mDefineFieldButton = (ImageButton) findViewById(R.id.btn_define_field);
        mResponsibleButton = (ImageButton) findViewById(R.id.btn_responsible);
        mSpeakerButton = (ImageButton) findViewById(R.id.btn_speakers);
        mActorButton = (ImageButton) findViewById(R.id.btn_actors);
        mAttachFileButton = (ImageButton) findViewById(R.id.btn_attach_process);
        mEvaluationButton = (ImageButton) findViewById(R.id.btn_evaluation);
        mLastStatusButton = (ImageButton) findViewById(R.id.btn_las_status);
        mDirectoryButton = (ImageButton) findViewById(R.id.btn_directory);
        mMiniFormCheck = (CheckBox) findViewById(R.id.checkbox_id);
        mSaveButton = (CardView) findViewById(R.id.btn_save);
        mDateEditText = (AppCompatEditText) findViewById(R.id.et_start_date);
        mTimeLimitLayout = (TextInputLayout) findViewById(R.id.time_limit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mJoinFileButton.setOnClickListener(this);
        mDefineFieldButton.setOnClickListener(this);
        mResponsibleButton.setOnClickListener(this);
        mSpeakerButton.setOnClickListener(this);
        mActorButton.setOnClickListener(this);
        mAttachFileButton.setOnClickListener(this);
        mEvaluationButton.setOnClickListener(this);
        mLastStatusButton.setOnClickListener(this);
        mDirectoryButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

        mMiniFormCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(NouveauFormulaire.this, "CheckBox enable", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NouveauFormulaire.this, "CheckBox desable", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mDateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (mDateEditText.getText().toString().isEmpty()) {

                    DialogFragment datePicker = new DatePickerFragment();
                    datePicker.show(getSupportFragmentManager(), "date picker");
                } else {
                    //Do nothing
                }

            }
        });

        mDateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (mDateEditText.getText().toString().isEmpty()) {

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
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {

            case R.id.btn_join_file:
                Intent intentToStartAddFieldForm = new Intent(this,AjouterChampDialog.class);
                startActivity(intentToStartAddFieldForm);
                break;
            case R.id.btn_define_field:
                Toast.makeText(this, "Définir les champs", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_responsible:
                Toast.makeText(this, "Responsable", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_speakers:
                Toast.makeText(this, "Participants", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_actors:
                Toast.makeText(this, "Acteurs", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_attach_process:
                Toast.makeText(this, "Attacher le processus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_evaluation:
                Toast.makeText(this, "Critères d'évaluation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_las_status:
                Toast.makeText(this, "Dernier status", Toast.LENGTH_SHORT).show();

            case R.id.btn_directory:
                createPopupDirectory();
                break;
            case R.id.btn_save:
                Toast.makeText(this, "Save button", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        mDateEditText.setText(currentDateString);
    }

    private OnItemSelectedListener mOnItemSelectedListenerThree = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(View view, int position, long id) {

            Toast.makeText(NouveauFormulaire.this, "Item on position " + position + " : " + mSimpleListAdapterThree.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNothingSelected() {
            Toast.makeText(NouveauFormulaire.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    };

    public void createPopupDirectory() {

        initListValuesThree();
        dialogBuilder = new android.app.AlertDialog.Builder(NouveauFormulaire.this);
        View view = getLayoutInflater().inflate(R.layout.directory_dialog, null);

        mSearchDirectory = (SearchableSpinner)view.findViewById(R.id.Search_directory);
        mDsaveButtonDialog = (CardView) view.findViewById(R.id.btn_save);
        
        mSimpleListAdapterThree = new SimpleListAdapter(this, mStringsThree);
        mSimpleArrayListAdapterThree = new SimpleArrayListAdapter(this, mStringsThree);

        mSearchDirectory.setAdapter(mSimpleArrayListAdapterThree);
        mSearchDirectory.setOnItemSelectedListener(mOnItemSelectedListenerThree);

        mSearchDirectory.setStatusListener(new IStatusListener() {
            @Override
            public void spinnerIsOpening() {

            }

            @Override
            public void spinnerIsClosing() {

            }
        });

        mDsaveButtonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NouveauFormulaire.this, "save button", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.setView(view);
        dialogA = dialogBuilder.create();
        dialogA.show();

    }

    private void initListValuesThree() {
        mStringsThree.add("Gestion");
        mStringsThree.add("Ressource");
        mStringsThree.add("Projets");

    }

}
