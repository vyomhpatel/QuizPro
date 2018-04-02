package b12app.vyom.com.quizpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vyompatel on 4/2/18.
 */

public class ResultAdapter extends BaseAdapter {

    String[] questions_result = null;
    ArrayList<String> answers_result = null;
    Context context;
    LayoutInflater layoutInflater;

    public ResultAdapter(String[] questions_result, ArrayList<String> answers_result, Context context) {
        this.questions_result = questions_result;
        this.answers_result = answers_result;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return questions_result.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.result_list,null);
        TextView question_tv = view.findViewById(R.id.question);
        TextView answer_tv = view.findViewById(R.id.answer);
        question_tv.setText(questions_result[i]);
        answer_tv.setText(answers_result.get(i));

        return view;
    }
}
