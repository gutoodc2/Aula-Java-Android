package gustavo.abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by gusta on 24/11/2017.
 */

public class ListaVeiculo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculo);

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        Realm realm = Realm.getDefaultInstance();

        ArrayList<Veiculo> lista = new ArrayList<>();

        RealmResults<Veiculo> result1    = realm.where(Veiculo.class).findAll();

        for(int i = 0; i < result1.size(); i++){
            Veiculo objt = result1.get(i);
            lista.add(objt);
        }

        VeiculoAdapter adapter = new VeiculoAdapter();
        adapter.setListaVeiculos(lista);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter(adapter);

    }

}


