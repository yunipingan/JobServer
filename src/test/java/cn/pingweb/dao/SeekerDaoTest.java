package cn.pingweb.dao;

import cn.pingweb.App;
import cn.pingweb.model.Seeker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import static org.junit.Assert.*;

/**
 * @author zhuyuping
 * @date 2018/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
@WebAppConfiguration
@MapperScan("cn.pingweb.dao")
public class SeekerDaoTest {

    @Autowired
    private SeekerDao seekerDao;

    @Test
    public void selectFromOpenid() throws Exception {

    }

    @Test
    public void newSeeker() throws Exception {
        Seeker seeker = new Seeker();
        seeker.setOpenid("testOpenId");
        seekerDao.newSeeker(seeker);
    }

    @Test
    public void getUserInfo() throws Exception {

    }

    @Test
    public void updateSeeker() throws Exception {

    }

    @Test
    public void updateAvatar() throws Exception {

    }

    @Test
    public void updateSeekerName() throws Exception {

    }

    @Test
    public void updateHope_job() throws Exception {

    }

}