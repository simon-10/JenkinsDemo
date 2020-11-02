package com.jenkins.demojenkins.repository;

import com.jenkins.demojenkins.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
