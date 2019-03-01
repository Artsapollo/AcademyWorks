package lesson14.SOAP;

import lesson13.MateGroup;
import lesson13.Person;
import lesson13.Teacher;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "lesson14.SOAP.MateGroupService")
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

    @Override
    public MateGroup changeTeacher(Teacher teacher) {
        if (teacher != null) {
            mateGroup.setTeacher(teacher);
        }
        return mateGroup;
    }
}
