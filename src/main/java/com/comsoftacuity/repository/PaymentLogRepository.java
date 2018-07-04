package com.comsoftacuity.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.comsoftacuity.entity.PaymentLog;

public interface PaymentLogRepository extends CrudRepository<PaymentLog, Integer>, JpaSpecificationExecutor<PaymentLog> {

}
