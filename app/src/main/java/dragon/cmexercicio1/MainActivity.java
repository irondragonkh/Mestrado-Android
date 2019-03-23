package dragon.cmexercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //logt gera esta private string
    private static final String TAG = "MainActivity";
    private Button button;
    //abc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private volatile boolean stop;

    public void Stop(View view) {
        stop = true;
    }

    public void Start(View view) {
        Tarefadispendiosa tarefadispendiosa = new Tarefadispendiosa(14);
      Thread thread= new Thread(tarefadispendiosa);
      thread.start();
      stop = false;
    }

    private class Tarefadispendiosa  implements Runnable{

        private int segundos;

        public Tarefadispendiosa(int segundos) {
            this.segundos = segundos;
        }

        @Override
        public void run() {
            for(int i =0; i<segundos; i++){
if(stop) return;;
                Log.d(TAG, "Start: " + i);





                try {
                    button.setText("A trabalhar...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
