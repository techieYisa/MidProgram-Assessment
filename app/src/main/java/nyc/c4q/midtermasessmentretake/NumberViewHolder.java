package nyc.c4q.midtermasessmentretake;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 1/16/18.
 */

public class NumberViewHolder extends RecyclerView.ViewHolder{
    private TextView numTextView;
    private Context context;

    public NumberViewHolder(View itemView) {
        super(itemView);
        numTextView = itemView.findViewById(R.id.textview_number);
    }

    public void onBind(Number number) {
        context = itemView.getContext();
        numTextView.setText(String.valueOf(number.getNumber()));
        numTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
