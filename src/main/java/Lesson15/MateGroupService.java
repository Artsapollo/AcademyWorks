package Lesson15;

import Lesson13.HumanResource;
import Lesson13.Person;

import javax.ws.rs.core.Response;


/**
 * @author spasko
 */

public interface MateGroupService {

    Response getMateGroup(int groupId);

    Response addStudents(int groupId, Person person);

    Response removeStudent(int groupId, String surname);

    Response addNameStudent(int groupId, String surname, String name);


    Response addHr(int groupId, HumanResource humanResource);

    Response removeHr(int groupId, String surname);

    Response changeYearOfStart(int groupId, String surname, int startWorkYear); //Конкретного HR

    Response getAllHrInfo(int groupId);

    Response getOneHrInfo(int groupId, String surname);

}
/*
Працюємо з ейчарами в моїй моделі, а саме:
1. Додати нового айч-ар DONE
2. Видалити айч-ар зі списку
3. Змінити рік початку роботи конкретного айч-ар, через квері-парам
4. Видати інформацію про всіх айчарів
5. Видати інформацію про конкретного айч-ара
 */