package darshan.thakkar.mongo_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {DemoRepo.class})
@EnableMongoAuditing
public class MongoExampleApplication implements CommandLineRunner {

	@Autowired
	private DemoRepo demoRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		addData();
		listAll();
	}

	private void addData() {
		Demo demo1 = new Demo("DARSHAN", "DARSHAN");
		demoRepo.save(demo1);
		Demo demo2 = new Demo("SAVAN", "SAVAN");
		demoRepo.save(demo2);
	}

	public void listAll() {
//		demoRepo.findAll().forEach(System.out::println);
		demoRepo.findCustomByQuote("DARSHAN").forEach(System.out::println);
	}

}
