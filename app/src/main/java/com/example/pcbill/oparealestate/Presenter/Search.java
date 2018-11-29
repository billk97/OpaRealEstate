package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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
                Toast toast = Toast.makeText(getApplicationContext(),"Αναζήτηση",Toast.LENGTH_SHORT);
                toast.show();
                //Intent intent= new Intent(getApplicationContext(),List.class);
               // startActivityForResult(intent,0);
            }
        });
        /**CheckBox field*/
        SearchFildCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SearchFildCheckBox.isChecked())
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),"UnChecked",Toast.LENGTH_SHORT);
                        toast.show();
                    }
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
