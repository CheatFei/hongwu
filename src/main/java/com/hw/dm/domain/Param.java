package com.hw.dm.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class Param {

    @NotBlank(message = "name不能为空")
    private String name;
}
