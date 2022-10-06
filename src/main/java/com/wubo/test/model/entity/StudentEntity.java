package com.wubo.test.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@ToString
@TableName("t_student")
public class StudentEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 老师名字
     */
    private String tname;

    /**
     * 班级名字
     */
    private String cname;
}
