package br.com.digitalhouse.digitalhousefoods_ivan.home.view;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Restaurante;

public class DetalheRestaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);
        checkIntent();
    }

    private void checkIntent() {
        if(getIntent() != null && getIntent().getExtras() != null){
            Restaurante restaurante = getIntent().getParcelableExtra("RESTAURANTE");

            if(restaurante != null){
            }

        }
    }
}
