package utils;

import java.util.HashMap;
import java.util.Map;

public class PriorityUtil {

    private static final Map<String, Integer> PRIORITY_MAP =
            new HashMap<>();

    static {

        PRIORITY_MAP.put("LOW", 1);
        PRIORITY_MAP.put("MEDIUM", 2);
        PRIORITY_MAP.put("HIGH", 3);
        PRIORITY_MAP.put("CRITICAL", 4);
    }

    private PriorityUtil() {
    }

    public static boolean shouldExecute(
            String scenarioPriority,
            String configuredPriority) {

        int scenarioRank =
                PRIORITY_MAP.getOrDefault(
                        scenarioPriority.toUpperCase(),
                        0
                );

        int configRank =
                PRIORITY_MAP.getOrDefault(
                        configuredPriority.toUpperCase(),
                        0
                );

        return scenarioRank >= configRank;
    }
}