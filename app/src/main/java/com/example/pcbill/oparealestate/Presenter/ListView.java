package com.example.pcbill.oparealestate.Presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcbill.oparealestate.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class  ListView extends AppCompatActivity {
    private TextView ListViewTextView;
    private Button ListViewBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initializer();
        ListViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Search.class);
                startActivityForResult(intent,0);
            }
        });

    }
    //todo needs fix 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstaceState)
    {
        ArrayAdapter<String> myAdaptert;
        String [] data ={
                "Οικόπεδο - Αθήνα - Σμολικα - 2 - 10443 - 18/1/97 - 6",
                "Διαμέρισμα - Πατρα - Δυραχιου - 6 - 10543 - 18/1/95 - 7"
        };
        List<String> myList = new ArrayList<String>(Arrays.asList(data));
        //myAdaptert = new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_list_view,R.id.somethin,myList);
        View rootView = inflater.inflate(R.layout.activity_list_view,container,false);
        //ListView listView=(ListView) rootView.findViewById(R.id.listViewListView);
       // listView.setAdapter(myAdaptert);
        return  rootView;
    }

    private void initializer()
    {
        ListViewTextView=(TextView)findViewById(R.id.ListViewTextView);
        ListViewBackButton=(Button)findViewById(R.id.ListViewBackButton);
    }

}
