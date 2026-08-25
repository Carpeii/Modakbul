package com.example.modakbul.domain.booking;

import com.example.modakbul.domain.campsite.Campsite;
import com.example.modakbul.domain.user.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campsite_id", nullable = false)
    private Campsite campsite;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false, length = 50)
    private String bookingStatus; // PENDING_PAYMENT(결제대기), CONFIRMED(예약확정), CANCELLED(취소)

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public Booking(Member member, Campsite campsite, LocalDate checkInDate, LocalDate checkOutDate, int totalPrice, String bookingStatus) {
        this.member = member;
        this.campsite = campsite;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    // 비즈니스 로직 캡슐화 (상태 변경 메서드)
    public void confirmBooking() {
        this.bookingStatus = "CONFIRMED";
    }

    public void cancelBooking() {
        this.bookingStatus = "CANCELLED";
    }
}