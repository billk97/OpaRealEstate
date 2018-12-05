package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcbill.oparealestate.DBmodel.DBHelper;
import com.example.pcbill.oparealestate.R;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button Search;
    Button Sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeItPretty();
        initializeVariables();
        /**Action taken when the search button is selected**/
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates a new Intent that onClick goes to activity Search
                Intent myIntent = new Intent(view.getContext(), Search.class);
                startActivityForResult(myIntent,0);
            }
        });
        /**Action taken when the sale button is selected**/
        Sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates a new Intent that onClick goes to activity Sale
                Intent myIntent = new Intent(view.getContext(),Sale.class);
                startActivityForResult(myIntent,0);
            }
        });

    }
    /**This function connects the Xml file with thw java*/
    private void initializeVariables()
    {
        textView=(TextView) findViewById(R.id.MainTextView);
        Search=(Button)findViewById(R.id.Searchbutton);
        Sale=(Button)findViewById(R.id.Salebutton);
    }
    /**self explanatory **/
    private void MakeItPretty()
    {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.opa));
    }
}
