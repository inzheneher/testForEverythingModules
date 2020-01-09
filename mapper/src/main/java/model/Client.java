package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {

    private String name;
    private int age;
    private String[] addresses;
    private List<String> folks;
}
