package effectivejava.chapter9.item60;

public class Change {
    // Broken - uses floating point for monetary calculation!
    // 使用 float 和 double 用于货币计算会有因不精确而导致的错误
    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }
}
