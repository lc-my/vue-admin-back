package com.lc.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @auth liuchong
 * @data 2019-07-03 10:53
 **/
@Table(name = "v_user")
@Entity()
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @Column(name = "user_name",length = 120)
    private String userName;

    @Column(name = "password",length = 60)
    private String password;


    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column()
    @Temporal(TemporalType.DATE)
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    @Column(name = "address",length = 150)
    private String address;
}
