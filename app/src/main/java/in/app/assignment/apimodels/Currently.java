package in.app.assignment.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.app.assignment.database.AssignmentDB;

/**
 * Created by Papercrane on 17-02-2018.
 */
@Table(database = AssignmentDB.class)
public class Currently extends BaseModel {


    @PrimaryKey(autoincrement = true)
    public int pk;

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
    @SerializedName("precipIntensity")
    @Expose
    public Float precipIntensity;
    @Column
    @SerializedName("precipProbability")
    @Expose
    public Float precipProbability;
    @Column
    @SerializedName("precipType")
    @Expose
    public String precipType;
    @Column
    @SerializedName("temperature")
    @Expose
    public Float temperature;
    @Column
    @SerializedName("apparentTemperature")
    @Expose
    public Float apparentTemperature;
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
    @SerializedName("visibility")
    @Expose
    public Float visibility;
    @Column
    @SerializedName("ozone")
    @Expose
    public Float ozone;

    public Currently() {
    }
}
