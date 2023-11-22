package bunchbysoh;

public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH classifyBatteries(int[] capacities, int ratedCapacity) {
        CountsBySoH counts = new CountsBySoH();

        for (int capacity : capacities) {
            double soh = ((double) capacity / ratedCapacity) * 100;

            if (soh > 80) {
                counts.healthy++;
            } else if (soh >= 62) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }

        return counts;
    }

    static void testBucketingByHealth() {
        System.out.println("Classifying batteries by SoH...\n");

        // Rated capacity is 120 Ah

        // Test case 1
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = classifyBatteries(presentCapacities, 120);
        assert counts.healthy == 2;
        assert counts.exchange == 3;
        assert counts.failed == 1;

        // Test case 2
        int[] presentCapacities1 = {113, 116, 80, 95, 92, 70, 105, 110};
        counts = classifyBatteries(presentCapacities1, 120);
        assert counts.healthy == 4;
        assert counts.exchange == 2;
        assert counts.failed == 2;

        // Test case 3
        int[] presentCapacities2 = {75, 78, 60, 62, 77, 81};
        counts = classifyBatteries(presentCapacities2, 120);
        assert counts.healthy == 0;
        assert counts.exchange == 4;
        assert counts.failed == 2;

        // Additional test cases with rated capacity 180 Ah
        int[] newCapacities = {150, 140, 110, 90, 160};
        counts = classifyBatteries(newCapacities, 180);
        assert counts.healthy == 5;
        assert counts.exchange == 0;
        assert counts.failed == 0;

        System.out.println("Done classifying batteries :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
