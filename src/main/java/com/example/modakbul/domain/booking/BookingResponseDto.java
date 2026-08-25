package com.example.modakbul.domain.booking;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class BookingResponseDto {

    private Long id;
    private Long memberId;
    private Long campsiteId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int totalPrice;
    private String bookingStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Entity -> Response DTO 변환 생성자
    public BookingResponseDto(Booking booking) {
        this.id = booking.getId();
        this.memberId = booking.getMember().getId();
        this.campsiteId = booking.getCampsite().getId();
        this.checkInDate = booking.getCheckInDate();
        this.checkOutDate = booking.getCheckOutDate();
        this.totalPrice = booking.getTotalPrice();
        this.bookingStatus = booking.getBookingStatus();
        this.createdAt = booking.getCreatedAt();
        this.updatedAt = booking.getUpdatedAt();
    }
}