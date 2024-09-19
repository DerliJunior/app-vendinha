package com.api_vendinha.api.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class UserInactiveDto {

    private Boolean isActive;
}
