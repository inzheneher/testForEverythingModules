package zoo;

public class Animal {
    private String type;
    private Integer age;
    private String color;

    public Animal() {
    }

    public Animal(String type, Integer age, String color) {
        this.type = type;
        this.age = age;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "zoo.Animal{" +
                "type='" + type + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

