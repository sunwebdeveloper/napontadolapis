package br.com.r1.napontadolapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.r1.napontadolapis.entity.accounttype.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
