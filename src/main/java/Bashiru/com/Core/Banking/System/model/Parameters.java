package Bashiru.com.Core.Banking.System.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Parameters {
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("account")
    private String account;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("msisdn")
    private String msisdn;

    public Parameters() {
    }



    @Override
    public String toString() {
        return "Parameters{" +
                "currency='" + currency + '\'' +
                ", account='" + account + '\'' +
                ", amount='" + amount + '\'' +
                ", msisdn='" + msisdn + '\'' +
                '}';
    }
}

