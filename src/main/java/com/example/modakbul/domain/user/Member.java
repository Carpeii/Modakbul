package com.example.modakbul.domain.user;

import com.example.modakbul.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "member",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_member_user_id", columnNames = {"user_id"})
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String userId; // 로그인 아이디

    @Column(nullable = false, length = 255)
    private String password; // 비밀번호

    @Column(nullable = false, length = 255)
    private String userName; // 회원 이름

    @Column(nullable = false, length = 255)
    private String phone; // 연락처

    @Column(nullable = false, length = 255)
    private String mail; // 이메일

    @Column(nullable = false, length = 50)
    private String role; // USER, HOST, ADMIN

    @Builder
    public Member(String userId, String password, String userName, String phone, String mail, String role) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.mail = mail;
        this.role = role;
    }

    // 회원 정보 수정 메서드
    public void updateMember(String userName, String phone, String mail) {
        this.userName = userName;
        this.phone = phone;
        this.mail = mail;
    }

    // 권한 승격 메서드 (USER -> HOST 등)
    public void updateRole(String role) {
        this.role = role;
    }
}