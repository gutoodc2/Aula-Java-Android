package gustavo.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DCActivity extends AppCompatActivity {

    private EditText etRaio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dc);

        etRaio = (EditText) findViewById(R.id.etRaio);
    }
    public void calcularRaio(View quemClicou){

        if(etRaio.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Todos os dados devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intencao = new Intent(getApplicationContext(), RCActivity.class);

        double raio = Double.parseDouble(etRaio.getText().toString());
        intencao.putExtra("RAIO",raio);

        startActivity(intencao);

    }
}
