package effectivejava.chapter2.item2.javabeans;

// JavaBeans Pattern - allows inconsistency, mandates mutability  (pages 11-12)

/**
 * JavaBeans 模式
 * 这种模式克服了 重叠构造器模式 的弊端，但是无法保证对类中每一个必需的 域 能设置上值，这完全需要手动操作。
 * 而且因为对 域 赋值和构造不是一起发生的，无法保证构造出来对象状态的一致性。
 */
public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize  = -1; // Required; no default value
    private int servings     = -1; // Required; no default value
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    public NutritionFacts() { }
    // Setters
    public void setServingSize(int val)  { servingSize = val; }
    public void setServings(int val)     { servings = val; }
    public void setCalories(int val)     { calories = val; }
    public void setFat(int val)          { fat = val; }
    public void setSodium(int val)       { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}