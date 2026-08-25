package com.example.modakbul.domain.payment;

import com.example.modakbul.domain.booking.Booking;
import com.example.modakbul.domain.user.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "payment",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_payment_idempotency", columnNames = {"idempotency_key"})
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private int amount; // 결제 금액

    @Column(length = 50)
    private String paymentMethod; // 결제 수단 (CARD, TRANSFER 등)

    @Column(nullable = false, length = 50)
    private String paymentStatus; // READY(준비), SUCCESS(성공), FAILED(실패), CANCELLED(취소)

    @Column(length = 255)
    private String pgPaymentKey; // PG사 승인 키

    @Column(nullable = false, length = 255)
    private String idempotencyKey; // 중복 결제 방지용 멱등성 키

    private LocalDateTime approveDate; // 결제 승인 일시

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public Payment(Booking booking, Member member, int amount, String paymentMethod, String paymentStatus, String pgPaymentKey, String idempotencyKey) {
        this.booking = booking;
        this.member = member;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.pgPaymentKey = pgPaymentKey;
        this.idempotencyKey = idempotencyKey;
    }

    // 결제 성공 처리 메서드
    public void successPayment(String pgPaymentKey, String paymentMethod) {
        this.paymentStatus = "SUCCESS";
        this.pgPaymentKey = pgPaymentKey;
        this.paymentMethod = paymentMethod;
        this.approveDate = LocalDateTime.now();
    }

    // 결제 실패 처리 메서드
    public void failPayment() {
        this.paymentStatus = "FAILED";
    }

    // 결제 취소 처리 메서드
    public void cancelPayment() {
        this.paymentStatus = "CANCELLED";
    }
}