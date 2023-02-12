package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Case {

    @EqualsAndHashCode.Exclude
    private int id;

    @Expose
    @NonNull
    private String title;

    @Expose
    private String estimate;

    @Expose
    private int priority_id;
    @Expose
    private int section_id;

    @EqualsAndHashCode.Exclude
    private int suite_id;


}
