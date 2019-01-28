package Lesson13;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class MainClazzToJsonUsingMarshaller {
    public static void main(String[] args) {
        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
        try {
            File file = new File("src/main/resources/mateGroupUsingMarshaller.json");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);

            marshaller.marshal(mateGroup, file);
            marshaller.marshal(mateGroup, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}