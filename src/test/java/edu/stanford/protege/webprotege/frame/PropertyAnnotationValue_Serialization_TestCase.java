package edu.stanford.protege.webprotege.frame;


import edu.stanford.protege.webprotege.jackson.WebprotegeOwlApiJacksonApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static edu.stanford.protege.webprotege.frame.TestUtils.mockOWLAnnotationProperty;
import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(WebprotegeOwlApiJacksonApplication.class)
public class PropertyAnnotationValue_Serialization_TestCase {

    @Autowired
    private JacksonTester<PlainPropertyValue> tester;

    private PlainPropertyAnnotationValue propertyValue;

    @BeforeEach
    public void setUp() throws Exception {
        propertyValue = PlainPropertyAnnotationValue.get(mockOWLAnnotationProperty(),
                                                         TestUtils.mockLiteral());
    }

    @Test
    public void shouldSerializeAndDeserializePropertyValue() throws IOException {
        var json = tester.write(propertyValue);
        assertThat(json).hasJsonPathValue("property");
        assertThat(json).hasJsonPathValue("value");

    }
}
