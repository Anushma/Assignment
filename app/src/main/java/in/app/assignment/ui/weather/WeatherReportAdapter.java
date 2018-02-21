package in.app.assignment.ui.weather;

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
import in.app.assignment.apimodels.Currently;
import in.app.assignment.apimodels.Weather;
import in.app.assignment.models.Battery;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class WeatherReportAdapter extends RecyclerView.Adapter<WeatherReportAdapter.ViewHolder> {


    Context context;
    ArrayList<Currently> weatherArrayList;

    public WeatherReportAdapter(Context context, ArrayList<Currently> weatherArrayList) {
        this.context = context;
        this.weatherArrayList = weatherArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_weather_report_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Currently battery = weatherArrayList.get(position);
        holder.text.setText(battery.summary);
        holder.textView.setText(String.valueOf(battery.temperature));
    }

    @Override
    public int getItemCount() {
        return weatherArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.temparature)
        TextView textView;
        @BindView(R.id.description)
        TextView text;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }
}
