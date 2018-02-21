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
public class Wind extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    @SerializedName("speed")
    @Expose
    public Float speed;

    @Column
    @SerializedName("deg")
    @Expose
    public Integer deg;

    public Wind() {
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }
}
