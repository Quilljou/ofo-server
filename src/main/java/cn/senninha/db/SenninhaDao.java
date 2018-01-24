package cn.senninha.db;

import java.lang.annotation.*;

/**
 * 标注要被注册进DbManager的Dao
 * Coded by senninha on 18-1-20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface SenninhaDao {

}
