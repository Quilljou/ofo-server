package cn.senninha.db;

import cn.senninha.db.dao.TestDao;
import cn.senninha.db.entity.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * DB管理
 * Coded by senninha on 18-1-20
 */
public class DbManager {
    private static DbManager instance;
    private Logger logger = LoggerFactory.getLogger(DbManager.class);
    private SqlSessionFactory factory;
    private Map<Class<Object>, Object> daoContainer;

    /**
     * 单例获取
     * @return
     */
    private static DbManager getInstance() {
        if (instance == null) {
            synchronized (DbManager.class) {
                if (instance == null) {
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }

    private DbManager() {
        init();
    }

    /**
     * 初始化数据库
     */
    private void init() {
        try {
            String uri = DbManager.class.getResource("/").toString();
            uri = uri.substring(uri.indexOf(":") + 1);
            FileInputStream is = new FileInputStream(uri + "db/dbConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
            daoContainer = new HashMap<>();
        } catch (Exception e) {
            logger.error("加载数据库错误" + e.toString());
            System.exit(-1);
        }
    }

    /**
     * 获取Session
     * @param autoCommit
     * @return
     */
    public static SqlSession openSession(boolean autoCommit){
        return getInstance().factory.openSession(autoCommit);
    }

    public static void main(String[] args){
        TestDao dao = openSession(false).getMapper(TestDao.class);
        Test test = dao.selectOne(2);
        test.setId(4);
        int i = dao.update(test);
        i = dao.delete(2);
        i = dao.delete(4);
    }
}
