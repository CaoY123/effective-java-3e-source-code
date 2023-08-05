package effectivejava.chapter2.item2.hierarchicalbuilder;

// Subclass with hierarchical builder (Page 15)

/**
 * 子类方法声明返回父类中声明的返回类型的子类型（主要指 build()，这称作协变返回类型）
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override public Calzone build() {
            return new Calzone(this);
        }

        @Override protected Builder self() { return this; }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override public String toString() {
        return String.format("Calzone with %s and sauce on the %s",
                toppings, sauceInside ? "inside" : "outside");
    }

    public static void main(String[] args) {
        Pizza pizza = new Calzone.Builder()
                .sauceInside()
                .addTopping(Topping.HAM)
                .build();
        System.out.println(pizza);
    }
}
