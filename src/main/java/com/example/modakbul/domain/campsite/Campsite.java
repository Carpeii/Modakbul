package com.example.modakbul.domain.campsite;

import com.example.modakbul.domain.campground.Campground;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "campsite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Campsite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campground_id", nullable = false)
    private Campground campground; // 소속 캠핑장

    @Column(nullable = false, length = 255)
    private String campsiteName; // 사이트 이름 (예: A구역 1번, 데크 3번 등)

    @Column(nullable = false)
    private int weekdayPrice; // 평일 기본가

    @Column(nullable = false)
    private int weekendPrice; // 주말 기본가

    @Column(nullable = false)
    private int maxCapacity; // 최대 수용 인원

    @Builder
    public Campsite(Campground campground, String campsiteName, int weekdayPrice, int weekendPrice, int maxCapacity) {
        this.campground = campground;
        this.campsiteName = campsiteName;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.maxCapacity = maxCapacity;
    }

    // 사이트 기본 정보 수정 메서드
    public void updateCampsite(String campsiteName, int weekdayPrice, int weekendPrice, int maxCapacity) {
        this.campsiteName = campsiteName;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.maxCapacity = maxCapacity;
    }
}