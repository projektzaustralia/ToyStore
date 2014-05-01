/*
 * class Toy
 * 
 * A representation of a Toy that is sold in a toy store.
 * 
 */
public class Toy
{
   private String code;
   private String desc;
   private double price;
   private int quantity;

   Toy()
   {
      code = "";
      desc = "";
      price = 0.00;
      quantity = 0;
   }

   public String getCode()
   {
      return code;
   }

   public void setCode(String code)
   {
      this.code = code;
   }

   public String getDesc()
   {
      return desc;
   }

   public void setDesc(String desc)
   {
      this.desc = desc;
   }

   public Double getPrice()
   {
      return price;
   }

   public void setPrice(double price)
   {
      this.price = price;
   }

   public int getQuantity()
   {
      return quantity;
   }

   public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }

   public Double sell(int units)
   {
      if (units > quantity)
         return Double.NaN;
      else
         quantity -= units;

      Double cost = units * price;
      return cost;
   }

   public void restock(int units)
   {
      quantity += units;
   }

   public String toString()
   {
      return code + ", " + desc + ", " + price + ", " + quantity;
   }
}
