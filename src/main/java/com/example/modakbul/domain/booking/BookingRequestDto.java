package com.example.modakbul.domain.booking;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BookingRequestDto {

    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;

    @NotNull(message = "캠핑장 사이트 ID는 필수입니다.")
    private Long campsiteId;

    @NotNull(message = "체크인 날짜는 필수입니다.")
    private LocalDate checkInDate;

    @NotNull(message = "체크아웃 날짜는 필수입니다.")
    private LocalDate checkOutDate;

    @NotNull(message = "총 결제 금액은 필수입니다.")
    private int totalPrice;
}