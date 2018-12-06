package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
    //todo change same textviews to Autocomplite
    private TextView SearchTexView;
    private AutoCompleteTextView SearchCity;
    private EditText SearchRoomNumber;
    private CheckBox SearchFildCheckBox;
    private CheckBox SearchFlatCheckBox;
    private CheckBox SearchBuildingCheckBox;
    private String value1="";
    private String value2="";
    private String value3="";
    private static final String[] CityList = new String[] {
            "Athens", "Thesaloniki", "Patra","Larisa","Hraklio"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MakeItPretty();
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

                /**for each check box button it set a value to the controller**/
                if(SearchFildCheckBox.isChecked())
                {
                    controler.setField("Field");
                    SearchRoomNumber.setText("0");
                }
                if(SearchFlatCheckBox.isChecked())
                {
                    controler.setFlat("Flat");
                }
                if(SearchBuildingCheckBox.isChecked())
                {
                    controler.setBuilding("building");
                }
                /**object type controller
                 * check data checks if the given data are correct
                 * **/
                if(controler.CheckIsEmpty(getApplicationContext(), SearchCity.getText().toString(),SearchRoomNumber.getText().toString())==false)
                {
                    controler.checkData(getApplicationContext(), SearchCity.getText().toString(),SearchRoomNumber.getText().toString());
                    //shows a message that alla is going well  and its searching
                    Toast toast = Toast.makeText(getApplicationContext(),"Searching",Toast.LENGTH_SHORT);
                    toast.show();
                    //changes the activity
                    Intent intent= new Intent(getApplicationContext(),ListView.class);
                    startActivityForResult(intent,0);
                }
            }
        });


    }
    /**This function connects the Xml file with thw java*/
    private void initializer()
    {
        SearchBackButton=(Button)findViewById(R.id.SearchBackButton);
        SearchSelectBUtton=(Button)findViewById(R.id.SearchSelectButton);
        SearchTexView=(TextView)findViewById(R.id.SearchTextView);
        SearchCity=(AutoCompleteTextView)findViewById(R.id.SearchCity);
        ArrayAdapter<String> adapte2 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,CityList);
        SearchCity.setAdapter(adapte2);
        SearchRoomNumber=(EditText)findViewById(R.id.SearchRoomNumber);
        SearchFildCheckBox=(CheckBox)findViewById(R.id.SearchFildCheckBox);
        SearchFlatCheckBox=(CheckBox)findViewById(R.id.SearchFlatCheckBox);
        SearchBuildingCheckBox=(CheckBox)findViewById(R.id.SearchBuildingCheckBox);
    }
    private void MakeItPretty()
    {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.opa));
    }
}
