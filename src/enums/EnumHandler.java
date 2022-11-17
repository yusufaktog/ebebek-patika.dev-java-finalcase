package enums;

import exception.EntityNotFoundException;

import java.util.Arrays;

public class EnumHandler {
    public static <T> T convertToEnumType(String value, String enumName, T[] values) {
        if (enumTypeExist(values, value)) {
            return Arrays.stream(values)
                    .filter(ram -> ram.toString().equalsIgnoreCase(value))
                    .toList().get(0);
        } else {
            throw new EntityNotFoundException("We do not have any products with this feature in our store yet. " +
                    enumName + ": " + value +
                    "\nIn this category, we only have the following options:\n" + Arrays.toString(values));
        }
    }

    public static <T> boolean enumTypeExist(T[] list, String value) {
        return Arrays.stream(list).anyMatch(o -> o.toString().equalsIgnoreCase(value));
    }
}
