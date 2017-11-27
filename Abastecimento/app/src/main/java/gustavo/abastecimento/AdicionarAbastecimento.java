package gustavo.abastecimento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gusta on 24/11/2017.
 */

public class AdicionarAbastecimento extends AppCompatActivity {


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

        ArrayList<Veiculo> lista;

        lista = (ArrayList<Veiculo>) getIntent().getSerializableExtra("lista");

        EditText quilometragem = (EditText) findViewById(R.id.etQuilometragem);
        EditText litros = (EditText) findViewById(R.id.etLitros);
        EditText data = (EditText) findViewById(R.id.etData);
        Spinner posto = (Spinner) findViewById(R.id.spPosto);

            if (!lista.isEmpty()) {
                if (Double.parseDouble(quilometragem.getText().toString()) < lista.get(lista.size() - 1).getQuilometragem()) {
                    Toast.makeText(getApplicationContext(), "Quilometragem Inválida", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Veiculo abastecimento = new Veiculo(Double.parseDouble(quilometragem.getText().toString()), Double.parseDouble(litros.getText().toString()), data.getText().toString(), posto.getSelectedItem().toString());

            lista.add(abastecimento);

            Intent intencao = new Intent(this, MainActivity.class);
            intencao.putExtra("lista", lista);
            setResult(Activity.RESULT_OK, intencao);
            intencao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
    }
 }


