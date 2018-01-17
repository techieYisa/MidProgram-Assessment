package nyc.c4q.midtermasessmentretake;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LoopActivity extends AppCompatActivity {
    private int num;
    private TextView progressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        progressTextView = (TextView) findViewById(R.id.textview_loops);
        Intent intent = new Intent(LoopActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private class AsyncTaskInBackground extends AsyncTask<Integer, Integer, Integer>{

        private List<Integer> loops = new ArrayList<>();

        @Override
        protected void onPreExecute(){
        progressTextView.setText("Loop started");
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i = num; i < 100000; i++){
                loops.add(i);
                publishProgress(loops.size());
            }
            return loops.size();
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            progressTextView.setText("Loops completed: " +values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer){
            progressTextView.setText("Loops completed " + integer);
        }
    }
}
