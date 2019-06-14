package br.com.digitalhouse.digitalhousefoods_ivan.home.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Restaurante;

public class RecyclerViewRestauranteAdapter extends RecyclerView.Adapter<RecyclerViewRestauranteAdapter.ViewHolder> {
    private List<Restaurante> restaurantes;
    private RecyclerViewClickListener listener;

    public RecyclerViewRestauranteAdapter() {
    }

    public RecyclerViewRestauranteAdapter(List<Restaurante> restaurantes, RecyclerViewClickListener listener) {
        this.restaurantes = restaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurante_recyclerview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewRestauranteAdapter.ViewHolder viewHolder, int position) {
        final Restaurante restaurante = restaurantes.get(position);
        viewHolder.bind(restaurante);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurante);
            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewFoto;
        private TextView textViewTitulo;
        private TextView textViewTexto;
        private TextView textViewHora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewTexto = itemView.findViewById(R.id.textViewTexto);
            textViewHora = itemView.findViewById(R.id.textViewHora);


        }

        public void bind(Restaurante restaurante) {

            imageViewFoto.setImageDrawable(ContextCompat
            .getDrawable(imageViewFoto.getContext(), restaurante.getPhoto()));
            textViewTitulo.setText(restaurante.getTitulo());
            textViewTexto.setText(restaurante.getTexto());
            textViewHora.setText(restaurante.getHora());

        }
    }




}
