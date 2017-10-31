package gustavo.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RTActivity extends AppCompatActivity {

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rt);

        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        Bundle bundle = getIntent().getExtras();
        double resultado,base,altura;

        if(bundle.containsKey("BASE") && bundle.containsKey("ALTURA") ){
            base = bundle.getDouble("BASE");
            altura = bundle.getDouble("ALTURA");

            resultado = (base * altura)/2;
            tvResultado.setText( String.format("%.2f", resultado));

        }

    }

    public void calcularNovamente(View quemClicou){

        Intent intencao = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencao);

    }

}
