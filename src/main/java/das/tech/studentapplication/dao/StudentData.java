package das.tech.studentapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentData {
    @Id
    private String studentId;
    private String studentName;
    private String graduationYear;
    private String genderIdentity;
}
