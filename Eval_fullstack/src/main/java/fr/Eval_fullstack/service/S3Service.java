package fr.Eval_fullstack.service;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@Data
public class S3Service {


    @Value("${s3.buckets.livres}")
    private String bucketLivres;

    private MinioClient client;

    public S3Service(Environment env) throws Exception {
        this.client =  MinioClient.builder()
                .endpoint(env.getProperty("s3.endpoint"))
                .credentials(env.getProperty("s3.accesskey"), env.getProperty("s3.secretkey"))
                .build();
    }

    public String getCover(Integer id) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return this.client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket(this.getBucketLivres()).method(Method.GET).object("Guigz_"+id).build());
    }

    public String putCover(Integer id) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return this.client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket(this.getBucketLivres()).method(Method.PUT).object("Guigz_"+id).build());

    }

}