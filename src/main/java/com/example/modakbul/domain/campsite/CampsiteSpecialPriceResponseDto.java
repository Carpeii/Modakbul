package com.example.modakbul.domain.campsite;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CampsiteSpecialPriceResponseDto {

    private Long id;
    private Long campsiteId;
    private LocalDate targetDate;
    private int price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Entity -> Response DTO 변환 생성자
    public CampsiteSpecialPriceResponseDto(CampsiteSpecialPrice specialPriceEntity) {
        this.id = specialPriceEntity.getId();
        this.campsiteId = specialPriceEntity.getCampsite().getId();
        this.targetDate = specialPriceEntity.getTargetDate();
        this.price = specialPriceEntity.getPrice();
        this.createdAt = specialPriceEntity.getCreatedAt();
        this.updatedAt = specialPriceEntity.getUpdatedAt();
    }
}