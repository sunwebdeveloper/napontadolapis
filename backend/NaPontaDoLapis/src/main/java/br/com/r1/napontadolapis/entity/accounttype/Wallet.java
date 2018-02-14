package br.com.r1.napontadolapis.entity.accounttype;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.r1.napontadolapis.entity.Account;
import br.com.r1.napontadolapis.entity.Client;

@Entity
public class Wallet implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@NotNull
	private Account account;
	
	@NotNull
	@Min(value=0)
	private BigDecimal value;
	
	@Version
	private Integer version;
	
	public BigDecimal getValue() {
		return value;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Set<Client> getClients(){
		return this.account.getClients();
	}

	@Override
	public String toString() {
		return "Wallet ["
				+ "id=" + id 
				+ ", account =" + account 
				+ ", value=" + value 
				+ ", version=" + version 
				+ "]";
	}
	
	
}
