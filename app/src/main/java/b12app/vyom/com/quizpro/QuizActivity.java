package b12app.vyom.com.quizpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Question question = new Question();


        getFragmentManager().beginTransaction().add(R.id.frame,question,"quiz started").commit();
    }




}
