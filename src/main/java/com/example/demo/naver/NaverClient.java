package com.example.demo.naver;

import com.example.demo.naver.dto.SearchImageReq;
import com.example.demo.naver.dto.SearchImageRes;
import com.example.demo.naver.dto.SearchLocalReq;
import com.example.demo.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {
    @Value("zexi9Mv3yoxtGLPuDKm5")
    private String naverClientId;
    @Value("jR2LchkMcO")
    private String naverClientSecret;
    @Value("https://openapi.naver.com/v1/search/local.json")
    private String naverLocalSearchUrl;
    @Value("https://openapi.naver.com/v1/search/image")
    private String naverImageSearchUrl;


    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq) {
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        //헤더 추가
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers); // 헤더 담는 부분
        var responseType = new ParameterizedTypeReference<SearchLocalRes>() {
        };

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody();
    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq) {
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        //헤더 추가
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers); // 헤더 담는 부분
        var responseType = new ParameterizedTypeReference<SearchImageRes>() {
        };

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody();
    }
}
