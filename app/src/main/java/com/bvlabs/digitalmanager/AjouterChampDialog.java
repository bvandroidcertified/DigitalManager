package com.bvlabs.digitalmanager;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.IStatusListener;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener;

public class AjouterChampDialog extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    CardView mAutoModification;
    CardView mSaveButton;
    ImageButton mJoinFileButton;
    ImageButton mEvaluation;
    ImageButton mLastStatus;
    CheckBox mMiniFormCheck;
    Button mCondition;
    Button mColor;

    //Attributs referant aux élements du dialog condition
    EditText mDsoldeEditText;
    SearchableSpinner mDcondition;
    EditText mDcptValueEditText;
    CheckBox mDshowTextCheckBox;
    CheckBox mDcolorCheckBox;
    EditText mDcolorValueEditText;
    EditText mDecheantEditText;
    EditText mDapplicationEditText;

    //Attributs referant aux élements du dialog autres opérations
    EditText mAveragePercentage;
    EditText mSubstraction;
    EditText mSpent;
    SearchableSpinner mSearchAverage;
    CardView mBtnSave;

    //Attributs referant aux élements du dialog resultat
    EditText mDresReceipt;
    SearchableSpinner mDresSubstraction;
    EditText mDresSpent;
    CardView mDresSaveButton;
    CardView mDresOtherOperation;

    AlertDialog dialog;
    AlertDialog.Builder builder;
    AppCompatEditText mDateEditText;

    private android.app.AlertDialog.Builder dialogBuilder;
    private android.app.AlertDialog dialogA;

    private SearchableSpinner mSearchableSpinner;
    private SearchableSpinner mSearchableSpinnerFiledType;

    private SimpleListAdapter mSimpleListAdapter;
    private SimpleArrayListAdapter mSimpleArrayListAdapter;

    private SimpleListAdapter mSimpleListAdapterTwo;
    private SimpleArrayListAdapter mSimpleArrayListAdapterTwo;

    private SimpleListAdapter mSimpleListAdapterThree;
    private SimpleArrayListAdapter mSimpleArrayListAdapterThree;

    private final ArrayList<String> mStrings = new ArrayList<>();
    private final ArrayList<String> mStringsTwo = new ArrayList<>();
    private final ArrayList<String> mStringsThree = new ArrayList<>();


    String[] items = {"Décrémenter", "Incrémenter"};
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_champ_dialog);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mJoinFileButton = (ImageButton) findViewById(R.id.btn_join_file);
        mEvaluation = (ImageButton) findViewById(R.id.btn_evaluation);
        mLastStatus = (ImageButton) findViewById(R.id.btn_las_status);
        mCondition = (Button) findViewById(R.id.btn_condition);
        mColor = (Button) findViewById(R.id.btn_color);
        mMiniFormCheck = (CheckBox) findViewById(R.id.checkbox_required);
        mSaveButton = (CardView) findViewById(R.id.btn_save);
        mAutoModification = (CardView) findViewById(R.id.auto_modification);
        mDateEditText = (AppCompatEditText) findViewById(R.id.et_start_date);

        mJoinFileButton.setOnClickListener(this);
        mEvaluation.setOnClickListener(this);
        mLastStatus.setOnClickListener(this);
        mCondition.setOnClickListener(this);
        mColor.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

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

        mAutoModification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder = new AlertDialog.Builder(AjouterChampDialog.this, R.style.ConfirmationDialogTheme);
                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        result = items[which];

                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(AjouterChampDialog.this, result, Toast.LENGTH_SHORT).show();
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
        });

        mMiniFormCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(AjouterChampDialog.this, "CheckBox enable", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AjouterChampDialog.this, "CheckBox desable", Toast.LENGTH_SHORT).show();
                }
            }
        });


        initListValues();
        initListValuesTwo();
        mSimpleListAdapter = new SimpleListAdapter(this, mStrings);
        mSimpleArrayListAdapter = new SimpleArrayListAdapter(this, mStrings);

        mSimpleListAdapterTwo = new SimpleListAdapter(this, mStringsTwo);
        mSimpleArrayListAdapterTwo = new SimpleArrayListAdapter(this, mStringsTwo);

        mSearchableSpinner = (SearchableSpinner) findViewById(R.id.SearchableSpinner);
        mSearchableSpinner.setAdapter(mSimpleArrayListAdapter);
        mSearchableSpinner.setOnItemSelectedListener(mOnItemSelectedListener);

        mSearchableSpinner.setStatusListener(new IStatusListener() {
            @Override
            public void spinnerIsOpening() {
                mSearchableSpinnerFiledType.hideEdit();
            }

            @Override
            public void spinnerIsClosing() {

            }
        });

        mSearchableSpinnerFiledType = (SearchableSpinner) findViewById(R.id.Search_field_type);
        mSearchableSpinnerFiledType.setAdapter(mSimpleArrayListAdapterTwo);
        mSearchableSpinnerFiledType.setOnItemSelectedListener(mOnItemSelectedListenerTwo);
        mSearchableSpinnerFiledType.setStatusListener(new IStatusListener() {
            @Override
            public void spinnerIsOpening() {
                mSearchableSpinner.hideEdit();
            }

            @Override
            public void spinnerIsClosing() {

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
        mDateEditText.setText(currentDateString);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btn_join_file:
                Toast.makeText(this, "Joindre un fichier", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_evaluation:
                Toast.makeText(this, "Critère evaluation", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_las_status:
                Toast.makeText(this, "Définir status", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_condition:
                createPopupDialog();
                break;

            case R.id.btn_color:
                createPopupResultatDialog();
                break;

            case R.id.btn_save:
                Toast.makeText(this, "Save button", Toast.LENGTH_SHORT).show();
                break;
        }

    }


    public void createPopupDialog() {

        dialogBuilder = new android.app.AlertDialog.Builder(AjouterChampDialog.this);
        View view = getLayoutInflater().inflate(R.layout.ajout_condition_dialog, null);

        //Obtenir la reference vers les elements
        mDsoldeEditText = (EditText) view.findViewById(R.id.et_solde);
        mDcondition = (SearchableSpinner) view.findViewById(R.id.Search_condition);
        mDcptValueEditText = (EditText) view.findViewById(R.id.et_cpt_value);
        mDshowTextCheckBox = (CheckBox) view.findViewById(R.id.show_text_id);
        mDcolorCheckBox = (CheckBox) view.findViewById(R.id.color_id);
        mDcolorValueEditText = (EditText) view.findViewById(R.id.et_color);
        mDecheantEditText = (EditText) view.findViewById(R.id.et_echeant);
        mDapplicationEditText = (EditText) view.findViewById(R.id.et_application);

        dialogBuilder.setView(view);
        dialogA = dialogBuilder.create();
        dialogA.show();

        mDshowTextCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(AjouterChampDialog.this, "CheckBox enable", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AjouterChampDialog.this, "CheckBox desable", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mDcolorCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(AjouterChampDialog.this, "CheckBox enable", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AjouterChampDialog.this, "CheckBox desable", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void createPopupResultatDialog() {

        dialogBuilder = new android.app.AlertDialog.Builder(AjouterChampDialog.this);
        View view = getLayoutInflater().inflate(R.layout.resultat_dialog, null);

        mDresReceipt = (EditText) view.findViewById(R.id.et_receipts);
        mDresSubstraction = (SearchableSpinner) view.findViewById(R.id.Search_minus);
        mDresSpent = (EditText) view.findViewById(R.id.et_spent);
        mDresSaveButton = (CardView) view.findViewById(R.id.btn_save);
        mDresOtherOperation = (CardView) view.findViewById(R.id.btn_other_operation);
        mDresSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AjouterChampDialog.this, "Save button", Toast.LENGTH_SHORT).show();
            }
        });
        mDresOtherOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(AjouterChampDialog.this, "Other Operation", Toast.LENGTH_SHORT).show();
                createPopupResultatAutresDialog();
            }
        });
        dialogBuilder.setView(view);
        dialogA = dialogBuilder.create();
        dialogA.show();

    }

    public void createPopupResultatAutresDialog() {

        initListValuesThree();
        dialogBuilder = new android.app.AlertDialog.Builder(AjouterChampDialog.this);
        View view = getLayoutInflater().inflate(R.layout.resultat_autre_operation_dialog, null);

        //Ontenir la reference vers les élement
        mAveragePercentage = (EditText) view.findViewById(R.id.average_percentage_id);
        mSpent = (EditText) view.findViewById(R.id.et_spent);
        mSearchAverage = (SearchableSpinner) view.findViewById(R.id.Search_average);
        mBtnSave = (CardView) view.findViewById(R.id.btn_save);

        mSimpleListAdapterThree = new SimpleListAdapter(this, mStringsThree);
        mSimpleArrayListAdapterThree = new SimpleArrayListAdapter(this, mStringsThree);

        mSearchAverage.setAdapter(mSimpleArrayListAdapterThree);
        mSearchAverage.setOnItemSelectedListener(mOnItemSelectedListenerThree);

        mSearchAverage.setStatusListener(new IStatusListener() {
            @Override
            public void spinnerIsOpening() {
                mSearchableSpinner.hideEdit();
                mSearchableSpinnerFiledType.hideEdit();
            }

            @Override
            public void spinnerIsClosing() {

            }
        });

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AjouterChampDialog.this, "Save button", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.setView(view);
        dialogA = dialogBuilder.create();
        dialogA.show();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!mSearchableSpinner.isInsideSearchEditText(event)) {
            mSearchableSpinner.hideEdit();
        }
        if (!mSearchableSpinnerFiledType.isInsideSearchEditText(event)) {
            mSearchableSpinnerFiledType.hideEdit();
        }
        return super.onTouchEvent(event);
    }

    private OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(View view, int position, long id) {
            Toast.makeText(AjouterChampDialog.this, "Item on position " + position + " : " + mSimpleListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected() {
            Toast.makeText(AjouterChampDialog.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    };

    private OnItemSelectedListener mOnItemSelectedListenerTwo = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(View view, int position, long id) {

            if (position == 7) {
                //createPopupResultatAutresDialog();
                createPopupResultatDialog();
            } else {
                Toast.makeText(AjouterChampDialog.this, "Item on position " + position + " : " + mSimpleListAdapterTwo.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected() {
            Toast.makeText(AjouterChampDialog.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    };

    private OnItemSelectedListener mOnItemSelectedListenerThree = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(View view, int position, long id) {

            if (position == 7) {
                createPopupResultatAutresDialog();
            } else {
                Toast.makeText(AjouterChampDialog.this, "Item on position " + position + " : " + mSimpleListAdapterThree.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected() {
            Toast.makeText(AjouterChampDialog.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    };

    private void initListValues() {
        mStrings.add("Status");
        mStrings.add("Evaluation");
        mStrings.add("RH");
        mStrings.add("Recettes");
        mStrings.add("Dépenses");
    }

    private void initListValuesTwo() {
        mStringsTwo.add("Texte");
        mStringsTwo.add("Nombre");
        mStringsTwo.add("Pourcentage");
        mStringsTwo.add("Choix");
        mStringsTwo.add("Liste");
        mStringsTwo.add("Sélection");
        mStringsTwo.add("Résultat");
        mStringsTwo.add("Date");
        mStringsTwo.add("Couleur");
        mStringsTwo.add("Signature");
        mStringsTwo.add("Echéance");
        mStringsTwo.add("Echéancier");

    }

    private void initListValuesThree() {
        mStringsThree.add("Aucune");
        mStringsThree.add("Pourcentage");
        mStringsThree.add("Moyenne");
        mStringsThree.add("Nombre");
        mStringsThree.add("Maximum");
        mStringsThree.add("Minimum");
    }


}
