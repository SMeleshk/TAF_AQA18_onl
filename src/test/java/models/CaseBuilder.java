package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseBuilder {
    @EqualsAndHashCode.Exclude
    private int id;
    private String title;
    private String estimate;
    private int priority_id;

    @EqualsAndHashCode.Exclude
    private int section_id;

    private int suite_id;
}
