package Lesson13;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class MainJsonToClazzUsingMarshaller {
    public static void main(String[] args) {
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
            StreamSource json = new StreamSource("src/main/resources/MateGroupUsingMarshaller.json");
            MateGroup mateGroup = jaxbUnmarshaller.unmarshal(json, MateGroup.class).getValue();

            System.out.println(mateGroup);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}