package darshan.thakkar.mongo_example.task;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
public class TaskController {

	private TaskService taskService;

	@GetMapping("/task")
	private ResponseEntity getAllTasks() {
		return ResponseEntity.ok().body(taskService.getAllDocuments());
	}

	@PostMapping("/task/save")
	private ResponseEntity save(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.save(task));
	}

	@PutMapping("/task/update/{id}")
	private ResponseEntity update(@PathVariable String id, @RequestBody Task task) {
		return ResponseEntity.ok(taskService.update(id, task));
	}

	@DeleteMapping("/task/delete/{id}")
	private ResponseEntity delete(@PathVariable String id) {
		return ResponseEntity.ok(taskService.deleteById(id));
	}

}
