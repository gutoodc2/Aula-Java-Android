package gustavo.abastecimento;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VeiculoAdapter extends RecyclerView.Adapter {

    private ArrayList<Veiculo> listaVeiculos;

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.veiculo_item, parent, false);
        VeiculoHolder gaveta = new VeiculoHolder(layoutView);
        Log.d("RV", "Criando a gaveta "+gaveta.toString());
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VeiculoHolder gaveta = (VeiculoHolder) holder;
        Veiculo atual = this.listaVeiculos.get(position);
        gaveta.atualizaOVeiculoQueVoceEstaApresentando( atual );
        Log.d("RV", "Atualizando a gaveta "+gaveta.toString()+" com o objteto "+position);

    }

    @Override
    public int getItemCount() {
        return this.listaVeiculos.size();
    }


}
