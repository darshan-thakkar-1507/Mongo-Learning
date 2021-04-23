package darshan.thakkar.mongo_example.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import darshan.thakkar.mongo_example.constants.Constants;
import darshan.thakkar.mongo_example.core.CoreEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = Constants.task)
public class Task extends CoreEntity {
	@Field("task")
	@JsonProperty("task")
	private String task;
	@Field("description")
	@JsonProperty("description")
	private String description;
}