package com.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복기능테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //assertj 테스트 검증 라이브러리의 메소드 assertThat(검증하고싶은 대상) 사용
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}