package tdm2018.ittepic.edu.tdm2018_u4_41_hilos;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText numero1, numero2,numero3;
    Button start1,start2,start3;
    ProgressBar progreso1, progreso2,progreso3;
    private Handler handler = new Handler();
    private int i,prog,prog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1=(EditText)findViewById(R.id.editTextDat1);
        numero2=(EditText)findViewById(R.id.editTextDat2);
        numero3=(EditText)findViewById(R.id.editTextDat3);
        start1=(Button)findViewById(R.id.btnStar1);
        start2=(Button)findViewById(R.id.btnStar2);
        start3=(Button)findViewById(R.id.btnStar3);
        progreso1=(ProgressBar) findViewById(R.id.progressBar1);
        progreso2=(ProgressBar)findViewById(R.id.progressBar2);
        progreso3=(ProgressBar)findViewById(R.id.progressBar3);
        start1.setOnClickListener(MainActivity.this);
        start2.setOnClickListener(MainActivity.this);
        start3.setOnClickListener(MainActivity.this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStar1:

                //new Progreso().execute();
                try{

                    if (numero1.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"campo 1 esta vacio",Toast.LENGTH_SHORT).show();
                    }else {
                        hilos1();
                    }
                }catch(Exception e){
                    e.printStackTrace();

                }
                break;

            case R.id.btnStar2:
                try {
                    if (numero1.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"campo 2 esta vacio",Toast.LENGTH_SHORT).show();
                    }else {
                        hilos2();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
            case  R.id.btnStar3:
                try {
                    if (numero3.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"campo 3 esta vacio",Toast.LENGTH_SHORT).show();
                    }else {
                        hilos3();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
        }

    }
    private void UnSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void hilos1() {
        final int  num1;
        num1 = Integer.parseInt(numero1.getText().toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                //   for (i = 1; i <= num2; i++) {
                while (prog < num1){
                    prog += 1;

                    UnSegundo();

                    // progreso2.setMax(num2);

                    // Para generar un error con la UI Thread

                    handler.post(new Runnable() {

                        public void run() {
                            progreso1.setProgress(prog);

                            Toast.makeText(getBaseContext(), "Tarea1 ejecutandose", Toast.LENGTH_LONG).show();
                            progreso1.setMax(num1);
                        }




                    });
                }
            }


        }).start();


    }
    public void hilos2() {
        final int  num2;
        num2 = Integer.parseInt(numero2.getText().toString());




        new Thread(new Runnable() {
            @Override
            public void run() {
                //   for (i = 1; i <= num2; i++) {
                while (prog2 < num2){
                    prog2 += 1;

                    UnSegundo();

                    // progreso2.setMax(num2);

                    // Para generar un error con la UI Thread

                    handler.post(new Runnable() {

                        public void run() {
                            progreso2.setProgress(prog2);

                            Toast.makeText(getBaseContext(), "Tarea1 ejecutandose", Toast.LENGTH_LONG).show();
                            progreso2.setMax(num2);
                        }




                    });
                }
            }


        }).start();
    }


    public void hilos3() {
        final int  num1;
        num1 = Integer.parseInt(numero3.getText().toString());




        new Thread(new Runnable() {
            @Override
            public void run() {
                //   for (i = 1; i <= num2; i++) {
                while (prog < num1){
                    prog += 1;

                    UnSegundo();

                    // progreso2.setMax(num2);

                    // Para generar un error con la UI Thread

                    handler.post(new Runnable() {

                        public void run() {
                            progreso3.setProgress(prog);

                            Toast.makeText(getBaseContext(), "Tarea 3 ejecutandose", Toast.LENGTH_LONG).show();
                            progreso3.setMax(num1);
                        }




                    });
                }
            }


        }).start();
    }
}
