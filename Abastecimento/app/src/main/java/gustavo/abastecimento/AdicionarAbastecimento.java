package gustavo.abastecimento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by gusta on 24/11/2017.
 */

public class AdicionarAbastecimento extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        Spinner postos = (Spinner) findViewById(R.id.spPosto);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.postos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        postos.setAdapter(adapter);

    }

    public void confirmar(View click){


        EditText quilometragem = (EditText) findViewById(R.id.etQuilometragem);
        EditText litros = (EditText) findViewById(R.id.etLitros);
        EditText data = (EditText) findViewById(R.id.etData);
        Spinner posto = (Spinner) findViewById(R.id.spPosto);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Veiculo> testador = realm.where(Veiculo.class).findAll();

        double comparador = Double.parseDouble(quilometragem.getText().toString());

        if (!testador.isEmpty()) {
            if (comparador < testador.get(testador.size() - 1).getQuilometragem()) {
                Toast.makeText(getApplicationContext(), "Quilometragem Inválida!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
                realm.beginTransaction();
                Veiculo a = realm.createObject(Veiculo.class);
                a.setQuilometragem(Double.parseDouble(quilometragem.getText().toString()));
                a.setLitros(Double.parseDouble(litros.getText().toString()));
                a.setData(data.getText().toString());
                a.setPosto(posto.getSelectedItem().toString());
                realm.copyFromRealm(a);

                realm.commitTransaction();

        Intent intencao = new Intent(this, MainActivity.class);
        startActivity(intencao);
        finish();
    }
 }


