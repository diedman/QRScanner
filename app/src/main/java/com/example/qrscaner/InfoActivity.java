package com.example.qrscaner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class InfoActivity extends AppCompatActivity {

    TextView tvTittle, tvLastname, tvFirstname, tvDateTime;
    Button btnRescan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        initFields();

        Bundle arguments = getIntent().getExtras();

        if(arguments.getSerializable(QREventData.class.getSimpleName()) != null) {
            QREventData qrEventData = (QREventData) arguments.getSerializable(QREventData.class.getSimpleName());
            tvTittle.setText(qrEventData.getEventTitle());
            tvLastname.setText(qrEventData.getLastname());
            tvFirstname.setText(qrEventData.getFirstname());

            Date date = qrEventData.getMeetingDate();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

            tvDateTime.setText(dateFormat.format(date));
        }
        else if(arguments.getSerializable(QRCoworkingData.class.getSimpleName()) != null) {
            QRCoworkingData qrCoworkingData = (QRCoworkingData) arguments.getSerializable(QRCoworkingData.class.getSimpleName());
            tvTittle.setText(qrCoworkingData.getSpaceTitle());
            tvLastname.setText(qrCoworkingData.getLastname());
            tvFirstname.setText(qrCoworkingData.getFirstname());

            Date date = qrCoworkingData.getStartSessionDateTime();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

            tvDateTime.setText(dateFormat.format(date));
        }

    }

    public void initFields(){
        tvTittle    = findViewById(R.id.textViewTittle);
        tvLastname  = findViewById(R.id.textViewLastname);
        tvFirstname = findViewById(R.id.textViewFirstname);
        tvDateTime  = findViewById(R.id.textViewDateTime);
        btnRescan   = findViewById(R.id.btn_Rescan);

        btnRescan.setOnClickListener(view -> {
            Intent intent = new Intent(InfoActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
