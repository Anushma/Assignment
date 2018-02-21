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
import in.app.assignment.models.NetworkType;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class NetworkConAdapter extends RecyclerView.Adapter<NetworkConAdapter.ViewHolder> {

    Context mContext;

    ArrayList<NetworkType> networkTypeArrayList;

    public NetworkConAdapter(Context mContext, ArrayList<NetworkType> networkTypeArrayList) {
        this.mContext = mContext;
        this.networkTypeArrayList = networkTypeArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_network_conn_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NetworkType networkType;
        networkType = networkTypeArrayList.get(position);
        if (networkType.mobileData) {
            holder.mtext.setText("Mobile Data");
        } else
            holder.mtext.setText("Wifi");


    }

    @Override
    public int getItemCount() {
        return networkTypeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_networktype)
        TextView networkType;
        @BindView(R.id.date)
        TextView mtext;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }
}
