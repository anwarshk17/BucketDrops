package ceberus.anwar.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ceberus.anwar.bucketdrops.R;
import ceberus.anwar.bucketdrops.beans.Drop;
import io.realm.RealmResults;

/**
 * Created by anwar on 3/8/2016.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {

    private LayoutInflater mInflater;
    private RealmResults<Drop> mResults;

    public AdapterDrops(Context context,RealmResults<Drop> results) {
        mInflater = LayoutInflater.from(context);
        update(results);
    }

    public void update(RealmResults<Drop> results) {
        mResults = results;
        notifyDataSetChanged();
    }

    public static ArrayList<String> generateValues() {
        ArrayList<String> dummyvalues = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            dummyvalues.add("Item "+i);
        }
        return dummyvalues;
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_drop, parent, false);
        DropHolder dropHolder = new DropHolder(view);
        return dropHolder;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
        Drop drop = mResults.get(position);
        holder.mWhat.setText(drop.getWhat());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        TextView mWhat;

        public DropHolder(View itemView) {
            super(itemView);
            mWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }
}
