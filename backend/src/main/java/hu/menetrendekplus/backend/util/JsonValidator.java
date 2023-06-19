package hu.menetrendekplus.backend.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

public final class JsonValidator {

    private JsonValidator() {}

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();

    public static final JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);

    public static<T> boolean validate(Object json, Class<T> clazz) throws SchemaNotFoundException, JsonProcessingException
    {
        try {
            JsonSchema schema = jsonSchemaFactory.getSchema(JsonValidator.class.getResourceAsStream(clazz.getSimpleName() + ".json"));
            return schema.validate(mapper.readTree(writer.writeValueAsString(json))).isEmpty();
        } catch (Exception e) {
            throw new SchemaNotFoundException(e);
        }
    }

    public static class SchemaNotFoundException extends RuntimeException {
        public SchemaNotFoundException(Exception e) {
            super(e);
        }
    }
}
