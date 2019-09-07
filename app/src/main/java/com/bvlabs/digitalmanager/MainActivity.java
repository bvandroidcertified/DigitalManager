package com.bvlabs.digitalmanager;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.IStatusListener;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener,NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    AppCompatEditText mProjectName;
    AppCompatEditText mStartDate;
    AppCompatEditText mEndDate;
    AppCompatEditText mPercentageAuto;
    SearchableSpinner mResearchReceipts;
    SearchableSpinner mResearchSpent;
    AppCompatEditText mBalance;
    TextView mBalanceConclusion;
    TextView mGainConclusion;
    SearchableSpinner mSearchBudget;
    AppCompatEditText mEvaluationEdit;
    SearchableSpinner mSearchEvaluation;
    AppCompatEditText mConsumption;
    AppCompatEditText mGainEdit;
    SearchableSpinner mSearchHumanRes;

    ImageButton mDirectory;
    Button mEditButton;
    Button mSortReceipts;
    Button mSortSpending;
    Button mSortBudget;
    Button mSortHumanRes;
    ImageButton mJoinFile;
    ImageButton mResponsible;
    ImageButton mSpeakers;
    ImageButton mAddingFile;
    ImageButton mActors;
    ImageButton mAttachProcess;
    ImageButton mEvaluation;
    ImageButton mLastStatus;
    FloatingActionButton mProjectNameFab;
    FloatingActionButton mStartDateFab;
    FloatingActionButton mEndDateFab;
    FloatingActionButton mPercentFab;
    FloatingActionButton mReceiptsFab;
    FloatingActionButton mSpendingFab;
    FloatingActionButton mBalanceFab;

    AlertDialog dialog;
    AlertDialog.Builder builder;
    SearchableSpinner mSearchDirectory;
    CardView mDsaveButtonDialog;
    ImageButton mShowOptionButton;
    TextView mShowMsgShowoption;
    LinearLayout mLayoutOption;

    //attributs du dialog déclenché par le FAB
    TextView mLikerOrComment;
    TextView mStatuerEvaluer;


    String[] items = {"Lire", "Commenter", "Evaluer", "Habilitation"};
    String result = "";
    private android.app.AlertDialog.Builder dialogBuilder;
    private android.app.AlertDialog dialogA;

    private SimpleListAdapter mSimpleListAdapterThree;
    private SimpleArrayListAdapter mSimpleArrayListAdapterThree;
    private final ArrayList<String> mStringsThree = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Get items references
        mProjectName = (AppCompatEditText) findViewById(R.id.et_project_name);
        mStartDate = (AppCompatEditText) findViewById(R.id.et_start_date);
        mEndDate = (AppCompatEditText) findViewById(R.id.et_end_date);
        mPercentageAuto = (AppCompatEditText) findViewById(R.id.et_percentage);
        mResearchReceipts = (SearchableSpinner) findViewById(R.id.Search_receipts);
        mResearchSpent = (SearchableSpinner) findViewById(R.id.Search_spending);
        mBalance = (AppCompatEditText) findViewById(R.id.et_balance);
        mBalanceConclusion = (TextView) findViewById(R.id.tv_conclusion);
        mSearchBudget = (SearchableSpinner) findViewById(R.id.Search_budget);
        mEvaluationEdit = (AppCompatEditText) findViewById(R.id.et_evaluation);
        mSearchEvaluation = (SearchableSpinner) findViewById(R.id.Search_evaluation);
        mConsumption = (AppCompatEditText) findViewById(R.id.et_consumption);
        mGainEdit = (AppCompatEditText) findViewById(R.id.et_gain);
        mGainConclusion = (TextView) findViewById(R.id.tv_gain);
        mSearchHumanRes = (SearchableSpinner) findViewById(R.id.Search_human_res);


        mDirectory = (ImageButton) findViewById(R.id.btn_directory);
        mEditButton = (Button) findViewById(R.id.btn_edit);
        mSortReceipts = (Button) findViewById(R.id.btn_sort_receipts);
        mSortSpending = (Button) findViewById(R.id.btn_sort_spending);
        mSortBudget = (Button) findViewById(R.id.btn_sort_budget);
        mSortHumanRes = (Button) findViewById(R.id.btn_sort_human_res);
        mJoinFile = (ImageButton) findViewById(R.id.btn_join_file);
        mResponsible = (ImageButton) findViewById(R.id.btn_responsible);
        mSpeakers = (ImageButton) findViewById(R.id.btn_speakers);
        mAddingFile = (ImageButton) findViewById(R.id.btn_adding_fields);
        mActors = (ImageButton) findViewById(R.id.btn_actors);
        mAttachProcess = (ImageButton) findViewById(R.id.btn_attach_process);
        mEvaluation = (ImageButton) findViewById(R.id.btn_evaluation);
        mLastStatus = (ImageButton) findViewById(R.id.btn_las_status);

        mProjectNameFab = (FloatingActionButton) findViewById(R.id.fab_project_name);
        mStartDateFab = (FloatingActionButton) findViewById(R.id.fab_start_date);
        mEndDateFab = (FloatingActionButton) findViewById(R.id.fab_end_date);
        mPercentFab = (FloatingActionButton) findViewById(R.id.fab_percentage);
        mReceiptsFab = (FloatingActionButton) findViewById(R.id.fab_receipts);
        mSpendingFab = (FloatingActionButton) findViewById(R.id.fab_spending);
        mBalanceFab = (FloatingActionButton) findViewById(R.id.fab_balance);

        mShowOptionButton = (ImageButton) findViewById(R.id.btn_show_option);
        mShowMsgShowoption = (TextView) findViewById(R.id.msg_show_option);
        mLayoutOption = (LinearLayout) findViewById(R.id.option_menu);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mDirectory.setOnClickListener(this);
        mEditButton.setOnClickListener(this);
        mSortReceipts.setOnClickListener(this);
        mSortSpending.setOnClickListener(this);
        mSortBudget.setOnClickListener(this);
        mSortHumanRes.setOnClickListener(this);
        mJoinFile.setOnClickListener(this);
        mResponsible.setOnClickListener(this);
        mSpeakers.setOnClickListener(this);
        mAddingFile.setOnClickListener(this);
        mActors.setOnClickListener(this);
        mAttachProcess.setOnClickListener(this);
        mEvaluation.setOnClickListener(this);
        mLastStatus.setOnClickListener(this);

        mProjectNameFab.setOnClickListener(this);
        mStartDateFab.setOnClickListener(this);
        mEndDateFab.setOnClickListener(this);
        mPercentFab.setOnClickListener(this);
        mReceiptsFab.setOnClickListener(this);
        mSpendingFab.setOnClickListener(this);
        mBalanceFab.setOnClickListener(this);

        mShowOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutOption.getVisibility() == View.VISIBLE) {
                    mShowMsgShowoption.setText(getResources().getString(R.string.open_options));
                    mLayoutOption.setVisibility(View.GONE);
                } else {

                    mShowMsgShowoption.setText(getResources().getString(R.string.close_options));
                    mLayoutOption.setVisibility(View.VISIBLE);
                }

            }
        });

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
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent intentToStartRemplissageFirst = new Intent(this, RemplissageFirst.class);
            startActivity(intentToStartRemplissageFirst);

        } else if (id == R.id.nav_slideshow) {
            Intent intentToStartNouveauFormulaire = new Intent(this, NouveauFormulaire.class);
            startActivity(intentToStartNouveauFormulaire);

        } else if (id == R.id.nav_tools) {
            Intent intentToStartFicheSuiviProjet = new Intent(this, FicheSuiviProjet.class);
            startActivity(intentToStartFicheSuiviProjet);

        } else if (id == R.id.nav_share) {
            Intent intentToStartTrieMiniFormulaire = new Intent(this, TriMiniFormulaire.class);
            startActivity(intentToStartTrieMiniFormulaire);


        } else if (id == R.id.nav_send) {

            Intent intentToStartAddFieldForm = new Intent(this, AjouterChampDialog.class);
            startActivity(intentToStartAddFieldForm);

        } else if (id == R.id.nav_configuration) {

            Intent intentToStartConfigureRelation = new Intent(this, ConfigurerRelationDialog.class);
            startActivity(intentToStartConfigureRelation);

        }else if(id == R.id.nav_filling){

            Intent intentToOPenRemplissage = new Intent(this,RemplissageSecond.class);
            startActivity(intentToOPenRemplissage);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btn_directory:
                createPopupDirectory();
                break;
            case R.id.btn_edit:
                Toast.makeText(this, "Edit option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_join_file:
                Toast.makeText(this, "Join file option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sort_receipts:
                Toast.makeText(this, "sort receipts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sort_spending:
                Toast.makeText(this, "sort spending", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sort_budget:
                Toast.makeText(this, "sort budget", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sort_human_res:
                Toast.makeText(this, "sort human resource", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_responsible:
                Toast.makeText(this, "Responsible option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_speakers:
                Toast.makeText(this, "Speakers option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_attach_process:
                Toast.makeText(this, "Attach process option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_evaluation:
                Toast.makeText(this, "Evaluation option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_las_status:
                Toast.makeText(this, "Last status option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_adding_fields:
                Toast.makeText(this, "Adding field", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_actors:
                Toast.makeText(this, "Actors option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_project_name:
                createPopupForFab();
                break;
            case R.id.fab_start_date:
                createPopupForFab();
                break;
            case R.id.fab_end_date:
                createPopupForFab();
                break;
            case R.id.fab_percentage:
                createPopupForFab();
                break;
            case R.id.fab_receipts:
                createPopupForFab();
                break;
            case R.id.fab_spending:
                createPopupForFab();
                break;
            case R.id.fab_balance:
                createPopupForFab();
                break;

        }
    }

    public void CreatePopupFab() {

        builder = new AlertDialog.Builder(MainActivity.this, R.style.ConfirmationDialogTheme);
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                result = items[which];

            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog = builder.create();
        dialog.show();
    }


    public void createPopupForFab() {

        dialogBuilder = new android.app.AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.fab_dialog, null);

        //Ontenir la reference vers les élement
        mLikerOrComment = (TextView) view.findViewById(R.id.liker_comment);
        mStatuerEvaluer = (TextView) view.findViewById(R.id.statuer_evaluer);


        mLikerOrComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Liker et commenter", Toast.LENGTH_SHORT).show();
            }
        });

        mStatuerEvaluer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Statuer et evaluer", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.setView(view);
        dialogA = dialogBuilder.create();
        dialogA.show();

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

    public void createPopupDirectory() {

        initListValuesThree();
        dialogBuilder = new android.app.AlertDialog.Builder(MainActivity.this);
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
                Toast.makeText(MainActivity.this, "save button", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.setView(view);
        dialogA = dialogBuilder.create();
        dialogA.show();

    }

    private OnItemSelectedListener mOnItemSelectedListenerThree = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(View view, int position, long id) {

            Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mSimpleListAdapterThree.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNothingSelected() {
            Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    };
    private void initListValuesThree() {
        mStringsThree.add("Gestion");
        mStringsThree.add("Ressource");
        mStringsThree.add("Projets");

    }
}
