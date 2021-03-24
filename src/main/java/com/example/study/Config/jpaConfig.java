package com.example.study.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration  //여기는 설정파일이 들어갑니다. 라는 뜻.
@EnableJpaAuditing  //감시 활성화.
public class jpaConfig {

}
