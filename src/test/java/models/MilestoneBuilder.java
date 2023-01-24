package models;

import lombok.*;


@Builder //вместо целого класса Builder
@ToString
@EqualsAndHashCode
public class MilestoneBuilder {
    @EqualsAndHashCode.Exclude //убрать это поле из сравнения
    private int id;

    @NonNull //это параметр становится обязательным
    private String name;

    private String references;
    private String description;

    @ToString.Exclude //убрать из to string
    private boolean completed;


}
