package com.example.modakbul.domain.campsite;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CampsiteResponseDto {

    private Long id;
    private Long campgroundId;
    private String campsiteName;
    private int weekdayPrice;
    private int weekendPrice;
    private int maxCapacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Entity -> Response DTO 변환 생성자
    public CampsiteResponseDto(Campsite campsite) {
        this.id = campsite.getId();
        this.campgroundId = campsite.getCampground().getId();
        this.campsiteName = campsite.getCampsiteName();
        this.weekdayPrice = campsite.getWeekdayPrice();
        this.weekendPrice = campsite.getWeekendPrice();
        this.maxCapacity = campsite.getMaxCapacity();
        this.createdAt = campsite.getCreatedAt();
        this.updatedAt = campsite.getUpdatedAt();
    }
}