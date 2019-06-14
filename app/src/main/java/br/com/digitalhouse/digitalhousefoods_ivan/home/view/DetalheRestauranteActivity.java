package br.com.digitalhouse.digitalhousefoods_ivan.home.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods_ivan.home.adapters.RecyclerViewPratosAdapter;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Pratos;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Restaurante;

public class DetalheRestauranteActivity extends AppCompatActivity implements RecyclerViewClickListener {
    public RecyclerView recyclerViewPratos;
    public RecyclerViewPratosAdapter adapterPratos;
    private Restaurante restaurante;
    private ImageView imgDetalheRestaurante;
    private ImageView imgvoltar;
    private TextView txtNomeRestaurante;
    private ImageView bckArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante2);
        imgDetalheRestaurante = findViewById(R.id.image_view_pratos_rest);
        imgvoltar = findViewById(R.id.voltar_arrow);
        txtNomeRestaurante = findViewById(R.id.textViewTitulo);
        recyclerViewPratos = findViewById(R.id.recycler_view_pratos);

        chamaosRest();
        bckArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });



        if (getIntent() != null && getIntent().getExtras() != null) {
            restaurante = getIntent().getParcelableExtra("RESTAURANTE");

            if (restaurante != null) {

                imgDetalheRestaurante.setImageResource(restaurante.getPhoto());
                txtNomeRestaurante.setText(restaurante.getTitulo());

                    recyclerViewPratos.setLayoutManager(new GridLayoutManager(this, 2));
                    adapterPratos = new RecyclerViewPratosAdapter(getPrato(),this);
                    recyclerViewPratos.setAdapter(adapterPratos);

            }
        }
    }

    private List<Pratos> getPrato() {
        List<Pratos> pratos = new ArrayList<>();

        for (Pratos registroPrato : restaurante.getPratosCardapio()) {

            pratos.add(registroPrato);
        }


        return pratos;

    }

    private void chamaosRest() {

        imgvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentListaRestaurantes = new Intent(
                        DetalheRestauranteActivity.this, PratosActivity.class);

                startActivity(intentListaRestaurantes);
            }
        });
    }


    @Override
    public void onClick(Restaurante restaurante) {

    }

    @Override
    public void onClick(Pratos pratos) {

        Intent intentDetalhePrato = new Intent(this, DetalhePratoActivity.class);

        intentDetalhePrato.putExtra("PRATO", pratos);

        startActivity(intentDetalhePrato);

    }
}
