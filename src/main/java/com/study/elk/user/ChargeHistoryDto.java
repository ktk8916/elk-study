package com.study.elk.user;

import java.time.LocalDateTime;

    public class ChargeHistoryDto {
        private int userSeq;
        private int chargePrice;

        public ChargeHistoryDto(int userSeq, int chargePrice) {
            this.userSeq = userSeq;
            this.chargePrice = chargePrice;
        }

        public int getUserSeq() {
            return userSeq;
        }

        public int getChargePrice() {
            return chargePrice;
        }
    }

