package com.merchen.beautilscopy;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;


/**
 * 测试映射关系
 */
@Slf4j
@SpringBootTest
public class BeaUtilscopyApplicationTests {
    @Data
    public class A{

        String FIRSTNAME;

        public A() {
        }
        public A(String FIRSTNAME) {
            this.FIRSTNAME = FIRSTNAME;
        }
    }
    @Data
    public class B{

        String firstName;

        public B() {
        }

        public B(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @Override
        public String toString() {
            return "B{" +
                    "firstName='" + firstName + '\'' +
                    '}';
        }
    }
    @Test
    public void contextLoads() throws IllegalAccessException {
        A a = new A("hello");
        //获取A所有的class的fields
        Field[] fields = A.class.getDeclaredFields();
        //获取第三方接口的class的fields
        Field[] fieldsB = B.class.getDeclaredFields();
        B b = new B("");
        //比对
        for (Field field : fields) {
            String name = field.getName();
            for (Field field1 : fieldsB) {
                if(field1.getName().equalsIgnoreCase(name)){
                    Object o = field.get(a);
                    field1.setAccessible(true);
                    field1.set(b,o);
                }
            }
        }
        System.out.println(JSON.toJSONString(b));
    }
}
