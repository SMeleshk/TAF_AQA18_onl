package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@Data
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;

    @SerializedName(value = "refs")
    private String references;

    private String description;

    @ToString.Exclude //убрать из to string
    @SerializedName(value = "is_completed")
    private boolean completed;


}
