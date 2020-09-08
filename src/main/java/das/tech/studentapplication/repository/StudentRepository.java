package das.tech.studentapplication.repository;

import das.tech.studentapplication.dao.StudentData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentData, String> {
}
