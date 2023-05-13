package kz.careerguidance.applicationapi.service.university;

import kz.careerguidance.applicationapi.entity.university.Subject;

import java.util.List;

public interface SubjectService {

    Subject get(Integer id);

    List<Subject> getAll();

    Subject create(Subject s);

    Subject update(Integer id, Subject s);

    Subject delete(Integer id);

}
