package b12app.vyom.com.quizpro;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by vyompatel on 3/31/18.
 */

public class Result extends Fragment {

    ListView result_list;
    TextView result_username;
    int q;


    final String[] questions = {"What is splash screen in android?",
            "How many broadcast receivers are available in android?",
            "What is the 9 patch tool in android?",
            "What is the JSON exception in android?",
            "What does httpclient.execute() returns in android?",
            "Why don't we give MIN SDK as 1 in android?",
            "Main difference between set and list in android?"};

    ArrayList<String> answer =null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        name = getArguments().getString("name");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.result_list,container,false);

        result_list = view.findViewById(R.id.list_result);
        result_username = view.findViewById(R.id.result_username);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_format,R.id.question,questions){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(R.id.question);

                    String s = getArguments().getString("key_ans");
                Log.i(TAG, "question: "+s);



                        if(s=="correct"){

                            tv.setTextColor(Color.GREEN);

                        } else if(s=="incorrect"){

                            tv.setTextColor(Color.RED);
                        }





                return view;
            }
        };

        result_list.setAdapter(arrayAdapter);






        result_username.setText(SignUpActivity.name);


        return view;
    }
}
