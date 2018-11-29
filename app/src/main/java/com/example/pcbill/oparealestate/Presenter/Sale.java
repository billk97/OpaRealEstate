package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcbill.oparealestate.R;

public class Sale extends AppCompatActivity {
    private Button SaleBackButton;
    private Button SaleInsertButton;
    private TextView SaleTextView;
    private EditText SaleType;
    private EditText SaleCity;
    private EditText SaleStreetName;
    private EditText SaleStreetNumber;
    private EditText SalePostNumber;
    private EditText SaleDate;
    private EditText SaleEstateNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        Initializer();
        SaleBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
        SaleInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Type =SaleType.getText().toString();
                String City= SaleCity.getText().toString();
                String StreetNumber=SaleStreetNumber.getText().toString();
                String StreetName =SaleStreetName.getText().toString();
                String PostNumber=SalePostNumber.getText().toString();
                String Date = SaleDate.getText().toString();
                String EstateNumber=SaleDate.getText().toString();
                //in this place a controller Function must be called
                Toast toast = Toast.makeText(getApplicationContext(),"Επιτυχήςς καταχώρηση",Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    private void Initializer()
    {
        SaleBackButton=(Button)findViewById(R.id.SaleBackButton);
        SaleInsertButton=(Button)findViewById(R.id.SaleInsertButton);
        SaleTextView=(TextView) findViewById(R.id.SaleTextView);
        SaleType=(EditText)findViewById(R.id.SaleType);
        SaleCity=(EditText)findViewById(R.id.SaleCity);
        SaleStreetName=(EditText)findViewById(R.id.SaleStreetName);
        SaleStreetNumber=(EditText)findViewById(R.id.SaleStreetNumber);
        SalePostNumber=(EditText)findViewById(R.id.SalePostNumber);
        SaleDate=(EditText)findViewById(R.id.SaleDate);
        SaleEstateNumber=(EditText)findViewById(R.id.SaleEstateNumber);
    }//endInitializer
}
