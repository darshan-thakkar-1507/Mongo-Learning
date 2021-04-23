package darshan.thakkar.mongo_example.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import darshan.thakkar.mongo_example.constants.Constants;
import darshan.thakkar.mongo_example.core.CoreEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = Constants.task)
public class Task extends CoreEntity {

	@Field("task_no")
	@JsonProperty("task_no")
	private Integer taskNo = 1;
	@Field("task")
	@JsonProperty("task")
	private String task;
	@Field("description")
	@JsonProperty("description")
	private String description;
	@Field("assigned")
	@JsonProperty("assigned")
	private Boolean assigned = false;
	@Field("assigned_to")
	@JsonProperty("assigned_to")
	private String assigned_to = "UNASSIGNED";
	@Field("no_of_days")
	@JsonProperty("no_of_days")
	private int noOfDays = 0;
}