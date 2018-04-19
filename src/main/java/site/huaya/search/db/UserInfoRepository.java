package site.huaya.search.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.huaya.search.bean.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    @Query("select u from UserInfo u where u.uid= :uid")
    UserInfo findByUid(@Param("uid") String uid);

}
