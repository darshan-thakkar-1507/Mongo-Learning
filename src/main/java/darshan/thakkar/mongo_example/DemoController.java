package darshan.thakkar.mongo_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoRepo demoRepo;
	@Autowired
	private MongoTemplate mongoTemplate;
	MongoEntityInformation<Demo, String> mongoEntityInformation;

	@GetMapping
	private List<Demo> getAllDemos() {
		return demoRepo.findAll();
	}

	@GetMapping("/query")
	private List<Demo> getAllDemoFilterByQuery(@RequestParam String query) {
		return demoRepo.findCustomByRegExAddress(query);
	}

	@PostMapping("/save")
	private Demo save(@RequestBody Demo demo) {
		return demoRepo.save(demo);
	}

	@PutMapping("/update/{id}")
	private Long update(@PathVariable String id, @RequestBody Demo demo) {
		Update update = new Update();
		update.set("quote", demo.getQuote());
		return mongoTemplate.updateMulti(Query.query(Criteria.where("_id").is(id))
				, update, "demo").getModifiedCount();
	}
}
