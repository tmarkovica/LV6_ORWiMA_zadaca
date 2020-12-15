package hr.ferit.orwma_lv6_tm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NameViewHolder> {

    private static final String TAG = "CustomAdapter";
    private List<String> dataList;
    private NameClickListener nameClickListener;

    public CustomAdapter(List<String> dataList, NameClickListener nameClickListener) {
        this.dataList = dataList;
        this.nameClickListener = nameClickListener;

    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);

        return new NameViewHolder(listItemView, nameClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + "set");
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void removeName(int position) {
        if(dataList.size() > position) {
            dataList.remove(position);
            notifyDataSetChanged();
        }
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView textView;
        private NameClickListener nameClickListener;

        public NameViewHolder(@NonNull View itemView, NameClickListener nameClickListener) {
            super(itemView);

            textView = itemView.findViewById(R.id.nameTextView);
            this.nameClickListener = nameClickListener;
            itemView.setOnClickListener(this);

            //textView.setOnClickListener(); // na text dok se klikne
        }

        public void setName(String name) {
            textView.setText(name);
        }

        @Override
        public void onClick(View v) {
            nameClickListener.onNameClick(getAdapterPosition());
        }
    }
}
