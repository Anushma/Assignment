package in.app.assignment.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.app.assignment.R;
import in.app.assignment.ui.weather.WeatherActivity;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class HistoryListActivity extends Activity {


    @BindView(R.id.cardView2)
    CardView mCardView2;
    @BindView(R.id.cardView3)
    CardView mCardView3;
    @BindView(R.id.cardView4)
    CardView mCardView4;
    @BindView(R.id.cardView5)
    CardView mCardView5;
    @BindView(R.id.cardView6)
    CardView mCardView6;

    public static void start(Context context) {
        Intent starter = new Intent(context, HistoryListActivity.class);
        context.startActivity(starter);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.cardView2)
    public void firstClicked(){
        BatteryStatusActivity.start(this);

    }
    @OnClick(R.id.cardView3)
    public void secondClicked(){
        MemoryActivity.start(this);

    }
    @OnClick(R.id.cardView4)
    public void thirdClikced(){
        WeatherActivity.start(this);

    }
    @OnClick(R.id.cardView5)
    public void fourthClicked(){
        DeviceInfoActivity.start(this);

    }
    @OnClick(R.id.cardView6)
    public void fifthClicked(){
        NetworkConActivity.start(this);

    }

}
