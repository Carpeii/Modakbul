package com.example.modakbul.domain.campground;

import com.example.modakbul.domain.base.BaseEntity;
import com.example.modakbul.domain.user.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "campground")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Campground extends BaseEntity { // extends BaseEntity 추가!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private Member host; // 캠핑장을 등록한 호스트(회원)

    @Column(nullable = false, length = 255)
    private String campgroundName; // 캠핑장 이름

    @Column(nullable = false, length = 255)
    private String address; // 기본 주소

    @Column(length = 255)
    private String detailAddress; // 상세 주소

    @Column(length = 255)
    private String phone; // 캠핑장 연락처

    @Builder
    public Campground(Member host, String campgroundName, String address, String detailAddress, String phone) {
        this.host = host;
        this.campgroundName = campgroundName;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;
    }

    // 캠핑장 정보 수정 메서드 (비즈니스 로직 캡슐화)
    public void updateCampground(String campgroundName, String address, String detailAddress, String phone) {
        this.campgroundName = campgroundName;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;
    }
}