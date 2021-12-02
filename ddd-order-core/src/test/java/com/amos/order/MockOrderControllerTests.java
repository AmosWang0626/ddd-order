package com.amos.order;

import com.amos.order.api.OrderController;
import com.amos.order.app.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Mock Controller Tests
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/21
 * @see <a href="https://spring.io/guides/gs/testing-web/">https://spring.io/guides/gs/testing-web/</a>
 */
@Slf4j
@WebMvcTest(OrderController.class)
public class MockOrderControllerTests {

    @Resource
    private MockMvc mockMvc;
    @MockBean
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        String name = "Amos Order";
//        when(orderService.create(new Order())).thenReturn(true);

        MvcResult mvcResult = mockMvc.perform(get("/").param("name", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " >>>>>> [{}]",
                mvcResult.getResponse().getContentAsString());
    }

}
