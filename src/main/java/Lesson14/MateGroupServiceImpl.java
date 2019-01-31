package Lesson14;

import Lesson13.MateGroup;
import Lesson13.Person;

import javax.jws.WebService;
import java.util.List;
@WebService(endpointInterface = "Lesson14.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService{

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
