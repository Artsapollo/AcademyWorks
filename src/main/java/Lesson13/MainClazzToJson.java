package Lesson13;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author spasko
 */
public class MainClazzToJson {
    public static void main(String[] args) {
        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

        try {
            objectWriter.writeValue(new File("src/main/resources/MateGroup.json"), mateGroup);
            System.out.println(objectWriter.writeValueAsString(mateGroup));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}