package lib;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
         // Test 4: มีส่วนลด BOGO กรณี  2 จ่าย 1
         ArrayList<CartItem> promotionCodeCaseOne = new ArrayList<>();
         promotionCodeCaseOne.add(new CartItem("BOGO", "Bread", 25.0, 2)); // 25
         promotionCodeCaseOne.add(new CartItem("BOGO", "Milk", 15.0, 2));      // 15
         double total4 = ShoppingCartCalculator.calculateTotalPrice(promotionCodeCaseOne);
         if (total4 == 40.0) {
             System.out.println("PASSED: Simple cart total is correct (40.0)");
             passedCount++;
         } else {
             System.out.println("FAILED: Simple cart total expected 40.0 but got " + total4);
             failedCount++;
         }

        // Test 5: มีส่วนลด BOGO กรณี  3 จ่าย 2
        ArrayList<CartItem> promotionCodeCaseTwo = new ArrayList<>();
        promotionCodeCaseTwo.add(new CartItem("BOGO", "Bread", 25.0, 3)); // 50
        promotionCodeCaseTwo.add(new CartItem("BOGO", "Milk", 15.0, 3));      // 30
        double total5 = ShoppingCartCalculator.calculateTotalPrice(promotionCodeCaseTwo);
        if (total5 == 80.0) {
            System.out.println("PASSED: Simple cart total is correct (80.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 80.0 but got " + total5);
            failedCount++;
        }  

         // Test 5: มีส่วนลด BOGO กรณี  4 จ่าย 2
         ArrayList<CartItem> promotionCodeCaseThree = new ArrayList<>();
         promotionCodeCaseThree.add(new CartItem("BOGO", "Bread", 25.0, 4)); // 50
         promotionCodeCaseThree.add(new CartItem("BOGO", "Milk", 15.0, 4));      // 30
         double total6 = ShoppingCartCalculator.calculateTotalPrice(promotionCodeCaseThree);
         if (total6 == 80.0) {
             System.out.println("PASSED: Simple cart total is correct (80.0)");
             passedCount++;
         } else {
             System.out.println("FAILED: Simple cart total expected 80.0 but got " + total6);
             failedCount++;
         }

         // Test 5: มีส่วนลด BULK ของตั้งแต่ 6 ชิ้นขึ้นไป ลด 10%
         ArrayList<CartItem> promotionCodeBULKCaseOne = new ArrayList<>();
         promotionCodeBULKCaseOne.add(new CartItem("BULK", "Bread", 25.0, 6)); // 135
         promotionCodeBULKCaseOne.add(new CartItem("BULK", "Milk", 15.0, 6));      // 81
         double total7 = ShoppingCartCalculator.calculateTotalPrice(promotionCodeBULKCaseOne);
         if (total7 == 216.0) {
             System.out.println("PASSED: Simple cart total is correct (216.0)");
             passedCount++;
         } else {
             System.out.println("FAILED: Simple cart total expected 216.0 but got " + total7);
             failedCount++;
         }


        // Test 6: มีส่วนลด BULK แต่ของน้อยกว่า  6 
        ArrayList<CartItem> promotionCodeBULKCaseTwo = new ArrayList<>();
        promotionCodeBULKCaseTwo.add(new CartItem("BULK", "Bread", 25.0, 5)); // 125
        promotionCodeBULKCaseTwo.add(new CartItem("BULK", "Milk", 15.0, 5));      // 75
        double total8 = ShoppingCartCalculator.calculateTotalPrice(promotionCodeBULKCaseTwo);
        if (total8 == 200.0) {
            System.out.println("PASSED: Simple cart total is correct (200.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 200.0 but got " + total8);
            failedCount++;
        } 

        // Test 7: มีส่วนลด BOGO แต่่มีของแค่ 1 ชิ้น
        ArrayList<CartItem> promotionCodeCaseFour= new ArrayList<>();
        promotionCodeCaseFour.add(new CartItem("BOGO", "Bread", 25.0, 1)); // 25
        promotionCodeCaseFour.add(new CartItem("BOGO", "Milk", 15.0, 1));      // 15
        double total9 = ShoppingCartCalculator.calculateTotalPrice(promotionCodeCaseFour);
        if (total9 == 40.0) {
            System.out.println("PASSED: Simple cart total is correct (40.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 40.0 but got " + total9);
            failedCount++;
        }

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}