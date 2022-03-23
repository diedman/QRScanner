package com.example.qrscaner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    TextView textViewLastname, textViewFirstname, textViewTittle;
    Button btn_Rescan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        initFields();

        Bundle arguments = getIntent().getExtras();

        if(arguments.getSerializable(QREventData.class.getSimpleName()) != null){
            QREventData qrEventData = (QREventData) arguments.getSerializable(QREventData.class.getSimpleName());
            textViewTittle.setText(qrEventData.getEventTitle());
            textViewLastname.setText(qrEventData.getLastname());
            textViewFirstname.setText(qrEventData.getFirstname());
        }
        else if(arguments.getSerializable(QRCoworkingData.class.getSimpleName()) != null){
            QRCoworkingData qrCoworkingData = (QRCoworkingData) arguments.getSerializable(QRCoworkingData.class.getSimpleName());
            textViewTittle.setText(qrCoworkingData.getSpaceTitle());
            textViewLastname.setText(qrCoworkingData.getLastname());
            textViewFirstname.setText(qrCoworkingData.getFirstname());
        }

    }

    public void initFields(){
        textViewLastname = findViewById(R.id.textViewLastname);
        textViewFirstname = findViewById(R.id.textViewFirstname);
        textViewTittle = findViewById(R.id.textViewTittle);
        btn_Rescan = findViewById(R.id.btn_Rescan);
        btn_Rescan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
