package site.huaya.search.db;

import org.springframework.data.jpa.repository.JpaRepository;
import site.huaya.search.bean.OrderInfo;
import site.huaya.search.bean.UserInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo,Integer> {

}
