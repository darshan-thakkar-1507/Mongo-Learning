package darshan.thakkar.mongo_example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class Demo {
	@Id
	private String id;
	private String quote;
	private String author;

	public Demo(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}
}
