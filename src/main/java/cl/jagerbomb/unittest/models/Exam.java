package cl.jagerbomb.unittest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    private Long id;
    private String name;
    private List<String> questions;

    public Exam(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
