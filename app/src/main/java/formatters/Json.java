package formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffDTO;
import java.util.List;

public final class Json {
    private Json() {
        throw new IllegalStateException("Utility class");
    }
    public static String getFormat(List<DiffDTO> diffs) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(diffs);
    }
}
