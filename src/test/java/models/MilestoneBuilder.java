package models;

import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneBuilder {
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String refs;
    private String description;
    private boolean is_completed;
}
