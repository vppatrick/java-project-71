package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiffDTO {
    private String name;
    private String state;
    private Object value;
    private Object oldValue;
    private Object newValue;
}
