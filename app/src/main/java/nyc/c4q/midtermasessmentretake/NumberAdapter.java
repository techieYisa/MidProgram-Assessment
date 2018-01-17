package nyc.c4q.midtermasessmentretake;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.midtermasessmentretake.model.Numbers;

/**
 * Created by c4q on 1/16/18.
 */

class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    private List<Numbers> numberlist;
    public NumberAdapter(List<Numbers> numberlist){
        this.numberlist = numberlist;
    }
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_itemview, parent, false);

        return new NumberViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final NumberViewHolder holder, int position) {
        Numbers numbers = numberlist.get(position);
        holder.onBind(numbers);


    }

    @Override
    public int getItemCount() {
        return numberlist.size();
    }
}

