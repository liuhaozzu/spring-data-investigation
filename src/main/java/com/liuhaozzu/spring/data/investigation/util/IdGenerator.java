package com.liuhaozzu.spring.data.investigation.util;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class IdGenerator implements IdentifierGenerator{
    Long count =1L;
    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
        System.out.println(sessionImplementor);
        Serializable value = getFieldValueByAnnotation(o, Id.class);
        if (null != value) {
            return value;
        }
        return count++;
    }

    private Serializable getFieldValueByAnnotation(Object o, Class<Id> idClass) {
        if (o == null) {
            return null;
        }
        if (idClass == null) {
            throw new IllegalArgumentException("");
        }
        List<Field> fieldList = FieldUtils.getFieldsListWithAnnotation(o.getClass(), idClass);
        Serializable value = null;
        if (!fieldList.isEmpty()) {
            Field id = fieldList.get(0);
            if (!id.isAccessible()) {
                id.setAccessible(true);
            }
            try {
                value = (Serializable) id.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
