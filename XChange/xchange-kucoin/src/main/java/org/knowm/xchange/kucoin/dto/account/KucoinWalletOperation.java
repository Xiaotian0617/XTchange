package org.knowm.xchange.kucoin.dto.account;

import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.FundingRecord.Type;

public enum KucoinWalletOperation {

  DEPOSIT(Type.DEPOSIT),
  WITHDRAW(Type.WITHDRAWAL);
  
  private Type fundingRecordType;

  private KucoinWalletOperation(Type fundingRecordType) {
    this.fundingRecordType = fundingRecordType;
  }

  public Type getFundingRecordType() {
    return fundingRecordType;
  }
  
  public static KucoinWalletOperation fromFundingRecordType(Type fundingRecordType) {
    switch(fundingRecordType) {
      case DEPOSIT:
        return DEPOSIT;
      case WITHDRAWAL:
        return WITHDRAW;
      default:
        throw new RuntimeException("Unsupported FundingRecord.Type " + fundingRecordType);
    }
  }
}
