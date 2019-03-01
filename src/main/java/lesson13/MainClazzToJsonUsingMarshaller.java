package lesson13;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class MainClazzToJsonUsingMarshaller {
    public static void main(String[] args) {
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
        try {
            File file = new File("src/main/resources/MateGroupUsingMarshaller.json");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);

            jaxbMarshaller.marshal(mateGroup, file);
            jaxbMarshaller.marshal(mateGroup, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}