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
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = classifyBatteries(presentCapacities, 120);

        assert counts.healthy == 2;
        assert counts.exchange == 3;
        assert counts.failed == 1;

        // Additional test cases with rated capacity 120 Ah
        int[] presentCapacities1 = {113, 116, 80, 95, 92, 70, 105, 110};
        CountsBySoH counts1 = classifyBatteries(presentCapacities1, 120);
        assert counts1.healthy == 4;

        int[] presentCapacities2 = {75, 78, 60, 62, 77, 81};
        CountsBySoH counts2 = classifyBatteries(presentCapacities2, 120);
        assert counts2.exchange == 4;

        int[] presentCapacities3 = {115, 118, 120, 120, 120, 120};
        CountsBySoH counts3 = classifyBatteries(presentCapacities3, 120);
        assert counts3.healthy == 6;

        int[] presentCapacities4 = {50, 55, 40, 59, 48};
        CountsBySoH counts4 = classifyBatteries(presentCapacities4, 120);
        assert counts4.failed == 5;

        int[] presentCapacities5 = {};
        CountsBySoH counts5 = classifyBatteries(presentCapacities5, 120);
        assert counts5.healthy == 0;
        assert counts5.exchange == 0;
        assert counts5.failed == 0;

        // Additional test cases with rated capacity 180 Ah
        int[] newCapacities = {150, 140, 110, 90, 160};
        CountsBySoH countsNew = classifyBatteries(newCapacities, 180);
        assert countsNew.healthy == 5;
        assert countsNew.exchange == 0;
        assert countsNew.failed == 0;

        System.out.println("Done classifying batteries :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
