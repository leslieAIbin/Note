package com.sxt.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
    * 用户编号
    */
    private Integer id;

    /**
    * 用户姓名
    */
    private String name;

    /**
    * 用户地址
    */
    private String address;

    /**
    * 出生时间
    */
    private Date birth;

    /**
    * 是否删除1删除0未删除
    */
    private Integer flag;

    private static final long serialVersionUID = 1L;
}