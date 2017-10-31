package gustavo.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDados(View quemClicou){
        RadioGroup rgFigura = (RadioGroup) findViewById(R.id.rgFigura);
        if(rgFigura.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Selecione a forma geométrica", Toast.LENGTH_SHORT).show();
            return;
        }

        if(rgFigura.getCheckedRadioButtonId() == R.id.rbTriangulo){
            Intent intencao = new Intent(getApplicationContext(), DTActivity.class);
            startActivity(intencao);
        }
        if(rgFigura.getCheckedRadioButtonId() == R.id.rbRetangulo){
            Intent intencao = new Intent(getApplicationContext(), DRActivity.class);
            startActivity(intencao);
        }
        if(rgFigura.getCheckedRadioButtonId() == R.id.rbCirculo){
            Intent intencao = new Intent(getApplicationContext(), DCActivity.class);
            startActivity(intencao);
        }

    }
}
