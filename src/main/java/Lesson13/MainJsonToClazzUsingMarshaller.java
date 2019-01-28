package Lesson13;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class MainJsonToClazzUsingMarshaller {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
            StreamSource json = new StreamSource("src/main/resources/mateGroupUsingMarshaller.json");
            MateGroup mateGroup = unmarshaller.unmarshal(json, MateGroup.class).getValue();

            System.out.println(mateGroup);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}