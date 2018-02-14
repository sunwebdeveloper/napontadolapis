package br.com.r1.napontadolapis.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.r1.napontadolapis.entity.enums.AccountType;

@Entity
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NotNull
	private AccountType type;

	@ManyToMany()
	@NotEmpty
	private Set<Client> clients;

	@OneToMany(mappedBy = "account")
	private List<Transaction> billsToPay;

	@OneToMany(mappedBy = "account")
	private List<Transaction> billsToReceive;
	
	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public List<Transaction> getBillsToPay() {
		return billsToPay;
	}

	public void setBillsToPay(List<Transaction> billsToPay) {
		this.billsToPay = billsToPay;
	}

	public List<Transaction> getBillsToReceive() {
		return billsToReceive;
	}

	public void setBillsToReceive(List<Transaction> billsToReceive) {
		this.billsToReceive = billsToReceive;
	}

	@Override
	public String toString() {
		return "Account ["
				+ "id=" + id 
				+ ", type=" + type 
				+ ", clients=" + clients 
				+ ", version=" + version
				+ "]";
	}
}