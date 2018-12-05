package com.example.pcbill.oparealestate.Presenter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcbill.oparealestate.Controler.SaleControler;
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
    /**creates an object SaleControler to communicate with the controller **/
    private SaleControler saleControler = new SaleControler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        MakeItPretty();
        Initializer();
        /**Action taken when the back button is pressed**/
        SaleBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
        /**Action taken when the Insert button is pressed**/
        SaleInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**calls the function check data from the controller
                 * witch checks if the data is accurate and then calls the DBHelper to do the query **/
                saleControler.checkData(getApplicationContext(),SaleType.getText().toString(),SaleCity.getText().toString(),
                        SaleStreetName.getText().toString(),SaleStreetNumber.getText().toString(),SalePostNumber.getText().toString(),
                        SaleDate.getText().toString(),SaleEstateNumber.getText().toString());
                //shows a message  that it  successful
                Toast toast = Toast.makeText(getApplicationContext(),"Επιτυχήςς καταχώρηση",Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    /**This function connects the Xml file with thw java*/
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
    private void MakeItPretty()
    {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.opa));
    }
}
