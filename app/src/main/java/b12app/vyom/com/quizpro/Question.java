package b12app.vyom.com.quizpro;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by vyompatel on 3/30/18.
 */

public class Question extends Fragment {

    TextView question;
    RadioGroup radioGroup;
    RadioButton r1,r2, r3, r4, selected;
    Button btnNext;
    int q = 1,id;
    String radio;
    Bundle bundle;
    SendDataInterFace sendDataInterface;
    String question_q;
    ArrayList<String> answers_ques;





    public void resetRadioButton(){
        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question,container,false);


        question  = view.findViewById(R.id.tv_question);

        radioGroup = view.findViewById(R.id.radio_group_1);
        r1 = view.findViewById(R.id.radioButton);
        r2 = view.findViewById(R.id.radioButton2);
        r3 = view.findViewById(R.id.radioButton3);
        r4 =view.findViewById(R.id.radioButton4);

        btnNext = view.findViewById(R.id.btnNext);

        final String[] questions = {"What is splash screen in android?",
                "How many broadcast receivers are available in android?",
                "What is the 9 patch tool in android?",
                "What is the JSON exception in android?",
                "What does httpclient.execute() returns in android?",
                "Why don't we give MIN SDK as 1 in android?",
                "Main difference between set and list in android?"};

        final String[][] options = new String[7][5];

        options [0][0] = "Initial activity of an application";
        options [0][1] = "Initial service of an application";
        options [0][2] = "Initial method of an application";
        options [0][3] = "Initial screen of an application";
        options[0][4] = "Initial screen of an application";
        options [1][0] = "1";
        options [1][1] = "2";
        options [1][2] = "0";
        options [1][3] = "4";
        options[1][4] = "4";

        options[2][0] = "Using with tool, we can redraw images in 9 sections";
        options[2][1] = "image extension tool";
        options[2][2] = "image editable tool";
        options[2][3] = "Device features";
        options[2][4] = "Using with tool, we can redraw images in 9 sections";

        options[3][0]="JSon Exception";
        options[3][1]="Json Not found exception";
        options[3][2]="Input not found exception";
        options[3][3]="None of the above";
        options[3][4]="JSon Exception";

        options[4][0]="Http entity";
        options[4][1]="Http response";
        options[4][2]="Http result";
        options[4][3]="None of the above";
        options[4][4]="Http response";

        options[5][0]="Android deprecated version";
        options[5][1]="There is no value for 1";
        options[5][2]="Doesn't allow min version 1";
        options[5][3]="None of the above";
        options[5][4]="Android deprecated version";

        options[6][0]="Both are same";
        options[6][1]="Set can't contain duplicate values";
        options[6][2]="List may contain duplicate values";
        options[6][3]="B & C";
        options[6][4]="B & C";

//        options[7][0]="";
//        options[7][1]="";
//        options[7][2]="";
//        options[7][3]="";
//        options[7][4]="";
//
//        options[8][0]="";
//        options[8][1]="";
//        options[8][2]="";
//        options[8][3]="";
//        options[8][4]="";
//
//        options[9][0]="";
//        options[9][1]="";
//        options[9][2]="";
//        options[9][3]="";
//        options[9][4]="";

        question.setText(questions[0]);
        r1.setText(options[0][0]);
        r2.setText(options[0][1]);
        r3.setText(options[0][2]);
        r4.setText(options[0][3]);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                  if(r1.isChecked()){
                      Log.i(TAG, "r1 checked");
                      radio = r1.getText().toString();

                  } else if(r2.isChecked()){
                      Log.i(TAG, "r2 checked");
                      radio = r2.getText().toString();
                  } else if(r3.isChecked()) {
                      Log.i(TAG, "r3 checked");
                      radio = r3.getText().toString();
                  } else {
                      Log.i(TAG, "r4 checked");
                      radio = r4.getText().toString();
                  }








                if( radio == options[q-1][4]){
                    Log.i(TAG, " answer is correct "+" correct answer is "+options[q-1][4]);

//                    question_q = questions[q-1];
                   sendDataInterface.sendAns("correct");



                } else {
                    Log.i(TAG, "answer is incorrect"+"correct answer is"+options[q-1][4]+"  your answer is "+radio);

                    sendDataInterface.sendAns("incorrect");


                }


                question.setText(questions[q]);
                r1.setText(options[q][0]);
                r2.setText(options[q][1]);
                r3.setText(options[q][2]);
                r4.setText(options[q][3]);


                   if (q < questions.length - 1) {

                       resetRadioButton();
                       q++;
                       Log.i(TAG, "question: " + q);

                   } else if (q == questions.length-1) {
                       btnNext.setText("Finish");



                       getFragmentManager().beginTransaction().replace(R.id.frame, QuizActivity.result).commit();
                   }


               }
           });



        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        sendDataInterface = (SendDataInterFace) getActivity();
    }
}
