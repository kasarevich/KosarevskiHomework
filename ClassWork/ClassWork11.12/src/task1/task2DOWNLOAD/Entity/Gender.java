package task1.task2DOWNLOAD.Entity;

import com.google.gson.annotations.SerializedName;

public enum Gender { // для случаев, когда в jsone будет 0/1  - Муж/Жен
    @SerializedName("0")
    M,
    @SerializedName("1")
    W
}
