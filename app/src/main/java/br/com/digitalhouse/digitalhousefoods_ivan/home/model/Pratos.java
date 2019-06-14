package br.com.digitalhouse.digitalhousefoods_ivan.home.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pratos implements Parcelable {
    private String nome;
    private String descricao;
    private int imagem;

    public Pratos() {
    }

    public Pratos(String nome, String descricao, int imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    protected Pratos(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        imagem = in.readInt();
    }

    public static final Creator<Pratos> CREATOR = new Creator<Pratos>() {
        @Override
        public Pratos createFromParcel(Parcel in) {
            return new Pratos(in);
        }

        @Override
        public Pratos[] newArray(int size) {
            return new Pratos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeInt(imagem);
    }


}
