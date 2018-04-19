package site.huaya.search.db;

import org.springframework.data.jpa.repository.JpaRepository;
import site.huaya.search.bean.ConvertInfo;
import site.huaya.search.bean.UserInfo;

/**
 * 用户兑换记录
 */
public interface ConvertInfoRepository extends JpaRepository<ConvertInfo,Integer> {

}
