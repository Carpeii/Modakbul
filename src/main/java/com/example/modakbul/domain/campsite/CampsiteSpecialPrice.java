package com.example.modakbul.domain.campsite;

import com.example.modakbul.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(
        name = "campsite_special_price",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_campsite_target_date", columnNames = {"campsite_id", "target_date"})
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CampsiteSpecialPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campsite_id", nullable = false)
    private Campsite campsite;

    @Column(nullable = false)
    private LocalDate targetDate; // 가격 변동 적용 일자 (예: 성수기, 공휴일 등)

    @Column(nullable = false)
    private int overridePrice; // 변경될 특수 가격

    @Builder
    public CampsiteSpecialPrice(Campsite campsite, LocalDate targetDate, int overridePrice) {
        this.campsite = campsite;
        this.targetDate = targetDate;
        this.overridePrice = overridePrice;
    }

    // 특수 가격 수정 메서드
    public void updateOverridePrice(int overridePrice) {
        this.overridePrice = overridePrice;
    }
}