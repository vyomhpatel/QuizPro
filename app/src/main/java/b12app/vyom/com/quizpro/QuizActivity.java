package b12app.vyom.com.quizpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements SendDataInterFace  {

    private static final String TAG = "tg";
    ArrayList<String> quiz_answers;
    static Result result;

    int i = 0;
    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question = new Question();
        quiz_answers = new ArrayList<>();
        getFragmentManager().beginTransaction().add(R.id.frame,question,"quiz started").commit();
       result = new Result();
    }


    @Override
    public void sendAns( String ans) {

        Log.i(TAG, "sendAns: "+ans);
       // answers.add(ans);

        quiz_answers.add(ans);
        Log.i(TAG, "Quiz: Answers: "+quiz_answers);



        Bundle b = new Bundle();

        b.putStringArrayList("answers_array",quiz_answers);

        result.setArguments(b);

        Log.i(TAG, "bundle: "+b.getStringArrayList("answers_array"));
    }
}
