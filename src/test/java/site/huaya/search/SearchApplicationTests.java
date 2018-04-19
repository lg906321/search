package site.huaya.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.huaya.search.bean.OrderInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchApplicationTests {

	@Test
	public void contextLoads() {


	}

	@Test
	public void createOutTradeNo(){

		String outTradeNo = OrderInfo.createOutTradeNo();
	}

}
