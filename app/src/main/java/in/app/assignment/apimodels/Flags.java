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
public class Flags extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int pk;


    @Column
    @SerializedName("type")
    @Expose
    public Integer type;

    @Column
    @SerializedName("id")
    @Expose
    public Integer id;

    @Column
    @SerializedName("message")
    @Expose
    public Float message;


    @Column
    @SerializedName("country")
    @Expose
    public String country;

    @Column
    @SerializedName("sunrise")
    @Expose
    public Integer sunrise;

    @Column
    @SerializedName("sunset")
    @Expose
    public Integer sunset;

    public Flags() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }
}
