package uk.gov.hmcts.reform.bulkscan.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import uk.gov.hmcts.reform.bulkscan.Application;
import uk.gov.hmcts.reform.bulkscan.model.BulkScanTransformationRequest;
import uk.gov.hmcts.reform.bulkscan.model.BulkScanValidationRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.gov.hmcts.reform.bulkscan.model.FormType.C100;
import static uk.gov.hmcts.reform.bulkscan.model.FormType.FL401;
import static uk.gov.hmcts.reform.bulkscan.model.FormType.FL403;
import static uk.gov.hmcts.reform.bulkscan.utils.Constants.CASE_TYPE_TRANSFORM_ENDPOINT;
import static uk.gov.hmcts.reform.bulkscan.utils.Constants.FL401_CASE_TYPE_VALIDATE_ENDPOINT;
import static uk.gov.hmcts.reform.bulkscan.utils.Constants.FL403_CASE_TYPE_VALIDATE_ENDPOINT;
import static uk.gov.hmcts.reform.bulkscan.utils.Constants.SERVICE_AUTHORIZATION;
import static uk.gov.hmcts.reform.bulkscan.utils.Constants.SERVICE_AUTHORIZATION_VALUE;

@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
class BulkScanEndpointIntegrationTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private transient MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    @DisplayName("should test validate request case type FL401")
    @Test
    void shouldTestCaseTypeFL401() throws Exception {
        mockMvc.perform(post(FL401_CASE_TYPE_VALIDATE_ENDPOINT)
                        .contentType(APPLICATION_JSON)
                        .header(SERVICE_AUTHORIZATION, SERVICE_AUTHORIZATION_VALUE)
                        .content(OBJECT_MAPPER.writeValueAsString(
                                BulkScanValidationRequest.builder()
                                        .ocrdatafields(null)
                                        .build())))
                .andExpect(status().isOk()).andReturn();
    }

    @DisplayName("should test validate request case type FL403")
    @Test
    void shouldTestCaseTypeFL403() throws Exception {
        mockMvc.perform(post(FL403_CASE_TYPE_VALIDATE_ENDPOINT)
                        .contentType(APPLICATION_JSON)
                        .header(SERVICE_AUTHORIZATION, SERVICE_AUTHORIZATION_VALUE)
                        .content(OBJECT_MAPPER.writeValueAsString(
                                BulkScanValidationRequest.builder()
                                        .ocrdatafields(null)
                                        .build())))
                .andExpect(status().isOk()).andReturn();
    }

    @DisplayName("should test transform request case type C100")
    @Test
    void shouldTestTransformRequestCaseTypeC100() throws Exception {
        mockMvc.perform(post(CASE_TYPE_TRANSFORM_ENDPOINT)
                        .contentType(APPLICATION_JSON)
                        .header(SERVICE_AUTHORIZATION, SERVICE_AUTHORIZATION_VALUE)
                        .content(OBJECT_MAPPER.writeValueAsString(
                                BulkScanTransformationRequest.builder()
                                        .caseTypeId(C100.name())
                                        .ocrdatafields(null)
                                        .build())))
                .andExpect(status().isOk()).andReturn();
    }

    @DisplayName("should test transform request case type FL401")
    @Test
    void shouldTestTransformRequestCaseTypeFL401() throws Exception {
        mockMvc.perform(post(CASE_TYPE_TRANSFORM_ENDPOINT)
                        .contentType(APPLICATION_JSON)
                        .header(SERVICE_AUTHORIZATION, SERVICE_AUTHORIZATION_VALUE)
                        .content(OBJECT_MAPPER.writeValueAsString(
                                BulkScanTransformationRequest.builder()
                                        .caseTypeId(FL401.name())
                                        .ocrdatafields(null)
                                        .build())))
                .andExpect(status().isOk()).andReturn();
    }

    @DisplayName("should test transform request case type FL403")
    @Test
    void shouldTestTransformRequestCaseTypeFL403() throws Exception {
        mockMvc.perform(post(CASE_TYPE_TRANSFORM_ENDPOINT)
                        .contentType(APPLICATION_JSON)
                        .header(SERVICE_AUTHORIZATION, SERVICE_AUTHORIZATION_VALUE)
                        .content(OBJECT_MAPPER.writeValueAsString(
                                BulkScanTransformationRequest.builder()
                                        .caseTypeId(FL403.name())
                                        .ocrdatafields(null)
                                        .build())))
                .andExpect(status().isOk()).andReturn();
    }
}
