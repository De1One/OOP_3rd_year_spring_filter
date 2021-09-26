import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String guid;
    private Boolean isActive;
    private String balance;
    private Integer age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;
    private String registered;
    private List<String> tags;
    private String favoriteFruit;
}
