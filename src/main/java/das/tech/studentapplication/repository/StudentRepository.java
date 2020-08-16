package das.tech.studentapplication.repository;

import das.tech.studentapplication.dao.StudentData;
import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<StudentData, String> {
    Flux<StudentData> findAllById(String studentId);
}
