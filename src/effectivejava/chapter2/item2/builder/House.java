package effectivejava.chapter2.item2.builder;

/**
 * @author CaoY
 * @date 2023-08-05 18:05
 * @description 房子类 - 使用建造者模式编写
 * 其中的 域 主要指相应物件的数量
 */
public class House {
    // 必需的东西
    private int doors;// 门
    private int windows;// 窗户
    private int beds;// 床
    private int toilet;// 马桶
    private int desks;// 桌子
    private int chairs;// 椅子

    // 可选的东西
    private int televisions;// 电视机
    private int computer;// 个人计算机
    private int washingMachine;// 洗衣机

    public static class Builder {
        // 必需的东西
        private int doors;// 门
        private int windows;// 窗户
        private int beds;// 床
        private int toilet;// 马桶
        private int desks;// 桌子
        private int chairs;// 椅子

        // 可选的东西
        private int televisions;// 电视机
        private int computers;// 个人计算机
        private int washingMachines;// 洗衣机

        public Builder(int doors, int windows, int beds, int toilet, int desks, int chairs) {
            this.doors = doors;
            this.windows = windows;
            this.beds = beds;
            this.toilet = toilet;
            this.desks = desks;
            this.chairs = chairs;
        }

        // 可以在 Builder 中添加对属性值有效性的校验
        private boolean isValid(int val) {
            if (val < 0) {
                throw new RuntimeException("传入的值不能小于0");
            }
            return true;
        }

        public Builder televisions(int televisions) {
            isValid(televisions);
            this.televisions = televisions;
            return this;
        }

        public Builder computers(int computers) {
            isValid(computers);
            this.computers = computers;
            return this;
        }

        public Builder washingMachines(int washingMachines) {
            isValid(washingMachines);
            this.washingMachines = washingMachines;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    private House(Builder builder) {
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.beds = builder.beds;
        this.toilet = builder.toilet;
        this.desks = builder.desks;
        this.chairs = builder.chairs;
        this.televisions = builder.televisions;
        this.computer = builder.computers;
        this.washingMachine = builder.washingMachines;
    }

    @Override
    public String toString() {
        return "House{" +
                "doors=" + doors +
                ", windows=" + windows +
                ", beds=" + beds +
                ", toilet=" + toilet +
                ", desks=" + desks +
                ", chairs=" + chairs +
                ", televisions=" + televisions +
                ", computer=" + computer +
                ", washingMachine=" + washingMachine +
                '}';
    }

    public static void main(String[] args) {
        House house = new House.Builder(1, 5, 1, 1, 1, 4)
                .computers(1)
                .televisions(1)
                .build();
        System.out.println(house);
    }
}
