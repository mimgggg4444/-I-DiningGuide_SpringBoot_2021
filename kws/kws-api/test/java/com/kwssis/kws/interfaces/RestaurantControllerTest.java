package com.kwssis.kws.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration   // 오류 해결 방법. <실패.>이거 설정 안하면 위험 메시지 뜬다.





@ExtendWith(SpringExtension.class)  // 전에 사용되던 RunWith가 사라짐. (https://www.whiteship.me/springboot-no-more-runwith/)



//@AutoConfigureMockMvc   // 이건 뭔지 모름. ctrl + clt + o 누르면 안쓰는거 다 삭제됨.
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))    // 여기 오류요~ <해결> -> 내가 import를 잘못해옴.

                .andExpect(content().string(containsString("\"id\":1")));

    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("\"id\":1")));
        mvc.perform(get("/restaurants/2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")))
                .andExpect(content().string(containsString("\"id\":2")));
    }
}