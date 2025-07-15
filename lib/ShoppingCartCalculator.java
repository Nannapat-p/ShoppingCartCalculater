package lib;
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * ฟังก์ชั่นนี้จะทำการคำนวณราคาสินค้าแล้วก็จะสามารถเช็คได้ว่าใส่ code ส่วนลดไหมจะส่งค่ากลับเป็นราคาสินค้ารวม
     * <p>เงื่อนไขการทำงาน<p>
     * <ul>
     *      <li>ถ้ารายการสินค้าที่เข้ามาเป็น null หรือ Empty จะ return ค่าออกเป็น 0.0</li>
     *      <li>ถ้าสั่งซื้อสินค้าแล้วใส่ Code   
     *          <ul>
     *              <li>ถ้าใส่ Code : BOGO : ซื้อ 1 แถม 1</li>
     *              <li>ถ้าใส่ Code : BULK : หากจำนวนสินค้า &ge; 6 ชิ้น จะได้รับส่วนลด 10%</li>
     *          </ul>
     *      </li>
     * </ul>
     * 
     * 
     * 
     * @param การรับค่าเข้ามาจะเป็น Array List เก็บไว้ใน items
     * @return จะ return double ที่เป็นราคาสินค้า
     *
     */


    public static double calculateTotalPrice(ArrayList<CartItem> items) {
       
    double sum =0;
       
        if (items == null || items.isEmpty()) {
            return 0.0;
        }
       for (CartItem cartItem : items) {
       
            if (cartItem.sku() == "BOGO" && cartItem.quantity() >= 2) {

               sum += cartItem.price() * Math.round(cartItem.quantity() / 2.0);

            }else if (cartItem.sku() == "BULK" && cartItem.quantity() >= 6 ) {
                sum +=  (cartItem.price() * cartItem.quantity() ) -  (cartItem.price() * cartItem.quantity()) /  (100 /10 ) ;
            }else{
                sum += cartItem.price() * cartItem.quantity();
          
            }
           
           
       }
       
        
        return sum;
    }
}
