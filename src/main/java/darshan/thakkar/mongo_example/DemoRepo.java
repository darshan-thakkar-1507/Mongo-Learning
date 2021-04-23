package darshan.thakkar.mongo_example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DemoRepo extends MongoRepository<Demo,String> {

	@Query("{quote:'?0'}")
	List<Demo> findCustomByQuote(String quote);


	@Query("{quote : { $regex: ?0 } }")
	List<Demo> findCustomByRegExAddress(String domain);
}
