package Bashiru.com.Core.Banking.System.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class Account implements Serializable {

    // private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Getter
    @Column(name = "ACCOUNT_STATUS")
    private String accountStatus;
    @Getter
    @Column(name = "ACCOUNT_BALANCE")
    private BigDecimal accountBalance;
    @Getter
    @Column(name = "ACCOUNT_CODE")
    private String accountCode;
    @Getter
    @Column(name = "CREATED_AT")
    private Instant createdAt;
    @Getter
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
     private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountCode='" + accountCode + '\'' +
                ", customer=" + customer +
                '}';
    }
}
