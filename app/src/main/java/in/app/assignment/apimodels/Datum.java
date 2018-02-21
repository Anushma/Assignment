package in.app.assignment.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.app.assignment.database.AssignmentDB;

/**
 * Created by Papercrane on 20-02-2018.
 */
@Table(database = AssignmentDB.class)
public class Datum extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int pk;

    public Datum() {
    }

    @Column
    @SerializedName("time")
    @Expose

    public Integer time;
    @Column
    @SerializedName("summary")
    @Expose
    public String summary;
    @Column
    @SerializedName("icon")
    @Expose
    public String icon;
    @Column
    @SerializedName("sunriseTime")
    @Expose
    public Integer sunriseTime;
    @Column
    @SerializedName("sunsetTime")
    @Expose
    public Integer sunsetTime;
    @Column
    @SerializedName("moonPhase")
    @Expose
    public Float moonPhase;
    @Column
    @SerializedName("precipIntensity")
    @Expose
    public Float precipIntensity;
    @Column
    @SerializedName("precipIntensityMax")
    @Expose
    public Float precipIntensityMax;
    @Column
    @SerializedName("precipIntensityMaxTime")
    @Expose
    public Integer precipIntensityMaxTime;
    @Column
    @SerializedName("precipProbability")
    @Expose
    public Float precipProbability;
    @Column
    @SerializedName("temperatureHigh")
    @Expose
    public Float temperatureHigh;
    @Column
    @SerializedName("temperatureHighTime")
    @Expose
    public Integer temperatureHighTime;
    @Column
    @SerializedName("temperatureLow")
    @Expose
    public Float temperatureLow;
    @Column
    @SerializedName("temperatureLowTime")
    @Expose
    public Integer temperatureLowTime;
    @Column
    @SerializedName("apparentTemperatureHigh")
    @Expose
    public Float apparentTemperatureHigh;
    @Column
    @SerializedName("apparentTemperatureHighTime")
    @Expose
    public Integer apparentTemperatureHighTime;
    @Column
    @SerializedName("apparentTemperatureLow")
    @Expose
    public Float apparentTemperatureLow;
    @Column
    @SerializedName("apparentTemperatureLowTime")
    @Expose
    public Integer apparentTemperatureLowTime;
    @Column
    @SerializedName("dewPoint")
    @Expose
    public Float dewPoint;
    @Column
    @SerializedName("humidity")
    @Expose
    public Float humidity;
    @Column
    @SerializedName("pressure")
    @Expose
    public Float pressure;
    @Column
    @SerializedName("windSpeed")
    @Expose
    public Float windSpeed;
    @Column
    @SerializedName("windGust")
    @Expose
    public Float windGust;
    @Column
    @SerializedName("windGustTime")
    @Expose
    public Integer windGustTime;
    @Column
    @SerializedName("windBearing")
    @Expose
    public Integer windBearing;
    @Column
    @SerializedName("cloudCover")
    @Expose
    public Float cloudCover;
    @Column
    @SerializedName("uvIndex")
    @Expose
    public Integer uvIndex;
    @Column
    @SerializedName("uvIndexTime")
    @Expose
    public Integer uvIndexTime;
    @Column
    @SerializedName("visibility")
    @Expose
    public Float visibility;
    @Column
    @SerializedName("ozone")
    @Expose
    public Float ozone;
    @Column
    @SerializedName("temperatureMin")
    @Expose
    public Float temperatureMin;
    @Column
    @SerializedName("temperatureMinTime")
    @Expose
    public Integer temperatureMinTime;
    @Column
    @SerializedName("temperatureMax")
    @Expose
    public Float temperatureMax;
    @Column
    @SerializedName("temperatureMaxTime")
    @Expose
    public Integer temperatureMaxTime;
    @Column
    @SerializedName("apparentTemperatureMin")
    @Expose
    public Float apparentTemperatureMin;
    @Column
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    public Integer apparentTemperatureMinTime;
    @Column
    @SerializedName("apparentTemperatureMax")
    @Expose
    public Float apparentTemperatureMax;
    @Column
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    public Integer apparentTemperatureMaxTime;
    @Column
    @SerializedName("precipType")
    @Expose
    public String precipType;

}
