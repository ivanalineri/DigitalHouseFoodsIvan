package br.com.digitalhouse.digitalhousefoods_ivan.home.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Pratos;

public class DetalhePratoActivity extends AppCompatActivity {
    private ImageView imageViewFotoDetalhePrato;
    private ImageView imageViewBackDetalhePrato;
    private TextView textViewDetalheNomePrato;
    private TextView textViewDetalheDescricaoPrato;
    private Pratos prato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);
        imageViewFotoDetalhePrato = findViewById(R.id.imageViewDetalhePrato);
        imageViewBackDetalhePrato = findViewById(R.id.imageBackDetalhePrato);
        textViewDetalheNomePrato = findViewById(R.id.textViewDetalheNomePrato);
        textViewDetalheDescricaoPrato = findViewById(R.id.textViewDetalheDescricaoPrato);

        if (getIntent() != null && getIntent().getExtras() != null) {
            prato = getIntent().getParcelableExtra("PRATO");

            if (prato != null) {
                imageViewFotoDetalhePrato.setImageResource(prato.getImagem());
                textViewDetalheNomePrato.setText(prato.getNome());
                textViewDetalheDescricaoPrato.setText(prato.getDescricao());

            }

        }

        chamaListaPratos();


    }


    private void chamaListaPratos() {

        imageViewBackDetalhePrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }
}
