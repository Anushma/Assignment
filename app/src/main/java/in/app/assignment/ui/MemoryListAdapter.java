package in.app.assignment.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.app.assignment.R;
import in.app.assignment.models.Memory;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class MemoryListAdapter extends RecyclerView.Adapter<MemoryListAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Memory> memoryArrayList;

    public MemoryListAdapter(Context context, ArrayList<Memory> memoryList) {

        this.mContext = context;
        this.memoryArrayList = memoryList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_memory_details_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Memory memory;
        memory= memoryArrayList.get(position);
        holder.txtExternal.setText(String.valueOf(memory.externalMemory));
        holder.txtInternal.setText(String.valueOf(memory.internalMemory));

    }

    @Override
    public int getItemCount() {
        return memoryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_external)
        TextView txtExternal;
        @BindView(R.id.txt_internal)
        TextView txtInternal;

        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }
}
