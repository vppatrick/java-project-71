package hexlet.code;

import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Mapper {
    public static List<DiffDTO> getDiff(Map<String, Object> firstMapOfData,
                                        Map<String, Object> secondMapOfData) {
        var setOfKeys = new HashSet<String>();
        setOfKeys.addAll(firstMapOfData.keySet());
        setOfKeys.addAll(secondMapOfData.keySet());
        List<String> sortedSetOfKeys = new ArrayList<>(setOfKeys);
        Collections.sort(sortedSetOfKeys);

        var result = new ArrayList<DiffDTO>();
        for (var key : sortedSetOfKeys) {
            var result1 = firstMapOfData.getOrDefault(key, "absent");
            var result2 = secondMapOfData.getOrDefault(key, "absent");
            if (String.valueOf(result1).equals("absent")) { // added
                var diff = new DiffDTO();
                diff.setName(key);
                diff.setState("added");
                diff.setValue(result2);
                result.add(diff);
            } else if (String.valueOf(result2).equals("absent")) { // removed
                var diff = new DiffDTO();
                diff.setName(key);
                diff.setState("removed");
                diff.setValue(result1);
                result.add(diff);
            } else if (String.valueOf(result1).equals(String.valueOf(result2))) { // no change
                var diff = new DiffDTO();
                diff.setName(key);
                diff.setState("noChange");
                diff.setValue(result1);
                result.add(diff);
            } else { // updated
                var diff = new DiffDTO();
                diff.setName(key);
                diff.setState("updated");
                diff.setOldValue(result1);
                diff.setNewValue(result2);
                result.add(diff);
            }
        }
        return result;
    }
}
