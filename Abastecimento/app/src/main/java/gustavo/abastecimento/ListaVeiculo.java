package gustavo.abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListaVeiculo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculo);

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);

        VeiculoAdapter adapter = new VeiculoAdapter();
        adapter.setListaVeiculos((ArrayList<Veiculo>) getIntent().getSerializableExtra("lista"));
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter(adapter);

    }

}


