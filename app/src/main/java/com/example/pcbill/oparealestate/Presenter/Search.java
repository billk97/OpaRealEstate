package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcbill.oparealestate.Controler.SearchControler;
import com.example.pcbill.oparealestate.R;

public class Search extends AppCompatActivity {
    private Button SearchBackButton;
    private Button SearchSelectBUtton;
    private TextView SearchTexView;
    private EditText SearchCity;
    private EditText SearchRoomNumber;
    private CheckBox SearchFildCheckBox;
    private CheckBox SearchFlatCheckBox;
    private CheckBox SearchBuildingCheckBox;
    private String value1="";
    private String value2="";
    private String value3="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.opa));
        setContentView(R.layout.activity_search);
        final SearchControler controler = new SearchControler();
        initializer();
        /**Buck Button*/
        SearchBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
        /**SelectButton**/
        SearchSelectBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controler.checkData(getApplicationContext(), SearchCity.getText().toString(),SearchRoomNumber.getText().toString());
                if(SearchFildCheckBox.isChecked())
                {
                    controler.setValue1("Οικόπαιδο");
                }
                if(SearchFlatCheckBox.isChecked())
                {
                    controler.setValue2("Διαμέρισμα");
                }
                if(SearchBuildingCheckBox.isChecked())
                {
                    controler.setValue3("Κτίριο");
                }
                Toast toast = Toast.makeText(getApplicationContext(),"Αναζήτηση",Toast.LENGTH_SHORT);
                toast.show();
                Intent intent= new Intent(getApplicationContext(),ListView.class);
                startActivityForResult(intent,0);
            }
        });


    }
    private void initializer()
    {
        SearchBackButton=(Button)findViewById(R.id.SearchBackButton);
        SearchSelectBUtton=(Button)findViewById(R.id.SearchSelectButton);
        SearchTexView=(TextView)findViewById(R.id.SearchTextView);
        SearchCity=(EditText)findViewById(R.id.SearchCity);
        SearchRoomNumber=(EditText)findViewById(R.id.SearchRoomNumber);
        SearchFildCheckBox=(CheckBox)findViewById(R.id.SearchFildCheckBox);
        SearchFlatCheckBox=(CheckBox)findViewById(R.id.SearchFlatCheckBox);
        SearchBuildingCheckBox=(CheckBox)findViewById(R.id.SearchBuildingCheckBox);
    }
}
