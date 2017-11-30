package gustavo.abastecimento;

import android.text.Editable;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by gusta on 24/11/2017.
 */

public class Veiculo extends RealmObject {

    private double quilometragem;
    private double litros;
    private String data;
    private String posto;

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
