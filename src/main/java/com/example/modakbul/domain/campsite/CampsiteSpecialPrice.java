package com.example.modakbul.domain.campsite;

import com.example.modakbul.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "campsite_special_price")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CampsiteSpecialPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campsite_id", nullable = false)
    private Campsite campsite; // 어떤 사이트의 일별 특별 요금인지

    @Column(nullable = false)
    private LocalDate targetDate; // 적용할 특정 날짜 (예: 2026-07-25)

    @Column(nullable = false)
    private int price; // 해당 날짜의 적용 가격

    @Builder
    public CampsiteSpecialPrice(Campsite campsite, LocalDate targetDate, int price) {
        this.campsite = campsite;
        this.targetDate = targetDate;
        this.price = price;
    }

    // 일별 가격 수정 메서드
    public void updateSpecialPrice(LocalDate targetDate, int price) {
        this.targetDate = targetDate;
        this.price = price;
    }
}