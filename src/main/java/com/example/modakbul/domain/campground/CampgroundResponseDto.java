package com.example.modakbul.domain.campground;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CampgroundResponseDto {

    private Long id;
    private Long hostId;
    private String campgroundName;
    private String address;
    private String detailAddress;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Entity -> Response DTO 변환 생성자
    public CampgroundResponseDto(Campground campground) {
        this.id = campground.getId();
        this.hostId = campground.getHost().getId();
        this.campgroundName = campground.getCampgroundName();
        this.address = campground.getAddress();
        this.detailAddress = campground.getDetailAddress();
        this.phone = campground.getPhone();
        this.createdAt = campground.getCreatedAt();
        this.updatedAt = campground.getUpdatedAt();
    }
}