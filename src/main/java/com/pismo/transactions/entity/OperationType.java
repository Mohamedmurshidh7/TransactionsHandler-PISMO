package com.pismo.transactions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation_types")
public class OperationType {

    @Id
    private Long operationTypeId;

    @Column(nullable = false)
    private String description;

    public OperationType() {
    }

    public OperationType(Long operationTypeId, String description) {
        this.operationTypeId = operationTypeId;
        this.description = description;
    }

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
