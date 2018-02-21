package in.app.assignment.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import in.app.assignment.database.AssignmentDB;

/**
 * Created by Papercrane on 17-02-2018.
 */
@Table(database = AssignmentDB.class)
public class Weather extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int pk;


    @SerializedName("latitude")
    @Expose
    @Column
    public Float latitude;
    @SerializedName("longitude")
    @Expose
    @Column
    public Float longitude;
    @SerializedName("timezone")
    @Expose
    @Column
    public String timezone;
    @SerializedName("currently")
    @Expose
    @ForeignKey
    public Currently currently;

    public Weather() {
    }

    @SerializedName("hourly")
    @Expose
    @ForeignKey
    public Hourly hourly;
    @SerializedName("daily")
    @Expose
    @ForeignKey
    public Daily daily;
    @SerializedName("flags")
    @Expose
    @ForeignKey
    public Flags flags;
    @SerializedName("offset")
    @Expose
    @Column
    public Float offset;
}
