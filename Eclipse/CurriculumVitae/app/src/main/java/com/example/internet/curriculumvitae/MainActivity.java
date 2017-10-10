package com.example.internet.curriculumvitae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abrirActivityDadosPessoais(View view){
        Intent it = new Intent(this.getApplicationContext(),DadosPessoaisActivity.class);
        startActivity(it);
    }
    public void abrirActivityDadosProfissionais(View view){
        Intent it = new Intent(this.getApplicationContext(),DadosProfissionais.class);
        startActivity(it);

    }

    public void abrirActivityContatos(View view){
        Intent it = new Intent(this.getApplicationContext(),Contatos.class);
        startActivity(it);
    }
}
