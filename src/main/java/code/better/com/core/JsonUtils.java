package code.better.com.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtils {
	static ObjectMapper mapper = new ObjectMapper();

	public static ArrayNode createArrayNode() {
		return mapper.createArrayNode();
	}

	public static ObjectNode createObjectNode() {
		return mapper.createObjectNode();
	}

	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
