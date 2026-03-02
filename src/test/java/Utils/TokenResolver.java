package Utils;

import java.util.Map;
import java.util.HashMap;

public class TokenResolver {

    // cache per row
    private static final ThreadLocal<Map<String, String>> rowCache =
            ThreadLocal.withInitial(HashMap::new);

    public static void clearRowCache() {
        rowCache.get().clear();
    }

    public static String resolve(String value, String columnKey) {

        if (value == null) return null;

        Map<String, String> cache = rowCache.get();

        if (value.contains("{faker.firstName}"))
            return cache.computeIfAbsent(columnKey,
                    k -> FakeDataUtils.firstName());

        if (value.contains("{faker.middleName}"))
            return cache.computeIfAbsent(columnKey,
                    k -> FakeDataUtils.middleName());

        if (value.contains("{faker.lastName}"))
            return cache.computeIfAbsent(columnKey,
                    k -> FakeDataUtils.lastName());

        if (value.contains("{faker.empId}"))
            return cache.computeIfAbsent(columnKey,
                    k -> FakeDataUtils.empId_PIM());

        if (value.contains("{faker.userName}")) {
            // differentiate based on column
            if (columnKey.equalsIgnoreCase("pimUsername"))
                return cache.computeIfAbsent(columnKey,
                        k -> FakeDataUtils.userName_PIM());

            if (columnKey.equalsIgnoreCase("adminUsername"))
                return cache.computeIfAbsent(columnKey,
                        k -> FakeDataUtils.username_Ad());

            // fallback
            return cache.computeIfAbsent(columnKey,
                    k -> FakeDataUtils.userName_PIM());
        }

        return value;
    }
}
