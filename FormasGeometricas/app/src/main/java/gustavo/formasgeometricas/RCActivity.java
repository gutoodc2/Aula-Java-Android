package gustavo.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class RCActivity extends AppCompatActivity {

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        Bundle bundle = getIntent().getExtras();
        double resultado,raio;

        if(bundle.containsKey("RAIO")){
            raio = bundle.getDouble("RAIO");
            resultado = 3.14159265359 * (raio*raio);
            tvResultado.setText(String.format("%.2f", resultado));
        }

    }

    public void calcularNovamente(View quemClicou){

        Intent intencao = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencao);

    }



}
