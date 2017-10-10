package com.example.internet.curriculumvitae;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Contatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
    }
    public void enviarEmail(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto" , "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Assunto do Email");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Corpo do Email");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));


    }

}
