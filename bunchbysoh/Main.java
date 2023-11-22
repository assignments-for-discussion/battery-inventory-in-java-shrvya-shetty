package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };
   static CountBySOH countBatteries(int[] newcapacities)
  {
     CountsBySoH counts1 = new CountsBySoH();
    for (int newcapacity : newcapacities) {
      double soh1 = ((double) newcapacity / 180) * 100;
      if (soh > 80) {
            counts1.healthy++;
        } else if (soh >= 62) {
            counts1.exchange++;
        } else {
            counts1.failed++;
        }
    } 
    return counts1;
  }
  
  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
      
    

    
    for (int presentCapacity : presentCapacities) {
      //the SoH for each battery is calculated by dividing its present capacity by 120 and then multiplying by 100. 
      
     
        // Calculate SoH for the current battery
        double soh = ((double) presentCapacity / 120) * 100;//This provide a percentage representing the battery's SoH. 

        // Classify the battery based on SoH
       //The batteries are then classified into one of three categories: healthy, exchange, or failed, based on their SoH values.
      //by counter increment 
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
   

   int[] newcapacities={120,100,30,22,50};
   CountsBySoH counts1 = countBatteries(newcapacities);
   assert(counts.healthy == 1);
    assert(counts.exchange == 0);
    assert(counts.failed == 4);
   
   
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
    
    int[] presentCapacities2 = {75, 78, 60, 62, 77, 81};
    CountsBySoH counts2 = countBatteriesByHealth(presentCapacities2);
    assert(counts2.exchange == 4);
    
    int[] presentCapacities3 = {115, 118, 120, 120, 120, 120};
    CountsBySoH counts3 = countBatteriesByHealth(presentCapacities3);
    assert(counts3.healthy == 6);
    
    int[] presentCapacities4 = {50, 55, 40, 59, 48};
    CountsBySoH counts4 = countBatteriesByHealth(presentCapacities4);
    assert(counts4.failed == 5);
    
    int[] presentCapacities5 = {};
    CountsBySoH counts5 = countBatteriesByHealth(presentCapacities5);
    assert(counts5.healthy == 0);
    assert(counts5.exchange == 0);
    assert(counts5.failed == 0);
    
    System.out.println("Done counting :)\n");
}


  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
