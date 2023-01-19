package models;

import lombok.*;

//@Setter
//@Getter
//@AllArgsConstructor //обязательно чтобы объект имел все параметры
@NoArgsConstructor
//@RequiredArgsConstructor //конструктор на основе обязательных (NonNull) полей
//@ToString //инфа обо всех полях и их значенияхю удобно, когда используешь JavaFaker,чтоб получить значения
//@EqualsAndHashCode
@Data //заменяет Getter, Setter, equals, hashCode
public class Milestone {
    @EqualsAndHashCode.Exclude //убрать это поле из сравнения
    private int id;

    @NonNull //это параметр обязателен
    private String name;

    private String references;
    private String description;

    @ToString.Exclude //убрать из to string
    private boolean completed;


}
