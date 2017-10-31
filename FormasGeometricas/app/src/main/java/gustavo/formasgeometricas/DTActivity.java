package gustavo.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DTActivity extends AppCompatActivity {

    private EditText etBase;
    private EditText etAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dt);

        etBase = (EditText) findViewById(R.id.etBase);
        etAltura = (EditText) findViewById(R.id.etAltura);

    }

    public void calcularAreaTri(View quemClicou){

        if(etBase.getText().toString().equals("") || etAltura.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Todos os dados devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intencao = new Intent(getApplicationContext(), RTActivity.class);

        double base = Double.parseDouble(etBase.getText().toString());
        intencao.putExtra("BASE",base);
        double altura = Double.parseDouble(etAltura.getText().toString());
        intencao.putExtra("ALTURA",altura);

        startActivity(intencao);

    }



}
