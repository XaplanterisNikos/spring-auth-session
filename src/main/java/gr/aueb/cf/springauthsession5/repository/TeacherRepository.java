package gr.aueb.cf.springauthsession5.repository;

import gr.aueb.cf.springauthsession5.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
