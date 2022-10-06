package com.wubo.test.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@ToString
@TableName("t_teacher")
public class TeacherEntity {
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

    /**
     * 学校
     */
    private String edu;

}
