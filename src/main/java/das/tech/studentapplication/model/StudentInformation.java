package das.tech.studentapplication.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class StudentInformation {
    private String studentId;
    private String studentName;
    private String graduationYear;
    private Gender genderIdentity;

    enum Gender {
        MALE, FEMALE, TRANS;
    }

}
