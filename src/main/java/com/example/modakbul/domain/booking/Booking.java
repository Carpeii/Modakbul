package com.example.modakbul.domain.booking;

import com.example.modakbul.domain.base.BaseEntity;
import com.example.modakbul.domain.campsite.Campsite;
import com.example.modakbul.domain.user.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking extends BaseEntity { // extends BaseEntity 추가!

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
    private String bookingStatus; // PENDING_PAYMENT, CONFIRMED, CANCELLED

    @Builder
    public Booking(Member member, Campsite campsite, LocalDate checkInDate, LocalDate checkOutDate, int totalPrice, String bookingStatus) {
        this.member = member;
        this.campsite = campsite;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    public void confirmBooking() {
        this.bookingStatus = "CONFIRMED";
    }

    public void cancelBooking() {
        this.bookingStatus = "CANCELLED";
    }
}