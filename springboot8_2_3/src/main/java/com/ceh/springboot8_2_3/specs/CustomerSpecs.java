package com.ceh.springboot8_2_3.specs;

import static com.google.common.collect.Iterables.toArray;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by enHui.Chen on 2017/9/20.
 */
public class CustomerSpecs {
     /**
       * @Author: enHui.Chen
       * @Description: 定义一个返回值类型为Specification的方法，接收任意类型的实体类
       * @Data 2017/9/20
       */
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        final Class<T> type = (Class<T>) example.getClass();// 获得当前实体类的CLASS
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();// 创建集合，用于存放构造好的查询条件
                EntityType<T> entityType = entityManager.getMetamodel().entity(type);// 创建实体类的EntityType，可以从该类获取实体类的属性
                for (Attribute<T, ?> attr : entityType.getDeclaredAttributes()) {// 循环实体类的属性
                    Object attrValue = ReflectionUtils.getField((Field) attr.getJavaMember(), example);// 获取实例属性的属性值
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {// 判断属性的数据类型
                            if (!StringUtils.isEmpty(attrValue)) {// 判断是否为空字符串 不为空是false
                                predicates.add(
                                        criteriaBuilder.like(root.get(attribute(entityType, attr.getName(),String.class)), "%" + attrValue + "%")
                                );// 构造字符串不为空时的LIKE查询条件
                            }
                        } else {
                            predicates.add(
                                    criteriaBuilder.equal(root.get(attribute(entityType, attr.getName(), attrValue.getClass())), attrValue)
                            );// 构造除了字符类型外的等于查询条件
                        }
                    }
                }
                return predicates.isEmpty()?criteriaBuilder.conjunction():criteriaBuilder.and(toArray(predicates,Predicate.class));
            }

            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entityType, String fieldName, Class<E> fieldClass) {
                return entityType.getDeclaredSingularAttribute(fieldName, fieldClass);
            }
        };
    }
}
