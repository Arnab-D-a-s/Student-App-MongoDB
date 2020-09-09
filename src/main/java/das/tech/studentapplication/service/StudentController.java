package das.tech.studentapplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import das.tech.studentapplication.dao.StudentData;
import das.tech.studentapplication.model.StudentInformation;
import das.tech.studentapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@Slf4j
@RequiredArgsConstructor
public class StudentController {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true)
            .configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

    private final StudentRepository studentRepository;

    @PostMapping(path = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createStudents(@RequestBody StudentInformation studentInformation) throws JsonProcessingException {
        studentInformation = studentInformation.toBuilder().studentId(UUID.randomUUID().toString()).build();
        StudentData studentData = objectMapper.treeToValue(objectMapper.valueToTree(studentInformation),StudentData.class);
        System.out.println(studentData.getStudentId());
        studentRepository.save(studentData);
        return studentInformation.getStudentId();
    }

    @GetMapping(path = "/findStudents/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentInformation createStudents( @PathVariable String id) throws JsonProcessingException {
        Optional<StudentData> outPut = studentRepository.findById(id);
        if (outPut.isPresent()){
            StudentInformation studentData = objectMapper.treeToValue(objectMapper.valueToTree(outPut.get()),StudentInformation.class);
            return studentData;
        }
        return StudentInformation.builder().studentName("None").build();
    }

}
