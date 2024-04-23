package lt.mariusworks.work1.controllers;

import lombok.RequiredArgsConstructor;
import lt.mariusworks.work1.controllers.converters.SchoolConverter;
import lt.mariusworks.work1.dto.SchoolDTO;
import lt.mariusworks.work1.entities.School;
import lt.mariusworks.work1.entities.Student;
import lt.mariusworks.work1.services.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/schools")
@RequiredArgsConstructor
@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        return SchoolConverter.convertEntityListToDTOList(this.schoolService.getAllSchools());
    }

    @GetMapping(value = "/{id}")
    public SchoolDTO getSchoolById(@PathVariable Long id) {
//        System.out.println(id);
        return SchoolConverter.convertEntityToDTO(this.schoolService.getSchoolByIdOrThrow(id));

    }

    @GetMapping(value = "/{id}/students")
    public List<Student> getStudentsBySchoolId(@PathVariable Long id) {
        System.out.println(id);
        return this.schoolService.getSchoolByIdOrThrow(id).getStudents();
    }


    @GetMapping(value = "/{schoolId}/students/{studentId}")
    public Student getStudentBySchoolIdAndStudentId(@PathVariable Long schoolId, @PathVariable Long studentId) {
        return this.schoolService.getStudentBySchoolAndId(schoolId, studentId);
    }
}
