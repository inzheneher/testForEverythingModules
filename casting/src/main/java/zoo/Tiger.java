package zoo;

public class Tiger extends Animal {

    public Tiger(Animal animal) {
        super(animal.getType(), animal.getAge(), animal.getColor());
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "type='" + this.getType() + '\'' +
                ", age=" + this.getAge() +
                ", color='" + this.getColor() + '\'' +
                "}";
    }

}
