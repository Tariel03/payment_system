package com.example.dd.mappers;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.dto.response.TransactionResponse;
import com.example.dd.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper mapper = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    Transaction toEntity(TransactionRequest transactionRequest);

    TransactionResponse toResponse(Transaction transaction);

    List<TransactionResponse> listToResponse(List<Transaction> transactionList);


}
