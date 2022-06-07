package cl.jagerbomb.unittest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    private Long id;
    private String name;
    private int totalTransfer;
}
