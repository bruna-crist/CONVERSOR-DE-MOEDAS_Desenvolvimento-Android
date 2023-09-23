package devandroid.bruna.coversordemoedas;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;


public class TelaInicial extends AppCompatActivity {

    private TextView tvReal;
    private TextView tvDolar;
    private TextView tvBitcoin;
    private EditText editReal;
    private EditText editDolar;
    private EditText editBitcoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        tvReal = findViewById(R.id.tvReal);
        tvDolar = findViewById(R.id.tvDolar);
        tvBitcoin = findViewById(R.id.tvBitcoin);
        editReal = findViewById(R.id.editReal);
        editDolar = findViewById(R.id.editDolar); // Corrigido de editReal para editDolar
        editBitcoin = findViewById(R.id.editBitcoin);
    }

    public void verificar(View view){
        double real = Double.parseDouble(editReal.getText().toString());
        double dolar = 4.94;
        double bitcoin = 0.0000076;


        double valorReal = dolar * real;
        double valorDolar = real / dolar;
        double valorBitcoin = real * bitcoin;
        tvReal.setText(""+ valorReal);
        tvDolar.setText(""+valorDolar);
        tvBitcoin.setText(""+valorBitcoin);
    }
    public void abrirSiteBancoCentral(View view) {
        // URL do site do Banco Central do Brasil
        String url = "https://www.bcb.gov.br/";

        // Intent para abrir o navegador com a URL
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        // Verificação de  navegadores disponíveis no dispositivo
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);

        // Se houver navegadores disponíveis, vai da inicio
        if (activities.size() > 0) {
            startActivity(intent);
        } else {
            // senao, vai mostrar uma mensagem de erro
            Toast.makeText(this, "Nenhum navegador disponível", Toast.LENGTH_SHORT).show();
        }
    }

}