package gustavo.abastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gusta on 24/11/2017.
 */

public class VeiculoHolder extends RecyclerView.ViewHolder {

    private TextView tvQuilometragem;
    private TextView tvLitros;
    private TextView tvData;
    private ImageView ivPosto;

    public VeiculoHolder(View itemView) {
        super(itemView);

        this.tvQuilometragem = itemView.findViewById(R.id.tvQuilometragem);
        this.tvLitros = itemView.findViewById(R.id.tvLitros);
        this.tvData = itemView.findViewById(R.id.tvData);
        this.ivPosto = itemView.findViewById(R.id.ivPosto);
    }

    public void atualizaOVeiculoQueVoceEstaApresentando(Veiculo v){

        tvData.setText(v.getData());
        tvLitros.setText( Double.toString( v.getLitros()));
        String s = ""+v.getQuilometragem();
        tvQuilometragem.setText(s);

        if(v.getPosto().equals("Petrobras")){
            ivPosto.setImageResource(R.drawable.petrobras);
        }else if (v.getPosto().equals("Ipiranga")){
            ivPosto.setImageResource(R.drawable.ipiranga);
        }else if (v.getPosto().equals("Shell")){
            ivPosto.setImageResource(R.drawable.shell);
        }else if (v.getPosto().equals("Texaco")){
            ivPosto.setImageResource(R.drawable.texaco);
        }
    }
}
