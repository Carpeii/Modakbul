package com.example.modakbul.domain.campsite;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CampsiteSpecialPriceRequestDto {

    @NotNull(message = "사이트 ID는 필수입니다.")
    private Long campsiteId;

    @NotNull(message = "적용할 날짜는 필수입니다.")
    private LocalDate targetDate;

    @Min(value = 0, message = "가격은 0원 이상이어야 합니다.")
    private int price;
}