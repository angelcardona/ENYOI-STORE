package com.store.users.infrastructure.adapters.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String name;
    private String email;
    private String address;
    private String phone;

}
