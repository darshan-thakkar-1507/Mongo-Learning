package darshan.thakkar.mongo_example.task;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class TaskServiceImpl implements TaskService {

	private TaskRepo taskRepo;
	private MongoTemplate mongoOp;

	@Override
	public List<Task> getAllDocuments() {
		return taskRepo.findAll();
	}

	@Override
	public Task save(Task requestedEl) {
		return taskRepo.save(requestedEl);
	}

	@Override
	public Task update(String id, Task requestedEl) {
		taskRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Requested Object Not Exist"));
		Update update = new Update();
		update.set("task", requestedEl.getTask());
		update.set("description", requestedEl.getDescription());
		update.set("modifiedTime", LocalDateTime.now());
		System.out.println(mongoOp.updateMulti(Query.query(Criteria.where("_id").is(id)), update, "task").getModifiedCount());
		return mongoOp.findById(id, Task.class);
	}

	@Override
	public boolean deleteById(String id) {
		taskRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Requested Object Not Exist"));
		taskRepo.deleteById(id);
		return true;
	}
}