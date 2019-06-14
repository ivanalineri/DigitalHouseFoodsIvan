package br.com.digitalhouse.digitalhousefoods_ivan.home;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Pratos;
import br.com.digitalhouse.digitalhousefoods_ivan.home.model.Restaurante;

public interface RecyclerViewClickListener {
    void onClick(Restaurante restaurante);

    void onClick(Pratos pratos);
}
