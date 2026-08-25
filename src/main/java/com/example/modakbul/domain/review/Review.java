package com.example.modakbul.domain.review;

import com.example.modakbul.domain.base.BaseEntity;
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
        name = "review",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_review_booking", columnNames = {"booking_id"})
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking; // 어떤 예약에 대한 리뷰인지 (1:1 관계)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // 리뷰를 작성한 회원

    @Column(length = 255)
    private String message; // 리뷰 내용

    private Integer rating; // 평점 (예: 1 ~ 5점)

    @Builder
    public Review(Booking booking, Member member, String message, Integer rating) {
        this.booking = booking;
        this.member = member;
        this.message = message;
        this.rating = rating;
    }

    // 리뷰 수정 메서드 (비즈니스 로직 캡슐화)
    public void updateReview(String message, Integer rating) {
        this.message = message;
        this.rating = rating;
    }
}