package test.backend.kuama.persistence.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("drink")
public class DrinkItem {

	@Id
	private String name;

	@Builder.Default
	private String glass = null;

	@Builder.Default
	private String instructions = null;

	@Builder.Default
	private List<String> ingredients = new ArrayList<>();

	@Builder.Default
	private String thumbnail = null;
}
