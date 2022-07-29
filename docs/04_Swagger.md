# Swagger 적용

> 전체 코드 적용 과정은 [github issue](https://github.com/jun108059/chat-server/issues/16) 에서 확인할 수 있습니다.

- springdoc 과 springfox 비교
- [springdoc 공식문서](https://springdoc.org/)를 참고해서 작성
- 작성일(22.07.30) 기준 최신버전 : springdoc-openapi v1.6.9

## 1. springdoc vs springfox

> 두 라이브러리 모두 Spring Framework를 사용하는 프로젝트에서 Swagger를 이용해 API 문서를 쉽게 쓸 수 있도록 해주는 라이브러리

- 2012 ~ 2015 : `Swagger SpringMVC` 이름으로 springfox 라이브러리가 많이 사용 됨
- 2015 ~ 2018 : `springfox-swagger` 업데이트가 활발히 이루어짐
- 2018 ~ 2020 : fox 업데이트가 진행되지 않아 `springdoc` 등장, 강세
- 2020 ~ 현재 : `springfox`도 다시 업데이트 시작하여 `springdoc` 비슷하게 활용 중

<img width="1166" alt="image" src="https://user-images.githubusercontent.com/42997924/181807257-846fbe25-4d5e-4a2a-b4fb-683fc9068d09.png">

(출처 : [Google Trends](https://trends.google.com/trends/explore?date=2019-06-10%202022-07-30&q=springfox,springdoc))

### 1-1. springdoc 선택

프로젝트에는 `springdoc`을 선택했다. 공식문서가 읽기 편했고, API 그룹핑 설정이 간단했다.

작성일 기준 더 활발히 업데이트 되고 있기도 했다.

## Swagger OpenAPI 3.0

- 라이브러리가 OpenAPI 3.0 스펙에 맞는 JSON을 자동으로 만들어 주면, Swagger UI는 만들어진 JSON을 화면에 표시 해준다.

![image](https://user-images.githubusercontent.com/42997924/181805315-d8f1abd3-c661-4e78-8ec3-f953f095b563.png)

(출처 : [springdoc 공식문서](https://springdoc.org/))

`springdoc-openapi-ui`를 살펴보면 swagger-ui를 포함하고 있는 것을 확인할 수 있다.

- `swagger-ui` : 핵심 로직 구현
- `springdoc-openapi` : swagger-ui를 추상화해서 더 잘 활용할 수 있게 해주는 라이브러리

## 2. 프로젝트에 적용

Gradle, yml 기반으로 적용했다.

### 2-1. dependency 추가

```groovy
// build.gradle 파일

dependencies {
    implementation 'org.springdoc:springdoc-openapi-ui:1.6.9'
}
```

### 2-2. yml 설정 추가

```yaml
springdoc:
  swagger-ui:
    path: /swagger-ui.html
    groups-order: DESC
    operationsSorter: method
    disable-swagger-default-url: true
    display-request-duration: true
  api-docs:
    path: /api-docs
  show-actuator: true
  default-consumes-media-type: application/json
  default-produces-media-type: application/json
  paths-to-match:
    - /v1/**
```

### 2-3. SwaggerConfig 설정 등록

```java
// SwaggerConfig.java
@OpenAPIDefinition(
        info = @Info(title = "채팅서비스 API 명세서",
                description = "헥사고날 아키텍처 기반 채팅 서비스 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
                .group("채팅서비스 API v1")
                .pathsToMatch(paths)
                .build();
    }
}
```

> 이후에 JWT 토큰 관련 정보도 여기에 추가해주면 좋다.

### 2-4. 컨트롤러에 적용

```java
// DeleteMemberController.java
@RestController
@RequiredArgsConstructor
public class DeleteMemberController {

    @Operation(summary = "회원 탈퇴 요청", description = "회원 정보가 삭제됩니다.", tags = { "Member Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = DeleteMemberResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping("/v1/member/{id}")
    ResponseEntity<DeleteMemberResponse> deleteMember(
            @Parameter(description = "회원 ID", required = true, example = "1") @PathVariable("id") Long id) {
        // 생략..
    }
}
```

## 3. 띄워서 확인

접근 URL : http://localhost:8080/swagger-ui.html

<img width="1297" alt="image" src="https://user-images.githubusercontent.com/42997924/181805001-585b27dd-6c56-43db-a70c-1c0d3fc591e6.png">

## 4. 정리

Code Base 에 Swagger 관련 코드가 많이 들어가게 되는 문제를 해결하기 위해 TDD에 더 익숙해지면 RestDoc으로 변경해보려고 한다.

최근에 스터디하면서 관련 내용을 논의한 적이 있는데, 어떤 분이 컨트롤러 인터페이스를 만들어서 Swagger 관련 내용을 인터페이스에 작성한 것을 봤는데 그것도 좋은 방법인 것 같다!

리펙터링할때 한번 적용해보면 좋을 것 같다.

**Reference**

- [springdoc 공식문서](https://springdoc.org/)
- [springfox-swagger 공식문서](http://springfox.github.io/springfox/docs/current/)
