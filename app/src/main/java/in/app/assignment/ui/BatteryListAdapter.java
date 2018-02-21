package in.app.assignment.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.app.assignment.R;
import in.app.assignment.models.Battery;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class BatteryListAdapter extends RecyclerView.Adapter<BatteryListAdapter.ViewHolder> {


    ArrayList<Battery> batteryList;

    Context mContext;


    public BatteryListAdapter(Context context, ArrayList<Battery> mBatteryList) {

        mContext = context;
        batteryList = mBatteryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_battery_status_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Battery battery;
        battery = batteryList.get(position);

        holder.mtext.setText(String.valueOf(battery.batteryLevel));


    }

    @Override
    public int getItemCount() {
        return batteryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_batteryLevel)
        TextView mBatteryLevel;
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
