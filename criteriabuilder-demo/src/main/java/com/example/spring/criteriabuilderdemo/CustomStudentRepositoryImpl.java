package com.example.spring.criteriabuilderdemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> listAllStudents(Student student) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        if (student != null) {
            List<Predicate> predicates = new ArrayList<Predicate>();

            if (student.getName() != null && !student.getName().isEmpty())
                predicates.add(criteriaBuilder.like(root.get("name"), student.getName() + "%"));

            if (student.getStd() > 0)
                predicates.add(criteriaBuilder.equal(root.get("std"), student.getStd()));

            criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
