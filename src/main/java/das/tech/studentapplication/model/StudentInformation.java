package das.tech.studentapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
