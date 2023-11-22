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

        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = classifyBatteries(presentCapacities, 120);

        assert counts.healthy == 2;
        assert counts.exchange == 3;
        assert counts.failed == 1;

        System.out.println("Done classifying batteries :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
