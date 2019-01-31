package Lesson14.SOAP;

import Lesson13.MateGroup;
import Lesson13.Person;
import Lesson14.SOAP.MateGroupService;

import javax.jws.WebService;
import java.util.List;
@WebService(endpointInterface = "Lesson14.SOAP.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService {

    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    public MateGroup getMateGroup() {
        return mateGroup;
    }

    @Override
    public MateGroup addStudent(List<Person> persons) {
        mateGroup.getStudents().addAll(persons);
        return mateGroup;
    }
}
