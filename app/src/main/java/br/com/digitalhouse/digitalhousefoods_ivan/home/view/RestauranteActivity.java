package br.com.digitalhouse.digitalhousefoods_ivan.home.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods_ivan.home.adapters.RecyclerViewRestauranteAdapter;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Restaurante;
import br.com.digitalhouse.digitalhousefoods_ivan.register.RegisterActivity;

public class RestauranteActivity extends AppCompatActivity implements RecyclerViewClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewRestauranteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
        recyclerView = findViewById(R.id.recyclerViewRestaurantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewRestauranteAdapter(getRestaurantes(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<Restaurante> getRestaurantes() {
        List<Restaurante> restaurantes = new ArrayList<>();

        restaurantes.add(new Restaurante("Vicolo Nostro", "Rua Jataituba, 29 ", R.drawable.vicolo,"18:00 - 23:00"));
        restaurantes.add(new Restaurante("Dalva e Dito", "R. Padre João Manuel, 1115 ", R.drawable.dalva, "18:00 - 23:00"));
        restaurantes.add(new Restaurante("A Figueira Rubaiyat", "Rua Haddock Lobo, 1738, ", R.drawable.figueira ,"18:00 - 23:00"));
        restaurantes.add(new Restaurante("Chez Vous", "Av. Lavandisca, 395 ", R.drawable.chez, "18:00 - 23:00"));
        restaurantes.add(new Restaurante("911 Restaurante", "Alameda Lorena, 2101 ", R.drawable.novecentos, "18:00 - 23:00"));


        return restaurantes;
    }


    @Override
    public void onClick(Restaurante restaurante) {
        Intent intent = new Intent(this, DetalheRestaurante.class);
        intent.putExtra("RESTAURANTE", restaurante);
        startActivity(intent);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            Intent intent = new Intent(RestauranteActivity.this, RegisterActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
