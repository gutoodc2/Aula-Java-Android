package gustavo.abastecimento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by gusta on 24/11/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        Realm realm = Realm.getDefaultInstance();

        ArrayList<Veiculo> lista2 = new ArrayList<>();

        RealmResults<Veiculo> result2 = realm.where(Veiculo.class).findAll();

        for(int i = 0; i < result2.size(); i++){
            Veiculo objt = result2.get(i);
            lista2.add(objt);
        }

        double litros=0,quilometragem=0;
        for(int i = 0; i < lista2.size(); i++){
            litros+=lista2.get(i).getLitros();
            quilometragem+=lista2.get(i).getQuilometragem();
        }
        quilometragem/=litros;
        TextView tvResultado  = (TextView) findViewById(R.id.tvResultado);
        tvResultado.setText(String.format("%.4f", quilometragem));

    }

    public void adicionarAbastecimento(View click){
        Intent intencao = new Intent(this, AdicionarAbastecimento.class);
        startActivity(intencao);
    }

    public void visualizarAbastecimento(View click){
        Intent intencao = new Intent(this, ListaVeiculo.class);
        startActivity(intencao);
    }

}
