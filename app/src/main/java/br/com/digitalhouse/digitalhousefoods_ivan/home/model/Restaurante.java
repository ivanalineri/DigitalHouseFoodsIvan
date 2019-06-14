package br.com.digitalhouse.digitalhousefoods_ivan.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Parcelable {

    private String titulo;
    private String texto;
    private String hora;
    private int photo;
    private List<Pratos> pratosCardapio = new ArrayList<>();


    public Restaurante() {
    }

    public Restaurante(String titulo, String texto, int photo, String hora) {
        this.titulo = titulo;
        this.texto = texto;
        this.photo = photo;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public static Creator<Restaurante> getCREATOR() {
        return CREATOR;
    }
    public List<Pratos> getPratosCardapio() {
        return pratosCardapio;
    }


    protected Restaurante(Parcel in) {
        titulo = in.readString();
        texto = in.readString();
        photo = in.readInt();
        hora = in.readString();
        pratosCardapio = in.createTypedArrayList(Pratos.CREATOR);
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(texto);
        parcel.writeInt(photo);
        parcel.writeString(hora);
        parcel.writeTypedList(pratosCardapio);

    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
