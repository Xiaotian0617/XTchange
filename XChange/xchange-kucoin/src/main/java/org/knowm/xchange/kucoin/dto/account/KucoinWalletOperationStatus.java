package org.knowm.xchange.kucoin.dto.account;

import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.FundingRecord.Status;

public enum KucoinWalletOperationStatus {
  SUCCESS(Status.COMPLETE),
  CANCEL(Status.CANCELLED),
  PENDING(Status.PROCESSING);
  
  private Status fundingRecordStatus;
  
  private KucoinWalletOperationStatus(Status fundingRecordStatus) {
    this.fundingRecordStatus = fundingRecordStatus;
  }

  public Status getFundingRecordStatus() {

    return fundingRecordStatus;
  }
}
