package com.example.modakbul.domain.campground;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CampgroundRequestDto {

    @NotNull(message = "호스트 회원 ID는 필수입니다.")
    private Long hostId;

    @NotBlank(message = "캠핑장 이름은 필수입니다.")
    private String campgroundName;

    @NotBlank(message = "기본 주소는 필수입니다.")
    private String address;

    private String detailAddress;

    private String phone;
}