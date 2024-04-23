package lt.mariusworks.work1.services;

import lombok.RequiredArgsConstructor;
import lt.mariusworks.work1.entities.School;
import lt.mariusworks.work1.entities.Student;
import lt.mariusworks.work1.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;


    public List<School> getAllSchools() {
        return this.schoolRepository.findAll();
    }

    public School getSchoolByIdOrThrow(Long id) {
        return this.schoolRepository.findById(id).orElseThrow();
    }


    public Student getStudentBySchoolAndId(Long schoolId, Long studentId) {
        for (Student student : this.getSchoolByIdOrThrow(schoolId).getStudents()) {
            if (Objects.equals(student.getId(), studentId)) {
                return student;
            }
        }
        return null;
    }

}
