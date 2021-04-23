package darshan.thakkar.mongo_example.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class CoreEntity {

	@Id
	private String id;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@CreatedDate
	private LocalDateTime createdTime;

	@JsonProperty
	@LastModifiedDate
	private LocalDateTime modifiedTime;
}