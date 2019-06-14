package br.com.digitalhouse.digitalhousefoods_ivan.home.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods_ivan.home.adapters.RecyclerViewPratosAdapter;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Pratos;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Restaurante;
import br.com.digitalhouse.digitalhousefoods_ivan.register.RegisterActivity;

public class PratosActivity extends AppCompatActivity implements RecyclerViewClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewPratosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratos);
        recyclerView = findViewById(R.id.recycler_view_pratos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewPratosAdapter(getPratos(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<Pratos> getPratos() {
        List<Pratos> pratos = new ArrayList<>();
        pratos.add(new Pratos("Caramrão a manera", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.vicolo_1));
        pratos.add(new Pratos("Fettucini", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.fettuccine));
        pratos.add(new Pratos("Macarrão com Feijão", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.macarrao_com_feijao_uma));
        pratos.add(new Pratos("Ossobuco de Vitelo", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.ossobuco_de_vitelo_com));
        pratos.add(new Pratos("Feijoada a moda da casa", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.feijoada));
        pratos.add(new Pratos("Lula dorê", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.luladore));
        pratos.add(new Pratos("Prato da Dalva", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.dalvadois));
        pratos.add(new Pratos("Ostras a moda da Casa", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.ostrasdois));
        pratos.add(new Pratos("Entrada ao Molho Madeira", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.entradaaomolho));
        pratos.add(new Pratos("Coxinha Cremosa Caipira", "Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulitá. Sapien in monti palavris qui num significa nadis i pareci latim. Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. In elementis mé pra quem é amistosis quis leo.", R.drawable.coxinhacremosa));

        return pratos;
    }

    @Override
    public void onClick(Restaurante restaurante) {


    }

    @Override
    public void onClick(Pratos pratos) {
        Intent intent = new Intent(this, DetalhePratoActivity.class);
        intent.putExtra("PRATOS", pratos);
        startActivity(intent);

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

            Intent intent = new Intent(PratosActivity.this, RegisterActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
