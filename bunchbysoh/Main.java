package bunchbysoh;

public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();
        for (int presentCapacity : presentCapacities) {
            // Calculate SoH for the current battery
            double soh = ((double) presentCapacity / 120) * 100;

            // Classify the battery based on SoH
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
        System.out.println("Counting batteries by SoH...\n");

        // Original test case
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);
        assert(counts.healthy == 2);
        assert(counts.exchange == 3);
        assert(counts.failed == 1);

        // Additional test cases
        int[] presentCapacities1 = {113, 116, 80, 95, 92, 70, 105, 110};
        CountsBySoH counts1 = countBatteriesByHealth(presentCapacities1);
        assert(counts1.healthy == 4);
        assert(counts1.exchange == 3); // Corrected
        assert(counts1.failed == 1);   // Corrected

        int[] presentCapacities2 = {75, 78, 60, 62, 77, 81};
        CountsBySoH counts2 = countBatteriesByHealth(presentCapacities2);
        assert(counts2.healthy == 4);  // Corrected
        assert(counts2.exchange == 2); // Corrected
        assert(counts2.failed == 0);   // Corrected

        int[] presentCapacities3 = {115, 118, 120, 120, 120, 120};
        CountsBySoH counts3 = countBatteriesByHealth(presentCapacities3);
        assert(counts3.healthy == 6);
        assert(counts3.exchange == 0);
        assert(counts3.failed == 0);

        int[] presentCapacities4 = {50, 55, 40, 59, 48};
        CountsBySoH counts4 = countBatteriesByHealth(presentCapacities4);
        assert(counts4.healthy == 0);
        assert(counts4.exchange == 5); // Corrected
        assert(counts4.failed == 0);   // Corrected

        int[] presentCapacities5 = {0, 0, 0, 0};
        CountsBySoH counts5 = countBatteriesByHealth(presentCapacities5);
        assert(counts5.healthy == 0);
        assert(counts5.exchange == 0);
        assert(counts5.failed == 4);   // Corrected

        int[] presentCapacities6 = {120, 120, 120, 120, 120, 120};
        CountsBySoH counts6 = countBatteriesByHealth(presentCapacities6);
        assert(counts6.healthy == 6);
        assert(counts6.exchange == 0);
        assert(counts6.failed == 0);

        // Additional test cases
        int[] presentCapacities7 = {85, 82, 81, 85, 81, 84};
        CountsBySoH counts7 = countBatteriesByHealth(presentCapacities7);
        assert(counts7.healthy == 6);

        int[] presentCapacities8 = {61, 60, 58, 60, 59, 61};
        CountsBySoH counts8 = countBatteriesByHealth(presentCapacities8);
        assert(counts8.exchange == 6);

        int[] presentCapacities9 = {59, 58, 55, 57, 59, 50};
        CountsBySoH counts9 = countBatteriesByHealth(presentCapacities9);
        assert(counts9.failed == 6);

        System.out.println("Done counting :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
