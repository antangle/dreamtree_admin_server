package com.dreamtree.api.minio;

import com.dreamtree.api.common.minio.controller.MinioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MinioController.class)
public class MinioUploadTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void testMinioFileSend() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "files",
                "testmock.jpeg",
                "image/jpeg",
                new FileInputStream("/Users/choeseoyeon/Desktop/학부모이미지.jpeg")
        );

        mockMvc.perform(
                multipart("/api/minio/upload")
                        .file(mockMultipartFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .with(csrf())
        ).andExpect(status().is2xxSuccessful());
    }
}
