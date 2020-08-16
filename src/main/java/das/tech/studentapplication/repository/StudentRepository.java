package das.tech.studentapplication.repository;

import das.tech.studentapplication.dao.StudentData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<StudentData, String> {
    Mono<StudentData> findById(String studentId);
}
