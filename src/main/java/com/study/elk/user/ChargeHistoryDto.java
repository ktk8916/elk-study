package com.study.elk.user;

import java.time.LocalDateTime;

    public class ChargeHistoryDto {
        private int chargeHistoryId;
        private int userSeq;
        private int chargePrice;
        private LocalDateTime chargeDate;

        public ChargeHistoryDto(int chargeHistoryId, int userSeq, int chargePrice, LocalDateTime chargeDate) {
            this.chargeHistoryId = chargeHistoryId;
            this.userSeq = userSeq;
            this.chargePrice = chargePrice;
            this.chargeDate = chargeDate;
        }

        public int getChargeHistoryId() {
            return chargeHistoryId;
        }

        public void setChargeHistoryId(int chargeHistoryId) {
            this.chargeHistoryId = chargeHistoryId;
        }

        public int getUserSeq() {
            return userSeq;
        }

        public void setUserSeq(int userSeq) {
            this.userSeq = userSeq;
        }

        public int getChargePrice() {
            return chargePrice;
        }

        public void setChargePrice(int chargePrice) {
            this.chargePrice = chargePrice;
        }

        public LocalDateTime getChargeDate() {
            return chargeDate;
        }

        public void setChargeDate(LocalDateTime chargeDate) {
            this.chargeDate = chargeDate;
        }

        @Override
        public String toString() {
            return "ChargeHistoryDto{" +
                    "chargeHistoryId=" + chargeHistoryId +
                    ", userSeq=" + userSeq +
                    ", chargePrice=" + chargePrice +
                    ", chargeDate=" + chargeDate +
                    '}';
        }
    }
}
