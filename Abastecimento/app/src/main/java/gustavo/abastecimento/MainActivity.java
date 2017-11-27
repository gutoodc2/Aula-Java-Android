package gustavo.abastecimento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Veiculo> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void adicionarAbastecimento(View click){
        Intent intencao = new Intent(this, AdicionarAbastecimento.class);
        intencao.putExtra("lista", lista);
        startActivityForResult(intencao, 1);
    }

    public void visualizarAbastecimento(View click){
        Intent intencao = new Intent(this, ListaVeiculo.class);
        intencao.putExtra("lista", lista);
        startActivity(intencao);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                lista = (ArrayList<Veiculo>) data.getSerializableExtra("lista");
                double litros=0;
                double quilometragem=0;
                for(int i = 0; i < lista.size(); i++){
                    litros+=lista.get(i).getLitros();
                    quilometragem+=lista.get(i).getQuilometragem();
                }
                quilometragem/=litros;
                TextView autonomia  = (TextView) findViewById(R.id.tvResultado);
                autonomia.setText(String.format("%.4f", quilometragem));
            }
        }
    }


}
