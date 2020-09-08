package das.tech.studentapplication.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import das.tech.studentapplication.dao.StudentData;
import das.tech.studentapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String createStudents(@RequestBody StudentData studentInformation) {
        studentRepository.save(studentInformation);
        return studentInformation.getStudentId();
    }

}
