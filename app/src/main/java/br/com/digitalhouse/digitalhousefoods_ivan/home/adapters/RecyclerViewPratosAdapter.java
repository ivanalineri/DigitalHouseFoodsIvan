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
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Pratos;

public class RecyclerViewPratosAdapter extends RecyclerView.Adapter<RecyclerViewPratosAdapter.ViewHolder> {
    private List<Pratos> prato;
    private RecyclerViewClickListener listener;

    public RecyclerViewPratosAdapter() {
    }


    public RecyclerViewPratosAdapter(List<Pratos> pratos, RecyclerViewClickListener listener) {
        this.prato = pratos;
        this.listener = listener;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pratos_recyclerview_item, viewGroup, false);
        return new RecyclerViewPratosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPratosAdapter.ViewHolder viewHolder, int position) {
        final Pratos pratos = prato.get(position);
        viewHolder.bind(pratos);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(pratos);
            }
        });


    }


    @Override
    public int getItemCount() {
        return prato.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPratosRest;
        private ImageView imageViewFoto;
        private TextView textViewTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPratosRest = itemView.findViewById(R.id.image_view_pratos_rest);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);

        }

        public void bind(Pratos pratos) {
            imageViewFoto.setImageDrawable(ContextCompat
                    .getDrawable(imageViewFoto.getContext(), pratos.getImagem()));
            textViewTitulo.setText(pratos.getDescricao());


        }
    }


}
