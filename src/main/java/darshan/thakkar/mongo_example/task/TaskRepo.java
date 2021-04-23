package darshan.thakkar.mongo_example.task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepo extends MongoRepository<Task, String> {}
