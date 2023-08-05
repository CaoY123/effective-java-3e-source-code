package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

// Subclass with hierarchical builder (Page 15)
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() { return this; }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return size + " New York Pizza with " + toppings;
    }

    public static void main(String[] args) {
        Pizza pizza = new NyPizza.Builder(Size.LARGE)
                .self()
                .addTopping(Topping.ONION)
                .addTopping(Topping.SAUSAGE)
                .addTopping(Topping.PEPPER)
                .build();
        System.out.println("做出的披萨为：" + pizza);
    }
}
