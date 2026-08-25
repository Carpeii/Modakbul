package com.example.modakbul.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "host")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Host {

    @Id
    private Long id; // Member의 id를 PK이자 FK로 사용

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // Member의 PK를 Host의 PK로 매핑
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 50)
    private String businessRegistrationNumber; // 사업자 등록 번호

    @Column(nullable = false, length = 50)
    private String bankName; // 정산 은행

    @Column(nullable = false, length = 100)
    private String accountNumber; // 계좌 번호

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public Host(Member member, String businessRegistrationNumber, String bankName, String accountNumber) {
        this.member = member;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    // 호스트 정산 정보 수정 메서드
    public void updateHostInfo(String businessRegistrationNumber, String bankName, String accountNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }
}