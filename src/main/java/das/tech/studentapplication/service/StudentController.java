package das.tech.studentapplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import das.tech.studentapplication.model.StudentInformation;
import das.tech.studentapplication.dao.StudentData;
import das.tech.studentapplication.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
    public Mono<String> createStudents(@RequestBody StudentInformation studentInformation) {
        studentInformation.toBuilder().studentId(UUID.randomUUID().toString()).build();
        try {
            StudentData studentDataToSave = objectMapper.treeToValue(objectMapper.valueToTree(studentInformation), StudentData.class);
            studentRepository.save(studentDataToSave)
            .doOnSuccess(s -> log.info("Data Saved"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Mono.just(studentInformation.getStudentId());
    }

}
