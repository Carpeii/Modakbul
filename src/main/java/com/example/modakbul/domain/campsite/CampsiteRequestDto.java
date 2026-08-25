package com.example.modakbul.domain.campsite;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CampsiteRequestDto {

    @NotNull(message = "소속 캠핑장 ID는 필수입니다.")
    private Long campgroundId;

    @NotBlank(message = "사이트 이름은 필수입니다.")
    private String campsiteName; // 예: A구역 1번, 데크 3번 등

    @Min(value = 0, message = "평일 가격은 0원 이상이어야 합니다.")
    private int weekdayPrice;

    @Min(value = 0, message = "주말 가격은 0원 이상이어야 합니다.")
    private int weekendPrice;

    @Min(value = 1, message = "최대 수용 인원은 최소 1명 이상이어야 합니다.")
    private int maxCapacity;
}