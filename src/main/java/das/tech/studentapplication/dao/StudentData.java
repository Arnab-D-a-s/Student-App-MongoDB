package das.tech.studentapplication.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentData {
    @Id
    private String studentId;
    private String studentName;
    private String graduationYear;
    private String genderIdentity;
}
