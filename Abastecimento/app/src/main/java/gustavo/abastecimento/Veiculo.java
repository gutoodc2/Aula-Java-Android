package gustavo.abastecimento;

import java.io.Serializable;

/**
 * Created by gusta on 24/11/2017.
 */

public class Veiculo implements Serializable {

    private double quilometragem;
    private double litros;
    private String data;
    private String posto;

    public Veiculo(double quilometragem, double litros, String data, String posto){
        this.quilometragem = quilometragem;
        this.litros = litros;
        this.data = data;
        this.posto = posto;

    }

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
