import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
public class Config {

    @Bean
    public List<Person> openGenerated(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File("src/main/resources/generated.json"),new TypeReference<List<Person>>(){ });
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public List<String> filter(List<Person> personList){
        return Objects.requireNonNull(personList).stream()
                .filter(person -> person.getGender().equals("male"))
                .filter(person -> (person.getAge() >= 20)&&(person.getAge() <= 30))
                .map(Person::getGuid)
                .collect(Collectors.toList());
    }
}
